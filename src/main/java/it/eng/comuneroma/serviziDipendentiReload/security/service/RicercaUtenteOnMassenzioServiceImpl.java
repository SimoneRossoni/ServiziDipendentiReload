package it.eng.comuneroma.serviziDipendentiReload.security.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

@Service("ricercaUtenteOnMassenzioService")
public class RicercaUtenteOnMassenzioServiceImpl implements RicercaUtenteOnMassenzioService{

	public byte[] getXMLPersona(String username)
	{
		byte[] responseBody = null;
		
		String url = "http://localhost:9080/b2b/ENG_UserInfo";
		String parametri = "?appCode=006&int=1&uid=" + username;
		
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url.concat(parametri));

		// add request header
		//request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response;
		try {
			response = client.execute(request);
			
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

//			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//			StringBuffer result = new StringBuffer();
//			String line = "";
//			while ((line = rd.readLine()) != null) {
//				result.append(line);
//			}
				
			//BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			BufferedInputStream bis = new BufferedInputStream(response.getEntity().getContent());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] bytes = new byte[8192];
			int count = bis.read(bytes);
			
			while (count != -1 && count <= 8192) {
				baos.write(bytes, 0, count);
				count = bis.read(bytes);
			}
			responseBody = baos.toByteArray();
			baos.close();
			bis.close();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}


		
		
		return responseBody;
	}
}

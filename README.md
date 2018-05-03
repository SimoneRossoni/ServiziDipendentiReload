#Check out Progetto su eclipse
  1) Aprire eclipse poi menu File -> Import -> Git -> Project from Git -> Clone URI
     Nella schermata inserire i seguenti valori:
     URI: https://github.com/SimoneRossoni/ServiziDipendentiReload (automaticamente saranno valorizzati anche i campi host e     repository path 
     User: SimoneRossoni
     Password: pallone1980
     Cliccare sul tasto Next
  2) Scegliere il branch e cioè master (l'unico esistente tra l'altro creato di default)
     Cliccare sul tasto Next
  3) Scegliere la directory dove sarà salvato il progetto (questa directory rappresenta il repository GIT)
     Io ho usato: C:\Users\simone\git\ServiziDipendentiReload
     Cliccare sul tasto Next
  4) Selezionare l'opzione: Import as general project
     Cliccare sul tasto Next
  5) Nell'ultima schermata cliccare solo sul tasto finish
  6) Il progetto viene scaricato ma deve essere convertito in un progetto Maven
     Quindi tasto destro sul progetto -> configure -> Convert to Maven Project...
     
     
#Gestione conflitti
   1) Quando viene eseguita una pull (ossia prendere le modifiche dal repository remoto) possono verificarsi dei conflitti.
      Il file in conflitto sarà modificato con entrambe le modifiche (quelle in locale e quelle del repository remoto)
      Quindi manualmente modificare il file rieseguire la push sul repository remoto

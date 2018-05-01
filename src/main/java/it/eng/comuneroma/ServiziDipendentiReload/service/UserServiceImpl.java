package it.eng.comuneroma.ServiziDipendentiReload.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eng.comuneroma.ServiziDipendentiReload.entity.User;
import it.eng.comuneroma.ServiziDipendentiReload.repository.UserRepository;
 
 
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserRepository userRepository;
 
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
 
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
 
    public void saveUser(User user) {
        userRepository.save(user);
    }
 
    public void updateUser(User user){
        saveUser(user);
    }
 
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
 
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
 
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }
 
}
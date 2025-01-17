package com.contact.Service;

import com.contact.Model.Contact;
import com.contact.Model.User;
import com.contact.Repository.ContactRepository;
import com.contact.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
private ContactRepository contactRepository;

    //    User insert Database
    @Override
    public boolean UserInsertDataService(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }catch (Exception e){
          return false;
        }
        return true;
    }

    @Override
    public User UserUpdateDataService(Integer UserID) {
        return null;
    }

    @Override
    public User UserDeleteDataService(Integer UserID) {
        return null;
    }

    @Override
    public User GetUserDataService(Integer UserID) {
        return null;
    }

    @Override
    public List<User> GetAllUserDataService() {
        return List.of();
    }

     @Override
    public User FindByUserNameService(String username) {
        return userRepository.FindByUserNameService(username);
    }

//user All contact method


    @Override
    public Contact ContactInsertDataService(Contact contact) {
        return   contactRepository.save(contact);
    }
}

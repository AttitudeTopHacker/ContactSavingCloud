package com.contact.Service;

import com.contact.Model.Contact;
import com.contact.Model.User;

import java.util.List;

public interface UserServiceInterface {
    boolean UserInsertDataService(User user);
    User UserUpdateDataService(Integer UserID);
    User UserDeleteDataService(Integer UserID);
    User GetUserDataService(Integer UserID);
    List<User> GetAllUserDataService();
    User FindByUserNameService(String username);
    Contact ContactInsertDataService(Contact contact);
//    List<Contact> GetAllContactDataService();

}

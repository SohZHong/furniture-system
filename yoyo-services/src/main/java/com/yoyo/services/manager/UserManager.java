package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.common.constant.RoleConstants;
import com.yoyo.services.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManager {
    private final FileManager fileManager = new FileManager(DataConstants.USER_CREDENTIAL_FILE);
    
    private ArrayList<User> users;
    private int lines;
    
    public UserManager(){
        users = new ArrayList<>();
    }
    
    //Outside of constructor to avoid conflict when overwriting content
    public void loadUsers() throws IOException{
        //Load Contents into array
        fileManager.readFile();
        
        lines = fileManager.contentLength();
        if (users == null){
            users = new ArrayList<>(lines); //Assigning capacity based on number of entries
        }
        else {
            users.clear(); //Delete any existing contents for memory optimization
        }

        for (int i = 0; i < lines; i++){
            try {
                String[] content = fileManager.readLine(i);
                users.add(
                    new User(
                        content[0], 
                        content[1], 
                        content[2]
                    )
                );   
            }
            // Stop operation if data error occurs
            catch (NumberFormatException e) {
                break;
            }
        }   
    }
    
    public ArrayList<User> getUsers(){
      return users;
    }
    
    public void addUsers(User newUser){
        users.add(newUser);
    }
    
    public void saveUsers(){
        try {
            //Clear contents of file before writing
            fileManager.clearFile();

            for (int i = 0; i < users.size(); i++){

                User user = users.get(i);
                String[] data = new String[3];

                data[0] = user.getName();
                data[1] = user.getPassword();
                data[2] = user.getRole();
                fileManager.writeFile(data, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getRoles(){
        ArrayList<String> roles = new ArrayList<>();
        roles.add(RoleConstants.ADMINISTRATOR_ROLE);
        roles.add(RoleConstants.OFFICE_ROLE);
        roles.add(RoleConstants.SALESPERSON_ROLE);
        
        return roles;
    }
    
    public User login(String username, String password){
        for (User user: users){
            if (username.equals(user.getName()) && password.equals(user.getPassword())) {
            // Successful login
                return user;
            }
        }
        // Failed login
        return null;
    }
}

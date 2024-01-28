package com.yoyo.services.manager;

import com.yoyo.common.constant.DataConstants;
import com.yoyo.common.constant.FilterConstants;
import com.yoyo.common.constant.RoleConstants;
import com.yoyo.common.utils.SecurityUtils;
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
                        content[2],
                        content[3]
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
    
    public void updateUsers(User updatedUser){
        try {
            fileManager.clearFile();
            for (int i = 0; i < users.size(); i++){
                User user = users.get(i);
                String[] data = new String[4];
                if(i == findUserIndex(updatedUser)){
                    System.out.print("true");
                    data[0] = updatedUser.getName();
                    data[1] = updatedUser.getPassword();
                    data[2] = updatedUser.getPhoneNumber();
                    data[3] = updatedUser.getRole();
                }else{
                    data[0] = user.getName();
                    data[1] = user.getPassword();
                    data[2] = user.getPhoneNumber();
                    data[3] = user.getRole();
                }
                fileManager.writeFile(data, true);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveUsers(){
        try {
            //Clear contents of file before writing
            fileManager.clearFile();

            for (int i = 0; i < users.size(); i++){

                User user = users.get(i);
                String[] data = new String[4];
                data[0] = user.getName();
                data[1] = user.getPassword();
                data[2] = user.getPhoneNumber();
                data[3] = user.getRole();
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
        String decryptedPassword;
        for (User user: users){
            // decrypt base64 password
            decryptedPassword = SecurityUtils.decodeBase64Format(user.getPassword());
            System.out.print(decryptedPassword);
            if (username.equals(user.getName()) && password.equals(decryptedPassword)) {
            // Successful login
                return user;
            }
        }
        // Failed login
        return null;
    }
    
    public User validateUser(String username, String phoneNumber){
        for (User user: users){
            if (username.equals(user.getName()) && phoneNumber.equals(user.getPhoneNumber())) {
            // User found
                return user;
            }
        }
        // when user does not exist
        return null;
    }

     public String changeCredentials(String username, String password) {
        // Check whether username has been repeated
        User loginUser = ApplicationContext.getLoginUser();
        for (User user : users) {
            String[] currentCredentials = fileManager.readLine(findUserIndex(loginUser));
            if (username.equals(loginUser.getName())){
                // if the current login user hasn't change name, set as true
                return "true";
            }else if(username.equals(user.getName()) ){
                return "Username has been used. Please try another one.";
            }
        }

        // Check username and password against regex
        if (username.matches(FilterConstants.USERNAME_REGEX) && password.matches(FilterConstants.PASSWORD_REGEX)) {
            return "true";
        } else if (!username.matches(FilterConstants.USERNAME_REGEX)) {
            return "Please make sure there's no number in username.";
        } else if (!password.matches(FilterConstants.PASSWORD_REGEX)) {
            return "Please make sure the password is longer than 6 characters.";
        } else {
            return "Please make sure there's no number in username and the password is longer than 6 characters.";
        }
    }
    
    public int findUserIndex(User user){
        for(int i=0; i<users.size(); i++){      
            if(users.get(i).getName().equals(user.getName())){
                return i;
            }
        }
        return -1;
    }

}

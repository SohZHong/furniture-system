package com.yoyo.system.model;

import com.yoyo.services.entity.User;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class AdminUserTableModel extends AbstractTableModel implements CustomTableModel{
    private final ArrayList<User> users;
    private final ArrayList<User> filteredUsers;
    private User user;
    
    private final boolean[] canEdit = new boolean[]{
            true, false, true, true, true
    };
    
    public AdminUserTableModel(ArrayList<User> users) {
        this.users = users;
        this.filteredUsers = new ArrayList<>(users);
    }
    
    @Override
    public int getRowCount() {
        return filteredUsers.size();
    }

    @Override
    public int getColumnCount() {
        // Username, Password, PhoneNumber,  Role, Action
        return 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0 -> {
                return String.class;
            }
            case 1 -> {
                return String.class;
            }
            case 2 -> {
                return String.class;
            }
            case 3 -> {
                return String.class;
            }
            case 4 -> {
                return JButton.class;
            }
                
        }
        return Object.class;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return "Username";
            }
            case 1 -> {
                return "Password";     
            }
            case 2 -> {
                return "Phone Number";
            }
            case 3 -> {
                return "Role";
            }
            case 4 -> {
                return "Action";
            }
        }
        return null;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        user = filteredUsers.get(rowIndex);
        switch (columnIndex){
            case 0 -> {
                return user.getName();
            }
            case 1 -> {
                return user.getPassword();
            }
            case 2 -> {
                return user.getPhoneNumber();
            }
            case 3 -> {
                return user.getRole();
            }
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        user = filteredUsers.get(rowIndex);
        switch (columnIndex){
            case 0 -> user.setName((String) value);
            case 1 -> user.setPassword((String) value);
            case 2 -> user.setPhoneNumber((String) value);
            case 3 -> user.setRole((String) value);
        }
        
        // Find the corresponding user in the original 'users' list and update it
        for (User originalUser : users) {
            if (originalUser.equals(user)) {
                originalUser.copyFrom(user);
                break;
            }
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public void setFilter(String searchString, int columnIndex) {
        String query;
        filteredUsers.clear();
        
        // Perform search based on column
        for (User user : users) {
            query = switch (columnIndex) {
                case 0 -> user.getName();
                case 2 -> user.getPhoneNumber();
                case 3 -> user.getRole();
                default -> null;
            };
            if (query!= null && query.toLowerCase().contains(searchString.toLowerCase())) {
                filteredUsers.add(user);
            }
        }

        fireTableDataChanged(); // Notify the table that the data has changed
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"Username", "Phone Number", "Role"};
    }

    @Override
    public int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3};
    }
    
    @Override
    public void deleteRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < filteredUsers.size()) {
            User deletedUser = filteredUsers.remove(rowIndex);

            // Find the corresponding order in the original 'orders' list and remove it
            users.removeIf(user -> user.equals(deletedUser));

            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    @Override
    public ArrayList<?> getFilteredData() {
        return null;
    }

    @Override
    public void resetFilter() {
        setFilter("", 0);
    }
}

package com.praktikum.actions;

import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.users.Admin;

public class AdminActions {

    public static Admin login(String username, String password) {
        for (Admin admin : DataStore.adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public static void tandaiClaimed(int index) {
        if (index >= 0 && index < DataStore.itemList.size()) {
            DataStore.itemList.get(index).setStatus("Claimed");
        }
    }
}

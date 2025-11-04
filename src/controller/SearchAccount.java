package controller;

import dao.AccountDAO;
import model.Account;

import java.util.ArrayList;

public class SearchAccount {
    public static SearchAccount getInstance() {
        return new SearchAccount();
    }

    public ArrayList<Account> searchAllAcc(String text) {
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> armt = AccountDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getFullName().toLowerCase().contains(text.toLowerCase())
                    || ncc.getUserName().toLowerCase().contains(text.toLowerCase())
                    || ncc.getRole().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<Account> searchFullName(String text) {
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> armt = AccountDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getFullName().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<Account> searchUserName(String text) {
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> armt = AccountDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getUserName().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<Account> searchRole(String text) {
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> armt = AccountDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getRole().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
}

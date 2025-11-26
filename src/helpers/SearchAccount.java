package helpers;

import dao.AccountDAO;
import entity.Account;

import java.util.ArrayList;

public class SearchAccount extends Searching<Account> {
    public static SearchAccount getInstance() {
        return new SearchAccount();
    }

    @Override
    public ArrayList<Account> searchAll(String text) {
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

    @Override
    public ArrayList<Account> searchName(String text) {
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> armt = AccountDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getFullName().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Account> searchID(String text) {
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

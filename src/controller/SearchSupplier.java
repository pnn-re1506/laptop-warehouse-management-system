package controller;

import dao.SupplierDAO;
import model.Supplier;

import java.util.ArrayList;

public class SearchSupplier extends Searching<Supplier> {
    public static SearchSupplier getInstance() {
        return new SearchSupplier();
    }

    @Override
    public ArrayList<Supplier> searchAll(String text) {
        ArrayList<Supplier> result = new ArrayList<>();
        ArrayList<Supplier> armt = SupplierDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getSupplierId().toLowerCase().contains(text.toLowerCase())
                    || ncc.getSupplierName().toLowerCase().contains(text.toLowerCase())
                    || ncc.getPhone().toLowerCase().contains(text.toLowerCase())
                    || ncc.getAddress().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Supplier> searchName(String text) {
        ArrayList<Supplier> result = new ArrayList<>();
        ArrayList<Supplier> armt = SupplierDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getSupplierName().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Supplier> searchID(String text) {
        ArrayList<Supplier> result = new ArrayList<>();
        ArrayList<Supplier> armt = SupplierDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getSupplierId().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<Supplier> searchAddress(String text) {
        ArrayList<Supplier> result = new ArrayList<>();
        ArrayList<Supplier> armt = SupplierDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getAddress().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<Supplier> searchPhone(String text) {
        ArrayList<Supplier> result = new ArrayList<>();
        ArrayList<Supplier> armt = SupplierDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getPhone().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
}

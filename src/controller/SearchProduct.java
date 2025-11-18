package controller;

import dao.ComputerDAO;
import model.Computer;

import java.util.ArrayList;

public class SearchProduct extends Searching<Computer> {
    public static SearchProduct getInstance() {
        return new SearchProduct();
    }

    @Override
    public ArrayList<Computer> searchAll(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {
                if (mt.getProductId().toLowerCase().contains(text.toLowerCase()) || mt.getProductId().toLowerCase().contains(text.toLowerCase())
                        || mt.getCpuName().toLowerCase().contains(text.toLowerCase())
                        || mt.getGraphicsCard().toLowerCase().contains(text.toLowerCase()))
                        {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Computer> searchID(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {
                if (mt.getProductId().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Computer> searchName(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {
                if (mt.getProductName().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Computer> searchQuantity(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {
                if (text.length() != 0) {
                    if (mt.getQuantity() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                } else {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Computer> searchImportPrice(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {

                if (text.length() != 0) {
                    if (mt.getImportPrice() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Computer> searchExportPrice(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStatus() == 1) {

                if (text.length() != 0) {
                    if (mt.getExportPrice() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Computer> searchRam(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getRam().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Computer> searchCpu(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getCpuName().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Computer> searchStorage(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getStorage().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Computer> searchCard(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getGraphicsCard().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }



    public ArrayList<Computer> searchDeleted(String text) {
        ArrayList<Computer> result = new ArrayList<>();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAll();
        for (var mt : armt) {
            if (mt.getStatus() == 0) {
                if (mt.getProductId().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public Computer searchId(String text) {
        Computer result = new Computer();
        ArrayList<Computer> armt = ComputerDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getProductId().toLowerCase().contains(text.toLowerCase())) {
                return mt;
            }
        }
        return null;
    }
}

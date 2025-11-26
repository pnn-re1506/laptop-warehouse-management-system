package dao;

import util.JDBCUtil;
import entity.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputerDAO implements DAOInterface<Computer>{
    public static ComputerDAO getInstance(){return new ComputerDAO();}

    @Override
    public int insert(Computer computer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Computer computer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Computer SET productName = ?,quantity=?,cpuName=?,ram=?,graphicsCard=?,importPrice=?,exportPrice=?,storage=?,status=? WHERE productId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, computer.getProductName());
            pst.setInt(2, computer.getQuantity());
            pst.setString(3, computer.getCpuName());
            pst.setString(4, computer.getRam());
            pst.setString(5, computer.getGraphicsCard());
            pst.setDouble(6, computer.getImportPrice());
            pst.setDouble(7, computer.getExportPrice());
            pst.setString(8, computer.getStorage());
            pst.setInt(9, computer.getStatus());
            pst.setString(10, computer.getProductId());
            result = pst.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ComputerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(Computer computer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Computer WHERE productId=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, computer.getProductId());
            result = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Computer> selectAll() {
        ArrayList<Computer> result = new ArrayList<Computer>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status FROM Computer";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String cpuName = rs.getString("cpuName");
                String ram = rs.getString("ram");
                String graphicsCard = rs.getString("graphicsCard");
                double importPrice = rs.getDouble("importPrice");
                double exportPrice = rs.getDouble("exportPrice");
                String storage = rs.getString("storage");
                int status = rs.getInt("status");
                Computer c = new Computer(productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status);
                result.add(c);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Computer selectById(String t) {
        Computer result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status FROM Computer WHERE productId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String cpuName = rs.getString("cpuName");
                String ram = rs.getString("ram");
                String graphicsCard = rs.getString("graphicsCard");
                double importPrice = rs.getDouble("importPrice");
                double exportPrice = rs.getDouble("exportPrice");
                String storage = rs.getString("storage");
                int status = rs.getInt("status");
                result = new Computer(productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
    public int updateQuantity(String productId, int quantity) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE Computer SET quantity=? WHERE productId=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, productId);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteStatus(String productId){
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Computer SET status=0 WHERE productId=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, productId);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Computer> selectAllE() {
        ArrayList<Computer> result = new ArrayList<Computer>();
        ArrayList<Computer> inventoryResult = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status FROM Computer";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String cpuName = rs.getString("cpuName");
                String ram = rs.getString("ram");
                String graphicsCard = rs.getString("graphicsCard");
                double importPrice = rs.getDouble("importPrice");
                double exportPrice = rs.getDouble("exportPrice");
                String storage = rs.getString("storage");
                int status = rs.getInt("status");
                Computer c = new Computer(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice, exportPrice, storage, status);
                result.add(c);
            }
            for (Computer computer : result) {
                if (computer.getQuantity() > 0) {
                    inventoryResult.add(computer);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return inventoryResult;
    }

    public ArrayList<Computer> selectAllExist() {
        ArrayList<Computer> result = new ArrayList<Computer>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status FROM Computer WHERE status = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String cpuName = rs.getString("cpuName");
                String ram = rs.getString("ram");
                String graphicsCard = rs.getString("graphicsCard");
                double importPrice = rs.getDouble("importPrice");
                double exportPrice = rs.getDouble("exportPrice");
                String storage = rs.getString("storage");
                int status = rs.getInt("status");
                Computer c = new Computer(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice, exportPrice, storage, status);
                result.add(c);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public int getQtt() {
        int quantity = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Computer WHERE status = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                quantity++;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return quantity;
    }
}

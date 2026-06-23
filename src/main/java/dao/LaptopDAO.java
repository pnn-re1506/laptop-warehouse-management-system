package dao;

import database.JDBCUtil;
import entity.Laptop;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaptopDAO implements DAOInterface<Laptop> {

    public static LaptopDAO getInstance() {
        return new LaptopDAO();
    }

    @Override
    public int insert(Laptop l) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Computer (productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,type,storage,screenSize,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, l.getProductId());
            pst.setString(2, l.getProductName());
            pst.setInt(3, l.getQuantity());
            pst.setString(4, l.getCpuName());
            pst.setString(5, l.getRam());
            pst.setString(6, l.getGraphicsCard());
            pst.setDouble(7, l.getImportPrice());
            pst.setDouble(8, l.getExportPrice());
            pst.setString(9, "Laptop");
            pst.setString(10, l.getStorage());
            pst.setDouble(11, l.getScreenSize());
            pst.setInt(12, l.getStatus());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not add  " + l.getProductId(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    @Override
    public int update(Laptop l) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Computer SET productId=?,productName = ?,quantity=?,cpuName=?,ram=?,graphicsCard=?,importPrice=?,exportPrice=?,type=?,storage=?,screenSize=?,status=? WHERE productId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, l.getProductId());
            pst.setString(2, l.getProductName());
            pst.setInt(3, l.getQuantity());
            pst.setString(4, l.getCpuName());
            pst.setString(5, l.getRam());
            pst.setString(6, l.getGraphicsCard());
            pst.setDouble(7, l.getImportPrice());
            pst.setDouble(8, l.getExportPrice());
            pst.setString(9, "Laptop");
            pst.setString(10, l.getStorage());
            pst.setDouble(11, l.getScreenSize());
            pst.setInt(12, l.getStatus());
            pst.setString(13, l.getProductId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(Laptop l) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Computer WHERE productId=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, l.getProductId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Laptop> selectAll() {
        ArrayList<Laptop> result = new ArrayList<Laptop>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Computer";
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
                double screenSize = rs.getDouble("screenSize");
                Laptop l = new Laptop(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice,
                        exportPrice, storage, status, screenSize);
                result.add(l);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Laptop selectById(String t) {
        Laptop result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Computer WHERE productId=?";
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
                double screenSize = rs.getDouble("screenSize");
                result = new Laptop(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice,
                        exportPrice, storage, status, screenSize);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public boolean isLaptop(String id) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Computer WHERE productId= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            String tl = null;
            while (rs.next()) {
                tl = rs.getString("type");
            }
            if (tl.equals("Laptop")) {
                return true;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

}

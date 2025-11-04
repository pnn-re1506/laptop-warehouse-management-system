package dao;

import database.JDBCUtil;
import model.Computer;
import model.Laptop;
import model.PC;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PCDAO implements DAOInterface<PC> {

    public static PCDAO getInstance(){return new PCDAO();}

    @Override
    public int insert(PC pc) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Computer (productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,mainBoard,type,storage,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pc.getProductId());
            pst.setString(2, pc.getProductName());
            pst.setInt(3, pc.getQuantity());
            pst.setString(4, pc.getCpuName());
            pst.setString(5, pc.getRam());
            pst.setString(6, pc.getGraphicsCard());
            pst.setDouble(7, pc.getImportPrice());
            pst.setDouble(8, pc.getExportPrice());
            pst.setString(9, pc.getMainBoard());
            pst.setString(10, "PC");
            pst.setString(11, pc.getStorage());
            pst.setInt(12, pc.getStatus());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not add  " + pc.getProductId(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    @Override
    public int update(PC pc) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Computer SET productId=?,productName = ?,quantity=?,cpuName=?,ram=?,graphicsCard=?,importPrice=?,exportPrice=?,mainBoard=?,type=?,storage=?,status=? WHERE productId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pc.getProductId());
            pst.setString(2, pc.getProductName());
            pst.setInt(3, pc.getQuantity());
            pst.setString(4, pc.getCpuName());
            pst.setString(5, pc.getRam());
            pst.setString(6, pc.getGraphicsCard());
            pst.setDouble(7, pc.getImportPrice());
            pst.setDouble(8, pc.getExportPrice());
            pst.setString(9, pc.getMainBoard());
            pst.setString(10, "PC");
            pst.setString(11, pc.getStorage());
            pst.setInt(12, pc.getStatus());
            pst.setString(13, pc.getProductId());
            result = pst.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(LaptopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(PC pc) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Computer WHERE productId=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pc.getProductId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<PC> selectAll() {
        ArrayList<PC> result = new ArrayList<PC>();
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
                String mainBoard = rs.getString("mainBoard");
                PC pc = new PC(productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status,mainBoard);
                result.add(pc);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PC selectById(String t) {
        PC result = null;
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
                String mainBoard = rs.getString("mainBoard");
                result = new PC(productId,productName,quantity,cpuName,ram,graphicsCard,importPrice,exportPrice,storage,status,mainBoard);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

}

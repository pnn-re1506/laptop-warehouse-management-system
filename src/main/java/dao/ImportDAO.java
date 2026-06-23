package dao;

import database.JDBCUtil;
import entity.ImportReceipt;
import entity.Receipt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ImportDAO implements DAOInterface<ImportReceipt>{
    public static ImportDAO getInstance(){return new ImportDAO();}
    @Override
    public int insert(ImportReceipt importReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Import (importId, createdDate, createdBy,supplierId, totalAmount) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, importReceipt.getReceiptID());
            pst.setTimestamp(2, importReceipt.getCreatedDate());
            pst.setString(3, importReceipt.getCreatedBy());
            pst.setString(4, importReceipt.getSupplier());
            pst.setDouble(5, importReceipt.getTotalAmount());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(ImportReceipt importReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Import SET importId=?, createdDate=?, createdBy=?, supplierId=?, totalAmount = ? WHERE importId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, importReceipt.getReceiptID());
            pst.setTimestamp(2, importReceipt.getCreatedDate());
            pst.setString(3, importReceipt.getCreatedBy());
            pst.setString(4, importReceipt.getSupplier());
            pst.setDouble(5, importReceipt.getTotalAmount());
            pst.setString(6, importReceipt.getReceiptID());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ImportReceipt importReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Import WHERE importId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, importReceipt.getReceiptID());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<ImportReceipt> selectAll() {
        ArrayList<ImportReceipt> result = new ArrayList<ImportReceipt>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Import ORDER BY createdDate DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                String supplierId = rs.getString("supplierId");
                double totalAmount = rs.getDouble("totalAmount");
                ImportReceipt r = new ImportReceipt(importId, totalAmount, ImportDetailDAO.getInstance().selectAll(importId), createdBy, createdDate, supplierId);
                result.add(r);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ImportReceipt selectById(String t) {
        ImportReceipt result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Import WHERE importId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                String supplierId = rs.getString("supplierId");
                double totalAmount = rs.getDouble("totalAmount");
                result = new ImportReceipt(importId, totalAmount, ImportDetailDAO.getInstance().selectAll(importId), createdBy, createdDate, supplierId);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Receipt> selectAllAccount(String acc) {
        ArrayList<Receipt> result = new ArrayList<Receipt>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT importId,createdDate,createdBy,totalAmount FROM import UNION SELECT * FROM export WHERE createdBy = ? ORDER BY createdDate DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, acc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                double totalAmount = rs.getDouble("totalAmount");
                Receipt p = new Receipt(importId, totalAmount, ImportDetailDAO.getInstance().selectAll(importId), createdBy, createdDate);
                result.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Receipt> selectAllP() {
        ArrayList<Receipt> result = new ArrayList<Receipt>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT importId,createdDate,createdBy,totalAmount FROM import UNION SELECT * FROM export ORDER BY createdDate DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                double totalAmount = rs.getDouble("totalAmount");
                Receipt p = new Receipt(importId, totalAmount, ImportDetailDAO.getInstance().selectAll(importId), createdBy, createdDate);
                result.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

}

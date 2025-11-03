package dao;

import database.JDBCUtil;
import model.ExportReceipt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ExportDAO implements DAOInterface<ExportReceipt> {

    public static ExportDAO getInstance(){return new ExportDAO();}
    @Override
    public int insert(ExportReceipt exportReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO export (exportId, createdDate, createdBy, totalAmount) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, exportReceipt.getReceiptID());
            pst.setTimestamp(2, exportReceipt.getCreatedDate());
            pst.setString(3, exportReceipt.getCreatedBy());
            pst.setDouble(4, exportReceipt.getTotalAmount());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(ExportReceipt exportReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE export SET exportId=?, createdDate=?, createdBy=?, totalAmount = ? WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, exportReceipt.getReceiptID());
            pst.setTimestamp(2, exportReceipt.getCreatedDate());
            pst.setString(3, exportReceipt.getCreatedBy());
            pst.setDouble(4, exportReceipt.getTotalAmount());
            pst.setString(5, exportReceipt.getReceiptID());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ExportReceipt exportReceipt) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM export WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, exportReceipt.getReceiptID());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<ExportReceipt> selectAll() {
        ArrayList<ExportReceipt> result = new ArrayList<ExportReceipt>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM export ORDER BY createdDate DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String exportId = rs.getString("exportId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                double totalAmount = rs.getDouble("totalAmount");
                ExportReceipt e = new ExportReceipt(exportId, totalAmount, ExportDetailDAO.getInstance().selectAll(exportId), createdBy, createdDate);
                result.add(e);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ExportReceipt selectById(String t) {
        ExportReceipt result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM export WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String exportId = rs.getString("exportId");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                String createdBy = rs.getString("createdBy");
                double totalAmount = rs.getDouble("totalAmount");
                result  = new ExportReceipt(exportId, totalAmount, ExportDetailDAO.getInstance().selectAll(exportId), createdBy, createdDate);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
}

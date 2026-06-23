package dao;

import database.JDBCUtil;
import entity.ReceiptDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExportDetailDAO implements DAOInterface<ReceiptDetail> {
    public static ExportDetailDAO getInstance(){ return new ExportDetailDAO();}
    
    @Override
    public int insert(ReceiptDetail receiptDetail) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ExportDetail (exportId, productId, quantity, exportPrice) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptDetail.getReceiptId());
            pst.setString(2, receiptDetail.getProductId());
            pst.setInt(3, receiptDetail.getQuantity());
            pst.setDouble(4, receiptDetail.getUnitPrice());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(ReceiptDetail receiptDetail) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE ExportDetail SET exportId=?, productId=?, quantity=?, exportPrice = ?  WHERE exportId=? AND productId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptDetail.getReceiptId());
            pst.setString(2, receiptDetail.getProductId());
            pst.setInt(3, receiptDetail.getQuantity());
            pst.setDouble(4, receiptDetail.getUnitPrice());
            pst.setString(5, receiptDetail.getReceiptId());
            pst.setString(6, receiptDetail.getProductId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ReceiptDetail receiptDetail) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM ExportDetail WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, receiptDetail.getReceiptId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ReceiptDetail> selectAll(String t) {
        ArrayList<ReceiptDetail> result = new ArrayList<ReceiptDetail>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ExportDetail WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String exportId = rs.getString("exportId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double exportPrice = rs.getDouble("exportPrice");
                ReceiptDetail rd = new ReceiptDetail(exportId, productId, quantity, exportPrice);
                result.add(rd);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<ReceiptDetail> selectAll() {
        ArrayList<ReceiptDetail> result = new ArrayList<ReceiptDetail>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ExportDetail";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String exportId = rs.getString("exportId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double exportPrice = rs.getDouble("exportPrice");
                ReceiptDetail rd = new ReceiptDetail(exportId, productId, quantity, exportPrice);
                result.add(rd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ReceiptDetail selectById(String t) {
        ReceiptDetail result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ExportDetail WHERE exportId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String exportId = rs.getString("exportId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double exportPrice = rs.getDouble("exportPrice");
                result = new ReceiptDetail(exportId, productId, quantity, exportPrice);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
}

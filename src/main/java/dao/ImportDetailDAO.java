package dao;

import database.JDBCUtil;
import entity.ReceiptDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ImportDetailDAO implements DAOInterface<ReceiptDetail>{
    public static ImportDetailDAO getInstance(){return new ImportDetailDAO();}

    @Override
    public int insert(ReceiptDetail receiptDetail) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ImportDetail (importId, productId, quantity, importPrice) VALUES (?,?,?,?)";
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
            String sql = "UPDATE ImportDetail SET importId=?, productId=?, quantity=?, importPrice = ?  WHERE importId=? AND productId=?";
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
            String sql = "DELETE FROM ImportDetail WHERE importId=?";
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
            String sql = "SELECT * FROM ImportDetail WHERE importId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double importPrice = rs.getDouble("importPrice");
                ReceiptDetail rd = new ReceiptDetail(importId, productId, quantity, importPrice);
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
            String sql = "SELECT * FROM ImportDetail";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double importPrice = rs.getDouble("importPrice");
                ReceiptDetail rd = new ReceiptDetail(importId, productId, quantity, importPrice);
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
            String sql = "SELECT * FROM ImportDetail WHERE importId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String importId = rs.getString("importId");
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                double importPrice = rs.getDouble("importPrice");
                result = new ReceiptDetail(importId, productId, quantity, importPrice);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
    }


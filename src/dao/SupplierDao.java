package dao;

import database.JDBCUtil;
import model.Supplier;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDao implements DAOInterface<Supplier>{
    @Override
    public int insert(Supplier supplier) {
        int result = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Supplier (supplierId, supplierName, phone, address) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, supplier.getSupplierId());
            pst.setString(2, supplier.getSupplierName());
            pst.setString(3, supplier.getPhone());
            pst.setString(4, supplier.getAddress());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can not add supplier" + supplier.getSupplierId(), "Error", JOptionPane.ERROR_MESSAGE);

            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Supplier supplier) {
        int result = 0;
        try{
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Supplier SET supplierId = ?, supplierName = ?, phone = ?, address = ? WHERE supplierId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, supplier.getSupplierId());
            pst.setString(2, supplier.getSupplierName());
            pst.setString(3, supplier.getPhone());
            pst.setString(4, supplier.getAddress());
            pst.setString(5, supplier.getSupplierId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(Supplier supplier) {
        int result = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Supplier WHERE supplierId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, supplier.getSupplierId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Supplier> selectAll() {
        ArrayList<Supplier> result = new ArrayList<Supplier>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Supplier";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String supplierId = rs.getString("supplierId");
                String supplierName = rs.getString("tenNhaCungCap");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Supplier s = new Supplier(supplierId, supplierName, phone, address);
                result.add(s);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Supplier selectById(String t) {
        Supplier result = null;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Supplier WHERE supplierId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String supplierId = rs.getString("supplierId");
                String supplierName = rs.getString("supplierName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                result = new Supplier(supplierId, supplierName, phone, address);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
    }
}

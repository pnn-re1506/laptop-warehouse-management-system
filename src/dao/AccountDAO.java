/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import javax.swing.JOptionPane;
import model.Account;

public class AccountDAO implements DAOInterface<Account> {

    public static AccountDAO getInstance() {
        return new AccountDAO();
    }

    @Override
    public int insert(Account t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Account (fullName, userName, password, role, status, email) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getFullName());
            pst.setString(2, t.getUserName());
            pst.setString(3, t.getPassword());
            pst.setString(4, t.getRole());
            pst.setInt(5, t.getStatus());
            pst.setString(6, t.getEmail());
            //execute SQL command
            result = pst.executeUpdate();
            //Handle
            //Close the connection to the database
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Account t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Account SET fullName=?, password=?, role=?, status=?, email=? WHERE userName=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getFullName());
            pst.setString(2, t.getPassword());
            pst.setString(3, t.getRole());
            pst.setInt(4, t.getStatus());
            pst.setString(6, t.getUserName());
            pst.setString(5, t.getEmail());

            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Account t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Account WHERE userName=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getUserName());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Account> selectAll() {
        ArrayList<Account> result = new ArrayList<Account>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Account";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int status = rs.getInt("status");
                String email = rs.getString("email");

                Account acc = new Account(fullName, userName, password, role, status, email);
                result.add(acc);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Account selectById(String t) {
        Account acc = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Account WHERE userName=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int status = rs.getInt("status");
                String email = rs.getString("email");
                acc = new Account(fullName, userName, password, role, status,email);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return acc;
    }

    public int updatePassword(String email, String password) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Account SET password=? WHERE email=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, email);

            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
}

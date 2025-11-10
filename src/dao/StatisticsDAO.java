package dao;

import database.JDBCUtil;
import model.ProductStatistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class StatisticsDAO {
    public static StatisticsDAO getInstance() {
        return new StatisticsDAO();
    }

    public ArrayList<ProductStatistics> getStatistics(Date timeStart, Date timeEnd) {
        System.out.println(timeStart);
        System.out.println(timeEnd);

        ArrayList<ProductStatistics> result = new ArrayList<ProductStatistics>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.productId, productName, imQuantity, exQuantity " +
                    "FROM ( " +
                    "    SELECT productId, SUM(quantity) AS imQuantity " +
                    "    FROM importdetail " +
                    "    JOIN import ON import.importId = importdetail.importId " +
                    "    WHERE createdDate BETWEEN ? AND ? " +
                    "    GROUP BY productId " +
                    ") t1 " +
                    "JOIN ( " +
                    "    SELECT productId, SUM(quantity) AS exQuantity " +
                    "    FROM exportdetail " +
                    "    JOIN export ON export.exportId = exportdetail.exportId " +
                    "    WHERE createdDate BETWEEN ? AND ? " +
                    "    GROUP BY productId " +
                    ") t2 ON t1.productId = t2.productId " +
                    "JOIN computer ON t1.productId = MayTinh.productId";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(2, new Timestamp(timeEnd.getTime()));
            pst.setTimestamp(3, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(4, new Timestamp(timeEnd.getTime()));

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int imQuantity = rs.getInt("imQuantity");
                int exQuantity = rs.getInt("exQuantity");
                ProductStatistics p = new ProductStatistics(productName,exQuantity,imQuantity,productId);
                result.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ProductStatistics> getStatistics() {
        ArrayList<ProductStatistics> result = new ArrayList<ProductStatistics>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.productId, productName, imQuantity, exQuantity " +
                    "FROM ( " +
                    "    SELECT productId, SUM(quantity) AS imQuantity " +
                    "    FROM importdetail " +
                    "    JOIN import ON import.importId = importdetail.importId " +
                    "    GROUP BY productId " +
                    ") t1 " +
                    "JOIN ( " +
                    "    SELECT productId, SUM(quantity) AS exQuantity " +
                    "    FROM exportdetail " +
                    "    JOIN export ON export.exportId = exportdetail.exportId " +
                    "    GROUP BY productId " +
                    ") t2 ON t1.productId = t2.productId " +
                    "JOIN computer ON t1.productId = computer.productId";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productId");
                String productName = rs.getString("productName");
                int imQuantity = rs.getInt("imQuantity");
                int exQuantity = rs.getInt("exQuantity");
                ProductStatistics p = new ProductStatistics(productName, exQuantity, imQuantity, productId);
                result.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
}

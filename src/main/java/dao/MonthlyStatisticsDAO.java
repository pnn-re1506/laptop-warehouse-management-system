package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthlyStatisticsDAO {

    public static MonthlyStatisticsDAO getInstance() {
        return new MonthlyStatisticsDAO();
    }

    public static class MonthlyData {
        private int month;
        private double expense;
        private double revenue;
        private double profit;

        public MonthlyData(int month, double expense, double revenue) {
            this.month = month;
            this.expense = expense;
            this.revenue = revenue;
            this.profit = revenue - expense;
        }

        // Getters
        public int getMonth() { return month; }
        public double getExpense() { return expense; }
        public double getRevenue() { return revenue; }
        public double getProfit() { return profit; }

        public String getMonthName() {
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            return months[month - 1];
        }
    }

    public List<MonthlyData> getMonthlyStatistics() {
        List<MonthlyData> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        return getMonthlyStatistics(currentYear);
    }

    public List<MonthlyData> getMonthlyStatistics(int year) {
        List<MonthlyData> result = new ArrayList<>();

        try {
            Connection con = JDBCUtil.getConnection();

            for (int month = 1; month <= 12; month++) {

                String importSQL = "SELECT COALESCE(SUM(totalAmount), 0) as totalExpense " +
                        "FROM Import WHERE YEAR(createdDate) = ? AND MONTH(createdDate) = ?";
                PreparedStatement importPst = con.prepareStatement(importSQL);
                importPst.setInt(1, year);
                importPst.setInt(2, month);
                ResultSet importRs = importPst.executeQuery();

                double expense = 0;
                if (importRs.next()) {
                    expense = importRs.getDouble("totalExpense");
                }
                importRs.close();
                importPst.close();

                // Get export data (revenue)
                String exportSQL = "SELECT COALESCE(SUM(totalAmount), 0) as totalRevenue " +
                        "FROM Export WHERE YEAR(createdDate) = ? AND MONTH(createdDate) = ?";
                PreparedStatement exportPst = con.prepareStatement(exportSQL);
                exportPst.setInt(1, year);
                exportPst.setInt(2, month);
                ResultSet exportRs = exportPst.executeQuery();

                double revenue = 0;
                if (exportRs.next()) {
                    revenue = exportRs.getDouble("totalRevenue");
                }
                exportRs.close();
                exportPst.close();

                result.add(new MonthlyData(month, expense, revenue));
            }

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

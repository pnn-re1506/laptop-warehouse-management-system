package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class Receipt {
    private String receiptID;
    private Timestamp createdDate;
    private String createdBy;
    private ArrayList<ReceiptDetail> receiptDetails;
    private double totalAmount;

    public Receipt() {
    }

    public Receipt(String receiptID, double totalAmount, ArrayList<ReceiptDetail> receiptDetails, String createdBy, Timestamp createdDate) {
        this.receiptID = receiptID;
        this.totalAmount = totalAmount;
        this.receiptDetails = receiptDetails;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ArrayList<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(ArrayList<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Double.compare(totalAmount, receipt.totalAmount) == 0 && Objects.equals(receiptID, receipt.receiptID) && Objects.equals(createdDate, receipt.createdDate) && Objects.equals(createdBy, receipt.createdBy) && Objects.equals(receiptDetails, receipt.receiptDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptID, createdDate, createdBy, receiptDetails, totalAmount);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", receiptDetails=" + receiptDetails +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

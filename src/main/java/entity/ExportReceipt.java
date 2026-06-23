package entity;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ExportReceipt extends Receipt {
    public ExportReceipt() {
    }

    public ExportReceipt(String receiptID, double totalAmount, ArrayList<ReceiptDetail> receiptDetails, String createdBy, Timestamp createdDate) {
        super(receiptID, totalAmount, receiptDetails, createdBy, createdDate);
    }

}
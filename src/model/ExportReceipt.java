package model;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class ExportReceipt extends Receipt {
    public ExportReceipt() {
    }

    public ExportReceipt(String receiptID, double totalAmount, ArrayList<ReceiptDetail> receiptDetails, String createdBy, Timestamp createdDate) {
        super(receiptID, totalAmount, receiptDetails, createdBy, createdDate);
    }

}
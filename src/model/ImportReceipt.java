package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class ImportReceipt extends Receipt{
        private String supplier;


    public ImportReceipt() {
    }

    public ImportReceipt(String receiptID, double totalAmount, ArrayList<ReceiptDetail> receiptDetails, String createdBy, Timestamp createdDate, String supplier) {
        super(receiptID, totalAmount, receiptDetails, createdBy, createdDate);
        this.supplier = supplier;
    }

    public ImportReceipt(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ImportReceipt that = (ImportReceipt) o;
        return Objects.equals(supplier, that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supplier);
    }

    @Override
    public String toString() {
        return "ImportReceipt{" +
                "supplier='" + supplier + '\'' +
                '}';
    }
}

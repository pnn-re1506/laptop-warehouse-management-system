package entity;

import java.util.Objects;

public class ReceiptDetail {
    private String receiptId;
    private String productId;
    private int quantity;
    private double unitPrice;

    public ReceiptDetail() {
    }

    public ReceiptDetail(String receiptId, String productId, int quantity, double unitPrice) {
        this.receiptId = receiptId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptDetail that = (ReceiptDetail) o;
        return quantity == that.quantity && Double.compare(unitPrice, that.unitPrice) == 0 && Objects.equals(receiptId, that.receiptId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, productId, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "ReceiptDetail{" +
                "receiptId='" + receiptId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

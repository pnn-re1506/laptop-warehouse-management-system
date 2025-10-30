package model;

import java.util.Objects;

public class ProductStatistics {
    private String productName;
    private String productId;
    private int importQuantity;
    private int exportQuantity;

    public ProductStatistics() {
    }

    public ProductStatistics(String productName, int exportQuantity, int importQuantity, String productId) {
        this.productName = productName;
        this.exportQuantity = exportQuantity;
        this.importQuantity = importQuantity;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getImportQuantity() {
        return importQuantity;
    }

    public void setImportQuantity(int importQuantity) {
        this.importQuantity = importQuantity;
    }

    public int getExportQuantity() {
        return exportQuantity;
    }

    public void setExportQuantity(int exportQuantity) {
        this.exportQuantity = exportQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductStatistics that = (ProductStatistics) o;
        return importQuantity == that.importQuantity && exportQuantity == that.exportQuantity && Objects.equals(productName, that.productName) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productId, importQuantity, exportQuantity);
    }

    @Override
    public String toString() {
        return "ProductStatistics{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", importQuantity=" + importQuantity +
                ", exportQuantity=" + exportQuantity +
                '}';
    }
}

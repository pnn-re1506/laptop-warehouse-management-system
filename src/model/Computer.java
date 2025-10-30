package model;
import java.util.Objects;
public class Computer {
    private String productId;    
    private String productName;
    private int quantity;
    private String cpuName;
    private String ram;
    private String graphicsCard;
    private double importPrice;
    private double exportPrice;
    private String type;
    private String storage;
    private int status;

    public Computer() {
    }

    public Computer(String productId, String productName, int quantity, String cpuName, String ram, String graphicsCard, double importPrice, double exportPrice, String type, String storage, int status){
    this.productId = productId;  
    this.productName = productName;
    this.quantity = quantity;
    this.cpuName = cpuName;
    this.ram = ram; 
    this.graphicsCard = graphicsCard;
    this.importPrice = importPrice;
    this.exportPrice = exportPrice;
    this.type = type;
    this.storage = storage;
    this.status = status;
}

    public String getProductId(){
        return this.productId;
    }
    public String getProductName(){
        return this.productName;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getCpuName(){
        return this.cpuName;
    }
    public String getRam(){
        return this.ram;
    }
    public String getGraphicsCard(){
        return this.graphicsCard;
    }
    public double getImportPrice(){
        return this.importPrice;
    }
    public double getExportPrice(){
        return this.exportPrice;
    }
    public String getType(){
        return this.type;
    }
    public String getStorage(){
        return this.storage;
    }
    public int getStatus(){
        return this.status;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setCpuName(String cpuName){
        this.cpuName = cpuName;
    }
    public void setRam(String ram){
        this.ram = ram;
    }
    public void setGraphicsCard(String graphicsCard){
      this.graphicsCard = graphicsCard;
    }
    public void setImportPrice(double importPrice){
        this.importPrice = importPrice;
    }
    public void setExportPrice(double exportPrice){
        this.exportPrice = exportPrice;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setStorage(String storage){
        this.storage = storage;
    }
    public void setStatus(int status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", cpuName='" + cpuName + '\'' +
                ", ram='" + ram + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", type='" + type + '\'' +
                ", storage='" + storage + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return quantity == computer.quantity && Double.compare(importPrice, computer.importPrice) == 0 && Double.compare(exportPrice, computer.exportPrice) == 0 && status == computer.status && Objects.equals(productId, computer.productId) && Objects.equals(productName, computer.productName) && Objects.equals(cpuName, computer.cpuName) && Objects.equals(ram, computer.ram) && Objects.equals(graphicsCard, computer.graphicsCard) && Objects.equals(type, computer.type) && Objects.equals(storage, computer.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, quantity, cpuName, ram, graphicsCard, importPrice, exportPrice, type, storage, status);
    }
}

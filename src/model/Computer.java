package computerinventory;
import java.util.Objects;
public class Computer {
    private String productId;    
    private String productName;
    private int quantity;
    private String cpuName;
    private int ram;
    private String graphicsCard;
    private double importPrice;
    private double exportPrice;
    private String mainBoard;
    private String type;
    private String storage;
    private int screenSize;
    private int status;

    public Computer(String productId, String productName, int quantity, String cpuName, int ram, String graphicsCard, double importPrice, double exportPrice, String mainBoard, String type, String storage, int screenSize, int status){
    this.productId = productId;  
    this.productName = productName;
    this.quantity = quantity;
    this.cpuName = cpuName;
    this.ram = ram; 
    this.graphicsCard = graphicsCard;
    this.importPrice = importPrice;
    this.exportPrice = exportPrice;
    this.mainBoard = mainBoard;
    this.type = type;
    this.storage = storage;
    this.screenSize = screenSize;
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
public int getRam(){
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
public String getMainBoard(){
    return this.mainBoard;
}
public String getType(){
    return this.type;
}
public String getStorage(){
    return this.storage;
}
public int getScreenSize(){
    return this.screenSize;
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
public void setRam(int ram){
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
public void setMainBoard(String mainBoard){
    this.mainBoard = mainBoard;
}
public void setType(String type){
    this.type = type;
}
public void setStorage(String storage){
    this.storage = storage;
}
public void setScreenSize(int screenSize){
    this.screenSize = screenSize;
}
public void setStatus(int status){
    this.status = status;
}
@Override
public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.productId);
  hash = 47 * hash + Objects.hashCode(this.productName);
  hash = 47 * hash + this.quantity;
  hash = 47 * hash + Objects.hashCode(this.cpuName);
  hash = 47 * hash + this.ram;
  hash = 47 * hash + Objects.hashCode(this.graphicsCard);
  hash = 47 * hash + (int)(Double.doubleToLongBits(this.importPrice) ^ Double.doubleToLongBits(this.importPrice) >>> 32);
  hash = 47 * hash + (int)(Double.doubleToLongBits(this.exportPrice) ^ Double.doubleToLongBits(this.exportPrice) >>> 32);
  hash = 47 * hash + Objects.hashCode(this.mainBoard);
  hash = 47 * hash + Objects.hashCode(this.type);
  hash = 47 * hash + Objects.hashCode(this.storage);
  hash = 47 * hash + this.status;
  return hash;
}
@Override
public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj == null) {
         return false;
      } else if (this.getClass() != obj.getClass()) {
         return false;
      } else {
         Computer other = (Computer)obj;
         if (this.quantity != other.quantity) {
            return false;
         } else if (Double.doubleToLongBits(this.importPrice) != Double.doubleToLongBits(other.importPrice)) {
            return false;
         } else if (Double.doubleToLongBits(this.exportPrice) != Double.doubleToLongBits(other.exportPrice)) {
            return false;
         } else if (!Objects.equals(this.productId, other.productId)) {
            return false;
         } else if (!Objects.equals(this.productName, other.productName)) {
            return false;
         } else if (!Objects.equals(this.cpuName, other.cpuName)) {
            return false;
         } else if (this.ram != other.ram) {
            return false;
         } else if (!Objects.equals(this.graphicsCard, other.graphicsCard)) {
            return false;
         } else if (!Objects.equals(this.mainBoard, other.mainBoard)) {
            return false;
         } else if (!Objects.equals(this.type, other.type)) {
            return false;
         } else if (!Objects.equals(this.storage, other.storage)) {
            return false;
         } else {
                return (this.screenSize != other.screenSize) ? false : this.status == other.status;
         }
      }
   }
@Override
public String toString() {
      return "Computer{productId=" + this.productId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", cpuName=" + this.cpuName + ", ram=" + this.ram + ", graphicsCard=" + this.graphicsCard + ", importPrice=" + this.importPrice + ", exportPrice=" + this.exportPrice + ", mainBoard=" + this.mainBoard + ", type=" + this.type + ", storage=" + this.storage + ", screenSize=" + this.screenSize + ", status=" + this.status + '}';    
   }
}

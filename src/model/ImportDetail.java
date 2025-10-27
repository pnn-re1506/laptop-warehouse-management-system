package computerinventory;
import java.util.Objects;
public class ImportDetail{

    private String importId;
    private String productId;
    private int quantity;
    private double importPrice;
    
    


public ImportDetail(String importId, String productId, int quantity, double importPrice){
    this.importId = importId;
    this.productId = productId;
    this.quantity = quantity;
    this.importPrice = importPrice ;
}

public String getImportId(){
    return this.importId;
}
public String getProductId(){
    return this.productId;
}
public int getQuantity(){
    return this.quantity;
}
public double getImportPrice(){
    return this.importPrice;
}

public void setImportId(String importId){
    this.importId = importId;
}
public void setProductId(String productId ){
    this.productId = productId;
}
public void setQuantity(int quantity){
    this.quantity = quantity;
}
public void setImportPrice(double importPrice){
    this.importPrice = importPrice;
}
@Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.importId);
  hash = 47 * hash + Objects.hashCode(this.productId);
  hash = 47 * hash + this.quantity;
  hash = 47 * hash + (int)(Double.doubleToLongBits(this.importPrice) ^ Double.doubleToLongBits(this.importPrice) >>> 32);
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
            ImportDetail other = (ImportDetail) obj;
            if (this.quantity != other.quantity) {
                return false;
            } else if (!Objects.equals(this.importId, other.importId)) {
                return false;
            } else if (!Objects.equals(this.productId, other.productId)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.importPrice) == Double.doubleToLongBits(other.importPrice);
            }
        }
    }

@Override
public String toString() {
return "ImportDetail{importId=" + importId + ", productId=" + productId + ", quantity=" + quantity + ", importPrice=" + importPrice + "}";
}
}
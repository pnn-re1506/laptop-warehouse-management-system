package computerinventory;
import java.util.Objects;
public class ExportDetail{

    private String exportId;
    private String productId;
    private int quantity;
    private double exportPrice;
    
    


public ExportDetail(String exportId, String productId, int quantity, double exportPrice){
    this.exportId = exportId;
    this.productId = productId;
    this.quantity = quantity;
    this.exportPrice = exportPrice ;
}

public String getExportId(){
    return this.exportId;
}
public String getProductId(){
    return this.productId;
}
public int getQuantity(){
    return this.quantity;
}
public double getExportPrice(){
    return this.exportPrice;
}

public void setExportId(String exportId){
    this.exportId = exportId;
}
public void setProductId(String productId ){
    this.productId = productId;
}
public void setQuantity(int quantity){
    this.quantity = quantity;
}
public void setExportPrice(double exportPrice){
    this.exportPrice = exportPrice;
}
@Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.exportId);
  hash = 47 * hash + Objects.hashCode(this.productId);
  hash = 47 * hash + this.quantity;
  hash = 47 * hash + (int)(Double.doubleToLongBits(this.exportPrice) ^ Double.doubleToLongBits(this.exportPrice) >>> 32);
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
            ExportDetail other = (ExportDetail) obj;
            if (this.quantity != other.quantity) {
                return false;
            } else if (!Objects.equals(this.exportId, other.exportId)) {
                return false;
            } else if (!Objects.equals(this.productId, other.productId)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.exportPrice) == Double.doubleToLongBits(other.exportPrice);
            }
        }
    }

@Override
public String toString() {
return "ExportDetail{exportId=" + exportId + ", productId=" + productId + ", quantity=" + quantity + ", exportPrice=" + exportPrice + "}";
}
}
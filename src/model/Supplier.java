package computerinventory;
import java.util.Objects;
public class Supplier{

    private String supplierId;
    private String supplierName;
    private String phone;
    private String address;
    
    


public Supplier(String supplierId, String supplierName, String phone, String address){
    this.supplierId = supplierId;
    this.supplierName = supplierName;
    this.phone = phone;
    this.address = address ;
}

public String getSupplierId(){
    return this.supplierId;
}
public String getSupplierName(){
    return this.supplierName;
}
public String getPhone(){
    return this.phone;
}
public String getAddress(){
    return this.address;
}

public void setSupplierId(String supplierId){
    this.supplierId = supplierId;
}
public void setSupplierName(String supplierName){
    this.supplierName = supplierName;
}
public void setPhone(String phone){
    this.phone = phone;
}
public void setAddress(String address){
    this.address = address;
}
@Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.supplierId);
  hash = 47 * hash + Objects.hashCode(this.supplierName);
  hash = 47 * hash + Objects.hashCode(this.phone);
  hash = 47 * hash + Objects.hashCode(this.address);
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
            Supplier other = (Supplier) obj;
            if (!Objects.equals(this.supplierId, other.supplierId)) {
                return false;
            } else if (!Objects.equals(this.supplierName, other.supplierName)) {
                return false;
            } else if (!Objects.equals(this.phone, other.phone)) {
                return false;
            } else {
                return !Objects.equals(this.address, other.address);
            }
        }
    }

@Override
public String toString() {
return "Supplier{supplierId=" + supplierId + ", supplierName=" + supplierName + ", phone=" + phone + ", address=" + address + "}";
}
}
package model;
import java.util.Objects;
public class Supplier{

    private String supplierId;
    private String supplierName;
    private String phone;
    private String address;

    public Supplier() {
    }

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierId, supplier.supplierId) && Objects.equals(supplierName, supplier.supplierName) && Objects.equals(phone, supplier.phone) && Objects.equals(address, supplier.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, phone, address);
    }

    @Override
    public String toString() {
    return "Supplier{supplierId=" + supplierId + ", supplierName=" + supplierName + ", phone=" + phone + ", address=" + address + "}";
    }
    }
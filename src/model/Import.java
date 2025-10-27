package computerinventory;
import java.time.LocalDateTime;
import java.util.Objects;

public class Import{
    private String importId;
    private LocalDateTime createdDate;
    private String createdBy;
    private String supplierId;
    private double totalAmount;
    
public Import(String importId, LocalDateTime createdDate, String createdBy, String supplierId, double totalAmount) {
        this.importId = importId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.supplierId = supplierId;
        this.totalAmount = totalAmount;
}
public String getImportId() {
        return importId;
}
public LocalDateTime getCreatedDate() {
        return createdDate;
}
public String getCreatedBy() {
        return createdBy;
}
public String getSupplierId() {
        return supplierId;
}
public double getTotalAmount() {
        return totalAmount;
}

public void setImportId(String importId) {
        this.importId = importId;
}
public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
}
public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
}
public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
}
public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
}

@Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.importId);
  hash = 47 * hash + Objects.hashCode(this.createdDate);
  hash = 47 * hash + Objects.hashCode(this.createdBy);
  hash = 47 * hash + Objects.hashCode(this.supplierId);
  hash = 47 * hash + (int)(Double.doubleToLongBits(this.totalAmount) ^ Double.doubleToLongBits(this.totalAmount) >>> 32);
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
            Import other = (Import) obj;
            if (Double.doubleToLongBits(this.totalAmount) != Double.doubleToLongBits(other.totalAmount)) {
                return false;
            } else if (!Objects.equals(this.importId, other.importId)) {
                return false;
            } else if (!Objects.equals(this.createdDate, other.createdDate)) {
                return false;
            } else if (!Objects.equals(this.supplierId, other.supplierId)) {
                return false;
            } else {
                return (!Objects.equals(this.createdBy, other.createdBy));
            }
        }
    }

@Override
public String toString() {
    return "Import{importId=" + importId + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", supplierId=" + supplierId + ", totalAmount=" + totalAmount + "}";
}
}

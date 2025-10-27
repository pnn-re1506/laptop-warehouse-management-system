package computerinventory;
import java.time.LocalDateTime;
import java.util.Objects;

public class Export {
    private String exportId;
    private LocalDateTime createdDate;
    private String createdBy;
    private double totalAmount;
    
public Export(String exportId, LocalDateTime createdDate, String createdBy, double totalAmount) {
        this.exportId = exportId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.totalAmount = totalAmount;
}
public String getExportId() {
        return exportId;
}
public LocalDateTime getCreatedDate() {
        return createdDate;
}
public String getCreatedBy() {
        return createdBy;
}
public double getTotalAmount() {
        return totalAmount;
}


public void setExportId(String exportId) {
        this.exportId = exportId;
}
public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
}
public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
}
public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
}

@Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.exportId);
  hash = 47 * hash + Objects.hashCode(this.createdDate);
  hash = 47 * hash + Objects.hashCode(this.createdBy);
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
            Export other = (Export) obj;
            if (Double.doubleToLongBits(this.totalAmount) != Double.doubleToLongBits(other.totalAmount)) {
                return false;
            } else if (!Objects.equals(this.exportId, other.exportId)) {
                return false;
            } else if (!Objects.equals(this.createdDate, other.createdDate)) {
                return false;
            } else {
                return (!Objects.equals(this.createdBy, other.createdBy));
            }
        }
    }

@Override
public String toString() {
return "Export{exportId=" + exportId + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", totalAmount" + totalAmount + "}";
}
}
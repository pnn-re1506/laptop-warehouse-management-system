package computerinventory;
import java.util.Objects;
public class Account{

    private String fullName;
    private String userName;
    private int password;
    private String role;
    private int status;
    private String email; 


public Account(String fullName, String userName, int password, String role, int status, String email){
    this.fullName = fullName;
    this.userName = userName;
    this.password = password;
    this.role = role;
    this.status = status;
    this.email = email;
}

public String getFullName(){
    return this.fullName;
}
public String getUserName(){
    return this.userName;
}
public int getPassword(){
    return this.password;
}
public String getRole(){
    return this.role;
}
public int getStatus(){
    return this.status;
}
public String getEmail(){
    return this.email;
}

public void setUserName(String userName){
    this.userName = userName;
}
public void setFullName(String fullName){
    this.fullName = fullName;
}
public void setPassword(int password){
    this.password = password;
}
public void setRole(String role){
    this.role = role;
}
public void setStatus(int status){
    this.status = status;
}
public void setEmail(String email){
    this.email = email;
}

 @Override
  public int hashCode(){
  int hash = 17;
  hash = 47 * hash + Objects.hashCode(this.fullName);
  hash = 47 * hash + Objects.hashCode(this.userName);
  hash = 47 * hash + Objects.hashCode(this.password);
  hash = 47 * hash + Objects.hashCode(this.role);
  hash = 47 * hash + this.status;
  hash = 47 * hash + Objects.hashCode(this.email);
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
         Account other = (Account)obj;
         if (this.status != other.status) {
            return false;
         } else if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
         } else if (!Objects.equals(this.userName, other.userName)) {
            return false;
         } else if (!Objects.equals(this.password, other.password)) {
            return false;
         } else {
            return !Objects.equals(this.role, other.role) ? false : Objects.equals(this.email, other.email);
         }
      }
   }
    @Override
    public String toString() {
      return "Account{fullName=" + this.fullName + ", user=" + this.userName + ", password=" + this.password + ", role=" + this.role + ", status=" + this.status + ", email=" + this.email + "}";
   }
}
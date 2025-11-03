package model;
import java.util.Objects;
public class Account{

        private String fullName;
        private String userName;
        private String password;
        private String role;
        private int status;
        private String email;

    public Account() {
    }

    public Account(String fullName, String userName, String password, String role, int status, String email){
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
    public String getPassword(){
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
    public void setPassword(String password){
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(password, account.password) && status == account.status && Objects.equals(fullName, account.fullName) && Objects.equals(userName, account.userName) && Objects.equals(role, account.role) && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, userName, password, role, status, email);
    }

    @Override
    public String toString() {
      return "Account{fullName=" + this.fullName + ", user=" + this.userName + ", password=" + this.password + ", role=" + this.role + ", status=" + this.status + ", email=" + this.email + "}";
   }
}
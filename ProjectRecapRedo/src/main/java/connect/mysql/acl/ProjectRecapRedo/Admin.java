package connect.mysql.acl.ProjectRecapRedo;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    private int id;
    private String token;
    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Account account;
    public Admin(int id, String token, Account account){
        this.id = id;
        this.token = token;
        this.account = account;
    }
    public Admin(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

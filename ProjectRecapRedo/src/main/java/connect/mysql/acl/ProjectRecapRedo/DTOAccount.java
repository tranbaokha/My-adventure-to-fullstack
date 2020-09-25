package connect.mysql.acl.ProjectRecapRedo;

public class DTOAccount {
    private String username;
    public DTOAccount(String username){
        this.username = username;
    }

    public DTOAccount() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package connect.mysql.acl.ProjectRecapRedo;

public class DTOEmployee {
    private String username;
    private String office;
    public DTOEmployee(String username, String office){
        this.username = username;
        this.office = office;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}

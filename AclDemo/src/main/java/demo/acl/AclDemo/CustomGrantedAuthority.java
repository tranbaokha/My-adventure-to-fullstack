package demo.acl.AclDemo;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class CustomGrantedAuthority implements GrantedAuthority {
    private String role;
    private List<String> permissions;
    @Override
    public String getAuthority() {
        return this.role;
    }
    public List<String> getPermissions(){
        return this.permissions;
    }
    public void setPermissions(List<String> permissions){
        this.permissions = permissions;
    }
}

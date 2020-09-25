package demo.acl.AclDemo;

import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {
    @PreAuthorize("hasPermission('', 'READ')")
    public String readPermission();
    @PreAuthorize("hasPermission('', 'WRITE')")
    public String writePermission();
}

package demo.acl.AclDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Override
    public String readPermission() {
        return "Only users who have read permission can read this line";
    }

    @Override
    public String writePermission() {
        return "Only admin who has write permission can read this line";
    }
}

package demo.acl.AclDemo;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if((authentication == null ) || (targetDomainObject == null) || !(permission instanceof String)){
            return false;
        }
        return hasPrivilege(authentication, targetDomainObject.toString().toUpperCase(), permission.toString().toUpperCase());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if((authentication == null) || (targetType == null) || !(permission instanceof String)){
            return false;
        }
        return hasPrivilege(authentication, targetType.toUpperCase(), permission.toString().toUpperCase());
    }
    public boolean hasPrivilege(Authentication authentication, String targetType, String permission){
        for(CustomGrantedAuthority i : (List<CustomGrantedAuthority>)authentication.getAuthorities()){
            for(String j : i.getPermissions()){
                if(j == permission){
                    return true;
                }
            }
        }
        return false;
    }
}

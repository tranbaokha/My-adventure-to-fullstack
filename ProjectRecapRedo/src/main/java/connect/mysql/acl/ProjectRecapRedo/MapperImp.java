package connect.mysql.acl.ProjectRecapRedo;

import org.springframework.stereotype.Service;

@Service
public class MapperImp implements Mapper{
    @Override
    public DTOAccount accountToDTO(Account account) {
        return new DTOAccount(account.getUsername());
    }

    @Override
    public DTOAdmin adminToDTO(Admin admin) {
        return new DTOAdmin(admin.getAccount().getUsername(), admin.getToken());
    }

    @Override
    public DTOEmployee employeeToDTO(Employee employee) {
        return new DTOEmployee(employee.getAccount().getUsername(), employee.getOffice());
    }
}

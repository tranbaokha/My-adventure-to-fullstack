package connect.mysql.acl.ProjectRecapRedo;

public interface Mapper {
    public DTOAccount accountToDTO(Account account);
    public DTOAdmin adminToDTO(Admin admin);
    public DTOEmployee employeeToDTO(Employee employee);
}

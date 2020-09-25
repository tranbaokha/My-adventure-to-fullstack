package connect.mysql.acl.ProjectRecapRedo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Mapper mapper;
    @GetMapping("/test")
    public String test(){
        return "Hello World!";
    }
    @GetMapping("/account")
    public List<DTOAccount> getAccount(){
        List<Account> list = accountRepository.findAll();
        List<DTOAccount> res = new ArrayList<>();
        for(Account i : list){
            DTOAccount temp = mapper.accountToDTO(i);
            res.add(temp);
        }
        return res;
    }
    @GetMapping("/account/account={username}")

    public DTOAccount getAccountByUsername(@PathVariable String username){
        return mapper.accountToDTO(accountRepository.findByUsername(username).get());
    }
    @GetMapping("/account/admin")
    public List<DTOAdmin> getAdmin(){
        List<Admin> list = adminRepository.findAll();
        List<DTOAdmin> res = new ArrayList<>();
        for(Admin i : list){
            DTOAdmin temp = mapper.adminToDTO(i);
            res.add(temp);
        }
        return res;
    }
    @GetMapping("/account/admin/account={username}")
    public DTOAdmin getAdminByUsername(@PathVariable String username){

        return mapper.adminToDTO(adminRepository.findByAccount(accountRepository.findByUsername(username).get()).get());
    }
    @GetMapping("/account/employee")
    public List<DTOEmployee> getEmployee(){
        List<Employee> list = employeeRepository.findAll();
        List<DTOEmployee> res = new ArrayList<>();
        for(Employee i : list){
            DTOEmployee temp = mapper.employeeToDTO(i);
            res.add(temp);
        }
        return res;
    }
    @GetMapping("account/employee/account={username}")
    public DTOEmployee getEmployeeByUsername(@PathVariable String username){
        return mapper.employeeToDTO(employeeRepository.findByAccount(accountRepository.findByUsername(username).get()).get());
    }

}

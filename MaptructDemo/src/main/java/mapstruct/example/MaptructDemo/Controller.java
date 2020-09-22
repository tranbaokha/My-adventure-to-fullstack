package mapstruct.example.MaptructDemo;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private EmployeeMapper mapper;
	@GetMapping("/users")
	public EmployeeDTO test() {
		Employee a = new Employee(1, "kha");
		EmployeeDTO b = mapper.employeeToEmployeeDTO(a);
		return b;
	}
}

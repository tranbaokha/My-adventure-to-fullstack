package mapstruct.example.MaptructDemo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImp implements EmployeeMapper{

	@Override
	public EmployeeDTO employeeToEmployeeDTO(Employee entity) {
		if(entity == null) {
			return null;
		}
		EmployeeDTO res = new EmployeeDTO();
		res.setEmployeeId(entity.getId());
		res.setEmployeeName(entity.getName());
		return res;
	}

	@Override
	public Employee employeeDTOtoEmployee(EmployeeDTO dto) {
		if(dto == null) {
			return null;
		}
		Employee res = new Employee();
		res.setId(dto.getEmployeeId());
		res.setName(dto.getEmployeeName());
		return res;
	}
	
}

package com.greatlearning.serviceImpl;

import com.greatlearning.model.Employee;
import com.greatlearning.repository.EmployeeRepository;
import com.greatlearning.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getById(long id) {
		Optional<Employee> optional = empRepo.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return new Employee();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Optional<Employee> result = empRepo.findById(employee.getId());
		Employee existing = result.get();
		existing.setFirst_name(employee.getFirst_name());
		existing.setLast_name(employee.getLast_name());
		existing.setEmail(employee.getEmail());

		return empRepo.save(existing);

	}

	@Override
	public void deleteViaId(long id) {
		this.empRepo.deleteById(id);
	}
}
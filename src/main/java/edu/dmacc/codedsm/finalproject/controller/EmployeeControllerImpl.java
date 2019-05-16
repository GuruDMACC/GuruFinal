package edu.dmacc.codedsm.finalproject.controller;

import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;
import edu.dmacc.codedsm.finalproject.service.EmployeeService;

public class EmployeeControllerImpl implements EmployeeController {
	private EmployeeRepository employeeRepository;
	EmployeeService employeeService = new EmployeeService(employeeRepository);

	public EmployeeControllerImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public void processPayroll() {
		employeeRepository.updateEmployeePayroll();
		employeeRepository.writeOutfile();
	}

	@Override
	public void updateEmployeeHours(Integer id, Integer hrs) {
		employeeRepository.updateEmployeeHours(id, hrs);
	}
}

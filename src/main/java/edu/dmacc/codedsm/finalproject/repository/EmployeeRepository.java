package edu.dmacc.codedsm.finalproject.repository;

import edu.dmacc.codedsm.finalproject.model.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository {

    private HashMap<Integer, Employee> employees = new HashMap<>();

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employees.values().stream().collect(Collectors.toList());
        return employeeList;
    }
    
    public void updateEmployeeHours(Integer id, Integer hrs) {
    	employees.forEach((k, v)->{
    		if(k.intValue() == id.intValue()) {
    			v.setHoursWorked(hrs);
    		}
    	});
    }
    

    public Employee getEmployeeById(Integer id) {
        Employee employee = employees.get(id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

	@Override
	public void updateEmployeePayroll() {
		employees.forEach((k, v)->{
    		v.setGrossPay(v.getHoursWorked()*v.getRate());
    		v.setNetPay(v.getGrossPay()/2);
    	});
		
	}

	@Override
	public void writeOutfile() {
		 
		 String text = "Hello world";
	        BufferedWriter output = null;
	        try {
	            File file = new File("C:\\development\\TammyFinalProject\\example.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(text);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        }  
	}
}

package edu.dmacc.codedsm.finalproject.view;

import edu.dmacc.codedsm.finalproject.model.Employee;
import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AllEmployeeView implements View {
    public AllEmployeeView() {
    }

    public void render(EmployeeRepository employees) {
        for (Employee ee : employees.getAllEmployees()) {
            System.out.println(ee);

        }
    }
}
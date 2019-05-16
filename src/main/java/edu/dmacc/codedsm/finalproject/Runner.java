package edu.dmacc.codedsm.finalproject;

import edu.dmacc.codedsm.finalproject.controller.DataLoadController;
import edu.dmacc.codedsm.finalproject.controller.EmployeeControllerImpl;
import edu.dmacc.codedsm.finalproject.model.Employee;
import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;
import edu.dmacc.codedsm.finalproject.service.EmployeeService;
import edu.dmacc.codedsm.finalproject.view.AllEmployeeView;
import edu.dmacc.codedsm.finalproject.view.MenuView;

import java.util.List;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Runner {
    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository(); // should only have one repository
        DataLoadController dataLoadController = new DataLoadController(repository);
       // EmployeeControllerImpl employeeController = new EmployeeControllerImpl(repository);
//        Boolean isRunning = true;
        dataLoadController.load();

        System.out.println(repository);
        System.out.println("data loaded");


        // control flow for entering option to get all, update, do payroll, or exit
        MenuView view = new MenuView();
        view.render(repository);

    }
}

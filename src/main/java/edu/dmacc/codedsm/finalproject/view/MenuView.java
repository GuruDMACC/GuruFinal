package edu.dmacc.codedsm.finalproject.view;

import edu.dmacc.codedsm.finalproject.controller.EmployeeController;
import edu.dmacc.codedsm.finalproject.controller.EmployeeControllerImpl;
import edu.dmacc.codedsm.finalproject.model.Employee;
import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class MenuView implements View {

    public void render(EmployeeRepository employees) {
        EmployeeController employeeController = new EmployeeControllerImpl(employees);
        AllEmployeeView allEmployeeView = new AllEmployeeView();
        Boolean isRunning = true;
        Scanner in = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1	List all known employees");
            System.out.println("2	Update an employee's hours ");
            System.out.println("3	Process payroll and exit");
            System.out.println("4	Exit");
            String response = in.next();


            if (response.equals("4")) {
                isRunning = false;
            } else if (response.equals("3")) {
                 employeeController.processPayroll();
            } else if (response.equals("2")) {
            	 System.out.println("Enter Employee Id ");
            	 Integer id = Integer.parseInt(in.next());
            	 System.out.println("Enter Hrs");
            	 Integer hrs = Integer.parseInt(in.next());
                 employeeController.updateEmployeeHours(id, hrs);
            } else if (response.equals("1"))
                allEmployeeView.render(employees);
            }
        File file = new File("payroll_results.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("payroll_results.txt");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        pw.println("This is my file content");
        //(Integer employeeId, String name, Double netPay);
        pw.close();
        System.out.println("DONE");
    }
}



package edu.dmacc.codedsm.finalproject.repository;

import edu.dmacc.codedsm.finalproject.model.Employee;

public interface Repository {
    void save (Employee data);
    void updateEmployeeHours(Integer id, Integer hrs) ;
    void updateEmployeePayroll() ;
    void writeOutfile();
}

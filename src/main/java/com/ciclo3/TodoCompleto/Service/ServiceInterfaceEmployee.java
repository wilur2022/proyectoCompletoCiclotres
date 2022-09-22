package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Employee;

import java.util.List;

public interface ServiceInterfaceEmployee {
    //Metodo para ver lista de Employee
    public List<Employee> getEmployee();


    //Metodo que nos trae un Employee
    public Employee getOnlyOneEmployee(Long idEmployee) throws Exception;


    //Metodo que nos cree una Employee
    public String getCreateEmployee(Employee EmployeeIn);


    //Metodo que nos permita actualizar una Employee
    public Employee getUpdateEmployee(Employee EmployeeIn) throws Exception;

    //Metodo que elimina una Employee
    public String getDeleteEmployee(Long idEmployee) throws Exception;
}

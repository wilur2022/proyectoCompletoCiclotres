package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Repositories.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmployee implements ServiceInterfaceEmployee{
    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Employee
    @Autowired
    RepositoryEmployee repositoryEmployee;


    @Override
    public List<Employee> getEmployee() {
        return repositoryEmployee.findAll();
    }

    @Override
    public Employee getOnlyOneEmployee(Long idEmployee) throws Exception {
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            return EmployeeBD.get();
        }
        throw new Exception("IdEmployee no asignado a ninguna Employee de nuestra base de datos");
    }

    @Override
    public String setCreateEmployee(Employee EmployeeIn) {
        //Preguntamos si ya hay alguna Employee ya registrada con ese Id.
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(EmployeeIn.getIdEmployee());
        if(!EmployeeBD.isPresent()){
            repositoryEmployee.save(EmployeeIn);
            return "Employee Creada con exito";

        }
        return ("Ese Id ya esta regitrado a un Employee Existente");
    }

    @Override
    public Employee getUpdateEmployee(Employee EmployeeIn) throws Exception {
        //LLamamos a la Employee a actualizar de la BD
        Employee EmployeeBD = getOnlyOneEmployee(EmployeeIn.getIdEmployee());

        //Actualizamos atributos
        if(EmployeeIn.getNameEmployee()!=null && !EmployeeIn.getNameEmployee().equals("")){
            EmployeeBD.setNameEmployee(EmployeeIn.getNameEmployee());
        }

        if(EmployeeIn.getEmailEmployee()!=null && !EmployeeIn.getEmailEmployee().equals("")){
            EmployeeBD.setEmailEmployee(EmployeeIn.getEmailEmployee());
        }

        if(EmployeeIn.getRolesEmployee()!=null && !EmployeeIn.getRolesEmployee().equals("")){
            EmployeeBD.setRolesEmployee(EmployeeIn.getRolesEmployee());
        }

        if(EmployeeIn.getPhoneEmployee()!=null && !EmployeeIn.getPhoneEmployee().equals("")){
            EmployeeBD.setPhoneEmployee(EmployeeIn.getPhoneEmployee());
        }

        EmployeeBD.setUpdatedAtEmployee(Today);

        return repositoryEmployee.save(EmployeeBD);
    }

    @Override
    public String getDeleteEmployee(Long idEmployee) throws Exception {
        Optional<Employee> EmployeeBD = repositoryEmployee.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            repositoryEmployee.deleteById(idEmployee);
            return "Employee Eliminada con exito";
        }
        throw new Exception("Employee NOOOOO encontarda");
    }

}

package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Models.ObjetAnswer;
import com.ciclo3.TodoCompleto.Service.ServiceInterfaceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEmployee {
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEmployee
    @Autowired
    ServiceInterfaceEmployee serviceInterfaceEmployee;

    //Creamos los Mapping

    //Mapping para listar Employee
    @GetMapping("/ListEmployee")
    public ResponseEntity<List<Employee>> getEmployee(){
        return new ResponseEntity<>(serviceInterfaceEmployee.getEmployee(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Employee
    @GetMapping("/OneEmployee/{idEmployee}")
    public ResponseEntity<Object> getEmployeePath(@PathVariable Long idEmployee){
        try {
            Employee EmployeeX = serviceInterfaceEmployee.getOnlyOneEmployee(idEmployee);
            return new ResponseEntity<>(EmployeeX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Employee
    @PostMapping("/CreateEmployee")
    public ResponseEntity<String> PostCreateEmployee(@RequestBody Employee EmployeeX){
        try {
            String message =serviceInterfaceEmployee.setCreateEmployee(EmployeeX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Employee
    @PutMapping("/UpdateEmployee")
    public ResponseEntity<ObjetAnswer> putUpdateEmployee(@RequestBody Employee EmployeeX){
        try {
            Employee EmployeeBD = serviceInterfaceEmployee.getUpdateEmployee(EmployeeX);
            return new ResponseEntity<>(new ObjetAnswer("Atualizacion de Employee Exitosa",EmployeeBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetAnswer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una Employee
    @DeleteMapping("/DeleteEmployee/{idEmployee}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable Long idEmployee){
        try {
            String message = serviceInterfaceEmployee.getDeleteEmployee(idEmployee);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Enterprise;
import com.ciclo3.TodoCompleto.Models.ObjetAnswer;
import com.ciclo3.TodoCompleto.Service.ServiceInterfaceEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEnterprise {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEnterprise
    @Autowired
    ServiceInterfaceEnterprise serviceInterfaceEnterprise;

    //Creamos los Mapping

    //Mapping para listar Enterprise
    @GetMapping("/ListEnterprise")
    public ResponseEntity <List<Enterprise>> getEnterprise(){
        return new ResponseEntity<>(serviceInterfaceEnterprise.getEnterprise(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Enterprise
    @GetMapping("/OneEnterprise/{idEnterprise}")
    public ResponseEntity<Object> getEnterprisePath(@PathVariable Long idEnterprise){
        try {
            Enterprise EnterpriseX = serviceInterfaceEnterprise.getOnlyOneEnterprise(idEnterprise);
            return new ResponseEntity<>(EnterpriseX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Enterprise
    @PostMapping("/CreateEnterprise")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Enterprise EnterpriseX){
        try {
            String message =serviceInterfaceEnterprise.setCreateEnterprise(EnterpriseX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Enterprise
    @PutMapping("/UpdateEnterprise")
    public ResponseEntity<ObjetAnswer> putUpdateEnterprise(@RequestBody Enterprise EnterpriseX){
        try {
            Enterprise EnterpriseBD = serviceInterfaceEnterprise.getUpdateEnterprise(EnterpriseX);
            return new ResponseEntity<>(new ObjetAnswer("Atualizacion de Enterprise Exitosa",EnterpriseBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetAnswer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una enterprise
    @DeleteMapping("/DeleteEnterprise/{idEnterprise}")
    public ResponseEntity<String> DeleteEnterprise(@PathVariable Long idEnterprise){
        try {
            String message = serviceInterfaceEnterprise.getDeleteEnterprise(idEnterprise);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

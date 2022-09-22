package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Models.ObjetAnswer;
import com.ciclo3.TodoCompleto.Service.ServiceInterfaceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResTControllerTransaction {
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceTransaction
    @Autowired
    ServiceInterfaceTransaction serviceInterfaceTransaction;

    //Creamos los Mapping

    //Mapping para listar Transaction
    @GetMapping("/ListTransaction")
    public ResponseEntity<List<Transaction>> getTransaction(){
        return new ResponseEntity<>(serviceInterfaceTransaction.getTransaction(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Transaction
    @GetMapping("/OneTransaction/{idTransaction}")
    public ResponseEntity<Object> getTransactionPath(@PathVariable Long idTransaction){
        try {
            Transaction TransactionX = serviceInterfaceTransaction.getOnlyOneTransaction(idTransaction);
            return new ResponseEntity<>(TransactionX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Transaction
    @PostMapping("/CreateTransaction")
    public ResponseEntity<String> PostCreateTransaction(@RequestBody Transaction TransactionX){
        try {
            String message =serviceInterfaceTransaction.getCreateTransaction(TransactionX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Transaction
    @PutMapping("/UpdateTransaction")
    public ResponseEntity<ObjetAnswer> putUpdateTransaction(@RequestBody Transaction TransactionX){
        try {
            Transaction TransactionBD = serviceInterfaceTransaction.getUpdateTransaction(TransactionX);
            return new ResponseEntity<>(new ObjetAnswer("Atualizacion de Transaction Exitosa",TransactionBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetAnswer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una Transaction
    @DeleteMapping("/DeleteTransaction/{idTransaction}")
    public ResponseEntity<String> DeleteTransaction(@PathVariable Long idTransaction){
        try {
            String message = serviceInterfaceTransaction.getDeleteTransaction(idTransaction);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

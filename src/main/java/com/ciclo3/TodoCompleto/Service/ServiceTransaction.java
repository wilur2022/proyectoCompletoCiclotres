package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Repositories.RepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTransaction implements ServiceInterfaceTransaction{
    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Transaction
    @Autowired
    RepositoryTransaction repositoryTransaction;

    @Override
    public List<Transaction> getTransaction() {
        return repositoryTransaction.findAll();
    }

    @Override
    public Transaction getOnlyOneTransaction(Long idTransaction) throws Exception {
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(idTransaction);
        if(TransactionBD.isPresent()){
            return TransactionBD.get();
        }
        throw new Exception("IdTransaction no asignado a ninguna Transaction de nuestra base de datos");
    }

    @Override
    public String getCreateTransaction(Transaction TransactionIn) {
        //Preguntamos si ya hay alguna Transaction ya registrada con ese Id.
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(TransactionIn.getIdTransaction());
        if(!TransactionBD.isPresent()){
            repositoryTransaction.save(TransactionIn);
            return "Transaction Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Transaction Existente");
    }

    @Override
    public Transaction getUpdateTransaction(Transaction TransactionIn) throws Exception {
        //LLamamos a la Transaction a actualizar de la BD
        Transaction TransactionBD = getOnlyOneTransaction(TransactionIn.getIdTransaction());

        //Actualizamos atributos
        if(TransactionIn.getConceptTransaction()!=null && !TransactionIn.getConceptTransaction().equals("")){
            TransactionBD.setConceptTransaction(TransactionIn.getConceptTransaction());
        }

        String amountCast= String.valueOf(TransactionIn.getAmountTransaction());
        if(amountCast!=null && !amountCast.equals("")){
            TransactionBD.setAmountTransaction(TransactionIn.getAmountTransaction());
        }

        TransactionBD.setUpdatedAtTransaction(Today);

        return repositoryTransaction.save(TransactionBD);
    }

    @Override
    public String getDeleteTransaction(Long idTransaction) throws Exception {
        Optional<Transaction> TransactionBD = repositoryTransaction.findById(idTransaction);
        if(TransactionBD.isPresent()){
            repositoryTransaction.deleteById(idTransaction);
            return "Transaction Eliminada con exito";
        }
        throw new Exception("Transaction NOOOOO encontarda");
    }
}

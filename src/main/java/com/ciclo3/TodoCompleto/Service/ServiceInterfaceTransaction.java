package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Transaction;

import java.util.List;

public interface ServiceInterfaceTransaction {
    //Metodo para ver lista de Transaction
    public List<Transaction> getTransaction();


    //Metodo que nos trae un Transaction
    public Transaction getOnlyOneTransaction(Long idTransaction) throws Exception;


    //Metodo que nos cree una Transaction
    public String getCreateTransaction(Transaction TransactionIn);


    //Metodo que nos permita actualizar una Transaction
    public Transaction getUpdateTransaction(Transaction TransactionIn) throws Exception;

    //Metodo que elimina una Transaction
    public String getDeleteTransaction(Long idTransaction) throws Exception;
}

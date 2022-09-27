package com.ciclo3.TodoCompleto.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Transactions")
public class Transaction {
    //Atributes
    @Id
    private Long idTransaction;
    @Column
    private String conceptTransaction;
    @Column
    private float amountTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Employee employeeTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Enterprise enterpriseTransaction;
    @Column
    private java.sql.Date createdAtTransaction;
    @Column
    private Date updatedAtTransaction;

    //Constructor


    public Transaction(Long idTransaction, String conceptTransaction, float amountTransaction, Employee employeeTransaction, Enterprise enterpriseTransaction, java.sql.Date createdAtTransaction, Date updatedAtTransaction) {
        this.idTransaction = idTransaction;
        this.conceptTransaction = conceptTransaction;
        this.amountTransaction = amountTransaction;
        this.employeeTransaction = employeeTransaction;
        this.enterpriseTransaction = enterpriseTransaction;
        this.createdAtTransaction = createdAtTransaction;
        this.updatedAtTransaction = updatedAtTransaction;
    }

    //Constructor Empty
    public Transaction() {
    }

    //Setters and Getters

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getConceptTransaction() {
        return conceptTransaction;
    }

    public void setConceptTransaction(String conceptTransaction) {
        this.conceptTransaction = conceptTransaction;
    }

    public float getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(float amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public Employee getEmployeeTransaction() {
        return employeeTransaction;
    }

    public void setEmployeeTransaction(Employee employeeTransaction) {
        this.employeeTransaction = employeeTransaction;
    }

    public Enterprise getEnterpriseTransaction() {
        return enterpriseTransaction;
    }

    public void setEnterpriseTransaction(Enterprise enterpriseTransaction) {
        this.enterpriseTransaction = enterpriseTransaction;
    }

    public Date getUpdatedAtTransaction() {
        return updatedAtTransaction;
    }

    public void setUpdatedAtTransaction(Date updatedAtTransaction) {
        this.updatedAtTransaction = updatedAtTransaction;
    }

    public java.sql.Date getCreatedAtTransaction() {
        return createdAtTransaction;
    }

    public void setCreatedAtTransaction(java.sql.Date createdAtTransaction) {
        this.createdAtTransaction = createdAtTransaction;
    }
}

package com.ciclo3.TodoCompleto.Models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="Enterprises")
public class Enterprise {
    //Atributes
    @Id
    private Long idEnterprise;
    @Column
    private String nameEnterprise;
    @Column
    private String NITEnterprise;
    @Column
    private String phoneEnterprise;
    @Column
    private String addressEnterprise;
    @OneToMany(mappedBy = "enterpriseTransaction")
    private List<Transaction> transactions;
    @OneToMany(mappedBy = "enterpriseEmployee")
    private List<Employee> employees;
    @Column
    private java.sql.Date createdAtEnterprise;
    @Column
    private Date updatedAtEnterprise;




    //Constructor


    public Enterprise(Long idEnterprise, String nameEnterprise, String NITEnterprise, String phoneEnterprise, String addressEnterprise) {
        this.idEnterprise = idEnterprise;
        this.nameEnterprise = nameEnterprise;
        this.NITEnterprise = NITEnterprise;
        this.phoneEnterprise = phoneEnterprise;
        this.addressEnterprise = addressEnterprise;
    }

    //Constructor Empty
    public Enterprise() {
    }

    //Getters and Setters

    public Long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public String getNITEnterprise() {
        return NITEnterprise;
    }

    public void setNITEnterprise(String NITEnterprise) {
        this.NITEnterprise = NITEnterprise;
    }

    public String getPhoneEnterprise() {
        return phoneEnterprise;
    }

    public void setPhoneEnterprise(String phoneEnterprise) {
        this.phoneEnterprise = phoneEnterprise;
    }

    public String getAddressEnterprise() {
        return addressEnterprise;
    }

    public void setAddressEnterprise(String addressEnterprise) {
        this.addressEnterprise = addressEnterprise;
    }

    public java.sql.Date getCreatedAtEnterprise() {
        return createdAtEnterprise;
    }

    public void setCreatedAtEnterprise(java.sql.Date createdAtEnterprise) {
        this.createdAtEnterprise = createdAtEnterprise;
    }

    public Date getUpdatedAtEnterprise() {
        return updatedAtEnterprise;
    }

    public void setUpdatedAtEnterprise(Date updatedAtEnterprise) {
        this.updatedAtEnterprise = updatedAtEnterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

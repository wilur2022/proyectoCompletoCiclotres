package com.ciclo3.TodoCompleto.Models;




import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="Employees")
public class Employee {
    //Atributes
    @Id
    private Long idEmployee;

    @Column
    private String nameEmployee;
    @Column
    private String phoneEmployee;
    @Column
    private String emailEmployee;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ROLES.class,fetch = FetchType.EAGER)
    private List<ROLES> rolesEmployee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Enterprise enterpriseEmployee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<Transaction> transactions;
    @Column
    private Date updatedAtEmployee;
    @Column
    private java.sql.Date createdAtEmployee;

    //Contructor


    public Employee(Long idEmployee, String nameEmployee, String phoneEmployee, String emailEmployee, Date updatedAtEmployee, java.sql.Date createdAtEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.updatedAtEmployee = updatedAtEmployee;
        this.createdAtEmployee = createdAtEmployee;
    }

    //Constructor Empty
    public Employee() {
    }

    //Setters and Getters

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public List<ROLES> getRolesEmployee() {
        return rolesEmployee;
    }

    public void setRolesEmployee(List<ROLES> rolesEmployee) {
        this.rolesEmployee = rolesEmployee;
    }

    public Enterprise getEnterpriseEmployee() {
        return enterpriseEmployee;
    }

    public void setEnterpriseEmployee(Enterprise enterpriseEmployee) {
        this.enterpriseEmployee = enterpriseEmployee;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getUpdatedAtEmployee() {
        return updatedAtEmployee;
    }

    public void setUpdatedAtEmployee(Date updatedAtEmployee) {
        this.updatedAtEmployee = updatedAtEmployee;
    }

    public java.sql.Date getCreatedAtEmployee() {
        return createdAtEmployee;
    }

    public void setCreatedAtEmployee(java.sql.Date createdAtEmployee) {
        this.createdAtEmployee = createdAtEmployee;
    }
}

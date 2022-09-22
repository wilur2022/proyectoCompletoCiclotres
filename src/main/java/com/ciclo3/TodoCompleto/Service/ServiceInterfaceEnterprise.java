package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Enterprise;

import java.util.List;

public interface ServiceInterfaceEnterprise {

    //Metodo para ver lista de Enterprise
    public List<Enterprise> getEnterprise();


    //Metodo que nos trae un Enterprise
    public Enterprise getOnlyOneEnterprise(Long idEnterprise) throws Exception;


    //Metodo que nos cree una Enterprise
    public String getCreateEnterprise(Enterprise enterpriseIn);


    //Metodo que nos permita actualizar una enterprise
    public Enterprise getUpdateEnterprise(Enterprise enterpriseIn) throws Exception;

    //Metodo que elimina una enterprise
    public String getDeleteEnterprise(Long idEnterprise) throws Exception;
}

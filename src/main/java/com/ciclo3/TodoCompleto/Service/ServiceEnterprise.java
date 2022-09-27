package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Models.Enterprise;
import com.ciclo3.TodoCompleto.Repositories.RepositoryEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEnterprise implements ServiceInterfaceEnterprise{

    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad enterprise
    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    @Override
    public List<Enterprise> getEnterprise() {
        return repositoryEnterprise.findAll();
    }

    @Override
    public Enterprise getOnlyOneEnterprise(Long idEnterprise) throws Exception {
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("IdEnterprise no asignado a ninguna enterprise de nuestra base de datos");
    }

    @Override
    public String setCreateEnterprise(Enterprise enterpriseIn) {
        //Preguntamos si ya hay alguna enterprise ya registrada con ese Id.
        Optional<Enterprise> EnterpriseBD = repositoryEnterprise.findById(enterpriseIn.getIdEnterprise());
        if(!EnterpriseBD.isPresent()){
            repositoryEnterprise.save(enterpriseIn);
            return "Enterprise Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Enterprise Existente");
    }

    @Override
    public Enterprise getUpdateEnterprise(Enterprise enterpriseIn) throws Exception {
        //LLamamos a la enterprise a actualizar de la BD
        Enterprise enterpriseBD = getOnlyOneEnterprise(enterpriseIn.getIdEnterprise());

        //Actualizamos atributos
        if(enterpriseIn.getNameEnterprise()!=null && !enterpriseIn.getNameEnterprise().equals("")){
            enterpriseBD.setNameEnterprise(enterpriseIn.getNameEnterprise());
        }

        if(enterpriseIn.getNITEnterprise()!=null && !enterpriseIn.getNITEnterprise().equals("")){
            enterpriseBD.setNITEnterprise(enterpriseIn.getNITEnterprise());
        }

        if(enterpriseIn.getAddressEnterprise()!=null && !enterpriseIn.getAddressEnterprise().equals("")){
            enterpriseBD.setAddressEnterprise(enterpriseIn.getAddressEnterprise());
        }

        if(enterpriseIn.getPhoneEnterprise()!=null && !enterpriseIn.getPhoneEnterprise().equals("")){
            enterpriseBD.setPhoneEnterprise(enterpriseIn.getPhoneEnterprise());
        }

        if(enterpriseIn.getCreatedAtEnterprise()!=null && !enterpriseIn.getCreatedAtEnterprise().equals("")){
            enterpriseBD.setCreatedAtEnterprise(enterpriseIn.getCreatedAtEnterprise());
        }

        enterpriseBD.setUpdatedAtEnterprise(Today);

        return repositoryEnterprise.save(enterpriseBD);
    }

    @Override
    public String getDeleteEnterprise(Long idEnterprise) throws Exception {
        Optional<Enterprise> enterpriseBD = repositoryEnterprise.findById(idEnterprise);
        if(enterpriseBD.isPresent()){
            repositoryEnterprise.deleteById(idEnterprise);
            return "Enterprise Eliminada con exito";
        }
        throw new Exception("Enterprise NOOOOO encontarda");
    }


}

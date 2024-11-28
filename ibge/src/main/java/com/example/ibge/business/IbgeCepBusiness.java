package com.example.ibge.business;

import com.example.ibge.model.IbgeCepModel;

public class IbgeCepBusiness {

//    private void verificaEstado() {
//        if () {
//
//    }

    public void validaEstadoSp(IbgeCepModel retornoConsultaIbgeCep) {
        if (retornoConsultaIbgeCep.getState().equals("SP")) {
            retornoConsultaIbgeCep.setState("MG");

        }
    }

    public void validaCidade(IbgeCepModel retornoConsultaIbgeCep) {
        if (retornoConsultaIbgeCep.getCity().equals("Campinas")) {
            System.out.println("Cidade invalida: " + retornoConsultaIbgeCep.getCity());
            retornoConsultaIbgeCep.setCity("Souzas");
        }
    }
}

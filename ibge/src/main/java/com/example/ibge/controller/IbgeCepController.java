package com.example.ibge.controller;

import com.example.ibge.business.IbgeCepBusiness;
import com.example.ibge.model.IbgeCepModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
    @RequestMapping("/consulta/cep")
public class IbgeCepController {

    @GetMapping("/teste")
    public String testeServico() {
        return "Esta de pe";
    }

    @GetMapping("/api/ibge")
    public ResponseEntity<IbgeCepModel> consultaCepIbge() {
        String url_api = "https://brasilapi.com.br/api/cep/v1/13069080";

        RestTemplate restTemplate = new RestTemplate();
        IbgeCepModel retornoConsultaIbgeCep = restTemplate.getForObject(url_api, IbgeCepModel.class);
        IbgeCepBusiness ibgeCepBusiness = new IbgeCepBusiness();
        ibgeCepBusiness.validaEstadoSp(retornoConsultaIbgeCep);
        ibgeCepBusiness.validaCidade(retornoConsultaIbgeCep);

        if (retornoConsultaIbgeCep != null) {
            return ResponseEntity.ok(retornoConsultaIbgeCep);
        } else {
            return ResponseEntity.badRequest()  .build();
        }
    }



}

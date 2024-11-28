package com.example.ibge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IbgeCepModel {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;

}

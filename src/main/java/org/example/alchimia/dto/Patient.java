package org.example.alchimia.dto;

import lombok.Data;

@Data
public class Patient {

    Integer id;
    String name;
    String cpf;
    String email;
    String phone;
    String password;
    String agreementId;
}

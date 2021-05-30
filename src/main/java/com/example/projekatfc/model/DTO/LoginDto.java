package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String korisnickoImeEmail;
    private String lozinka;

    public LoginDto(){}
}

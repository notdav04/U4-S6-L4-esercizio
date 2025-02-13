package com.example.U4_S6_L4_esercizio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
public class AutoreDTO {
    @NotBlank(message = "il campo nome risulta vuoto")
    @NotNull(message = "il campo nome è obbligatorio")
    private String nome;
    @NotBlank(message = "il campo cognome risulta vuoto")
    @NotNull(message = "il campo cognome è obbligatorio")
    private String cognome;
    @Email(message = "l email inserita non è corretta")
    @NotBlank(message = "il campo email risulta vuoto")
    @NotNull(message = "il campo email è obbligatorio")
    private String email;

    private LocalDate dataDiNascita;
    @URL
    private String avatar;
}
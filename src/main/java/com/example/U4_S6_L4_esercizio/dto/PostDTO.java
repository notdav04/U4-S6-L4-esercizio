package com.example.U4_S6_L4_esercizio.dto;

import com.example.U4_S6_L4_esercizio.model.Autore;
import lombok.Data;

@Data
public class PostDTO {
    private String titolo;
    private String contenuto;
    private int tempoLettura;
    private Autore autore;
}
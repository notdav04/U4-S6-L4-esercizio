package com.example.U4_S6_L4_esercizio.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int counter=1;
    private long id;
    private String categoria;
    private String titolo;
    private String cover ;
    private String contenuto;
    private int tempoLettura;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;



    public Post( String categoria, String titolo, String contenuto, int tempoLettura) {

        this.categoria = categoria;
        this.titolo = titolo;

        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;

    }


}

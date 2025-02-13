package com.example.U4_S6_L4_esercizio.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="autori")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    private static int counter = 0;
    @OneToMany(mappedBy = "autore", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Post> listaPosts;



    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
    }

}

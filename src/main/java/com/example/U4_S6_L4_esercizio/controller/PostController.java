package com.example.U4_S6_L4_esercizio.controller;

import com.example.U4_S6_L4_esercizio.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogPost")
public class PostController {
    private List<Post> blogPosts = new ArrayList<>();

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return blogPosts;
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        return blogPosts.stream().filter(post -> post.getId()==id).findFirst().get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String newPost(@RequestBody Post post){
        String descrizione = "Dettaglio post: \n";
        descrizione+= "id: " + post.getId() + "\n";
        descrizione += "categoria: "+ post.getCategoria() + "\n";
        descrizione += "titolo: "+ post.getTitolo() + "\n";
        descrizione += "contenuto: " + post.getContenuto() + "\n";
        descrizione += "tempo di lettura: " + post.getTempoLettura() + "\n";
        blogPosts.add(new Post(post.getCategoria(), post.getTitolo(), post.getContenuto(), post.getTempoLettura()));
        return descrizione;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePostById(@PathVariable int id, @RequestBody Post post){

        Post postMod = blogPosts.stream().filter(ele-> ele.getId()==id).findFirst().get();
        if (postMod != null){
            postMod.setCategoria(post.getCategoria());
            postMod.setTitolo(post.getTitolo());
            postMod.setContenuto(post.getContenuto());
            postMod.setTempoLettura(post.getTempoLettura());
        }

        return postMod;
    }

    @DeleteMapping("/{id}")
    public String DeletePostById(@PathVariable int id ){
        Post postMod = blogPosts.stream().filter(ele-> ele.getId()==id).findFirst().get();
        blogPosts.remove(postMod);

        return "funzione DELETE terminata con successo";
    }


}

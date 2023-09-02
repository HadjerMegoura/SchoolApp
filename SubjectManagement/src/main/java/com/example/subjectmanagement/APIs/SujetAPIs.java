package com.example.subjectmanagement.APIs;

import com.example.subjectmanagement.Entities.Specialite;
import com.example.subjectmanagement.Entities.Sujet;
import com.example.subjectmanagement.Services.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/sujet")
public class SujetAPIs {
    @Autowired
    SujetService sujetService;

    @PostMapping("/add")
    Sujet addSujet(@RequestBody Sujet sujet){
        return sujetService.addSujet(sujet);
    }

    @GetMapping("/listSujets")
    List<Sujet> listSujets(){
        return sujetService.getAll();
    }

    @GetMapping("/sujetDetail/{id}")
    Sujet SujetDetail(@PathVariable("id") Long id){
        return sujetService.getById(id);
    }

    @DeleteMapping("/delete")
    Boolean DeleteSujet(@RequestBody Sujet sujet){
        sujetService.deleteSujet(sujet);
        return null;
    }

    @GetMapping("/sujetWithSpec/{idG}")
    List<Sujet> sujetBySpecialite(@PathVariable("idG") Long idG){

        return sujetService.sujetWithSpecialite(idG);
    }

    @GetMapping("/sujetsAffectés")
    List<Sujet> sujetsAffectes(){
        return sujetService.sujetsAffectes();
    }


    @GetMapping("/sujetsNonAffectés")
    List<Sujet> sujetsNonAffectes(){
        return sujetService.sujetsNonAffectes();
    }

    @DeleteMapping("/deleteById/{id}")
    Boolean DeleteSujetById(@PathVariable("id") Long id){
        sujetService.deleteSujetById(id);
        return null;
    }

    @PutMapping("/update/{id}")
    Sujet UpdateSujet(@RequestBody Sujet sujet,@PathVariable("id") Long id){
        return sujetService.updateSujet(id,sujet);
    }

    @PutMapping("/valid/{id}")
    void sujetValid(@PathVariable("id") Long id){
        sujetService.validSubject(id);
    }

    @PutMapping("/unvalid/{id}")
    void sujetUnvalid(@PathVariable("id") Long id){
        sujetService.UndoValidation(id);
    }


    @GetMapping("/valids")
    List<Sujet> sujetValids(){
        return  sujetService.listSujetValid();
    }

    @GetMapping("/NonValids")
    List<Sujet> sujetNonValids(){
        return  sujetService.listSujetNonValid();
    }

    @GetMapping("/sujetsEns/{idE}")
    List<Sujet> sujetWithEns(@PathVariable("idE") Long id){
        return sujetService.sujetWithEns(id);
    }
}

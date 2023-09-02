package com.example.subjectmanagement.APIs;

import com.example.subjectmanagement.Entities.Enseignant;
import com.example.subjectmanagement.Entities.Sujet;
import com.example.subjectmanagement.Repositories.EnseignantRepo;
import com.example.subjectmanagement.Services.EnseignantService;
import com.example.subjectmanagement.Services.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ens")
public class EnsApi {
    @Autowired
    EnseignantService enseignantService;
    @Autowired
    SujetService sujetService;
    @Autowired
    EnseignantRepo enseignantRepo;

    @PostMapping("/{idE}/addSujet")
    Sujet addSujet(@RequestBody Sujet sujet,@PathVariable("idE") Long idE){
        Enseignant enseignant = enseignantRepo.findById(idE).get();
        sujet.setEnseignant(enseignant);
        sujetService.addSujet(sujet);
        return sujet;
    }

    @PutMapping("/{idG}/updateSujet/{idS}")
    Sujet updateSujet(@RequestBody Sujet sujet,@PathVariable("idE") Long idE,@PathVariable("idS") Long idS){
        Enseignant enseignant = enseignantRepo.findById(idE).get();
        if (enseignant.getSujets().contains(sujet)){
            sujetService.updateSujet(idS,sujet);
        }
        return null;
    }

    @GetMapping("/listEns")
    List<Enseignant> listEns(){
      return   enseignantService.getAllEns();
    }

    @GetMapping("/DetailEns/{id}")
    Enseignant DetailEns(@PathVariable("id") Long id){
        return   enseignantService.DetailEnseignant(id);
    }

    @PutMapping("/update/{id}")
    Enseignant UpdateEns(@PathVariable("id") Long id, @RequestBody Enseignant ens){
        return enseignantService.UpdateEns(ens,id);
    }

    @DeleteMapping("/delete/{id}")
    void DeleteEns(@PathVariable("id") Long id){
        enseignantService.DeleteEns(id);
    }
}

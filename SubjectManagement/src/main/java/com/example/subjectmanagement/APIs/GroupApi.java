package com.example.subjectmanagement.APIs;

import com.example.subjectmanagement.Entities.Sujet;
import com.example.subjectmanagement.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupApi {
    @Autowired
    GroupService groupService;

    @PostMapping("/{idG}/choisirSujet/{idS}")
    void choisirSujet(@PathVariable("idS") Long ids,@PathVariable("idG") Long idg){
      groupService.choisirSujet(idg,ids);
    }

    @DeleteMapping("/{idG}/undoChoisirSujet/{idS}")
    void UndochoisirSujet(@PathVariable("idS") Long ids,@PathVariable("idG") Long idg){
        groupService.undoChoisirSujet(idg,ids);
    }

    @GetMapping("/listChoix/{idG}")
    Collection<Sujet> listSujet(@PathVariable("idG") Long idg){
       return groupService.getlistSujets(idg);
    }


    @PostMapping("/{idG}/wishForm/{idS}/{prio}")
    Sujet listSujetsWithPrio(@PathVariable("idS") Long idS,@PathVariable("idG") Long idG,
                                   @PathVariable("prio") int prio){
      return   groupService.wishForm(idS,idG,prio);
    }

    @PutMapping("/{idG}/affectSubject/{idS}")
    void affecterSujet(@PathVariable("idS") Long idS,@PathVariable("idG") Long idG){
        groupService.affecterSujet(idG,idS);

    }
}

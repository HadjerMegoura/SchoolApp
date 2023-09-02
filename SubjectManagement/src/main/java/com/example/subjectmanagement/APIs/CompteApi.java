package com.example.subjectmanagement.APIs;

import com.example.subjectmanagement.Entities.Compte;
import com.example.subjectmanagement.Entities.Specialite;
import com.example.subjectmanagement.Services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CompteApi {
    @Autowired
    CompteService userService;

    @PostMapping("/add")
    Compte addUser(@RequestBody Compte user, @RequestParam("sp")Specialite sp){

        return userService.addUser(user,sp);
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
    @PutMapping("/update/{id}")
    Compte updateUser(@PathVariable("id") Long id, @RequestBody Compte user,
                      @RequestParam("sp") Specialite sp){
        return userService.updateUser(id,user,sp);
    }

    @GetMapping("/allUsers")
    List<Compte> allUsers(){
      return   userService.getAllUsers();
    }
}

package com.example.project.Ws.ws;

import com.example.project.Services.service.CommandeService;
import com.example.project.beans.bean.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/commande")
public class CommandeWs {
    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }
    @GetMapping("/montant/{montant}")
    public Commande findByMontant(@PathVariable Long montant) {
        return commandeService.findByMontant(montant);
    }
    @GetMapping("/montant/{montant}/ref/{ref}")
    public Commande findByMontantAndRef(@PathVariable Long montant,@PathVariable String ref) {
        return commandeService.findByMontantAndRef(montant, ref);
    }

    @DeleteMapping("/ref/{ref}")
    public Commande deleteCommandeByRef(@PathVariable String ref) {
        return commandeService.deleteCommandeByRef(ref);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        commandeService.deleteAll();
    }
    @PostMapping("/")
     public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @Autowired
    private CommandeService commandeService;

}

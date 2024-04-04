package com.example.project.Services.service;

import com.example.project.Dao.dao.CommandeDao;
import com.example.project.beans.bean.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    public Commande findByMontant(Long montant) {
        return commandeDao.findByMontant(montant);
    }

    public Commande findByMontantAndRef(Long montant, String ref) {
        return commandeDao.findByMontantAndRef(montant, ref);
    }
    @Transactional
    public Commande deleteCommandeByRef(String ref) {
        return commandeDao.deleteCommandeByRef(ref);
    }
    @Transactional
    public void deleteAll() {
        commandeDao.deleteAll();
    }

   public  int  save(Commande commande) {
        if (commande.getRef()==null){
            return -1;
        }
        else if (commande.getMontant()== 0){
            return-2;
        }
       else if (commande.getNom()== null){
            return-3;
        }
        else if (findByRef(commande.getRef())!= null){
            return-4;
        }
        else{
            commandeDao.save(commande);
            return 0;

        }
   }

    public  List<Commande> findAll() {
        return commandeDao.findAll();
    }
}

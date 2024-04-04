package com.example.project.Dao.dao;

import com.example.project.beans.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);
    Commande findByMontant(Long montant);
    Commande findByMontantAndRef(Long montant , String ref);
    Commande deleteCommandeByRef(String ref);


}

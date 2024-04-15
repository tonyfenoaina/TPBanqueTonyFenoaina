/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.tfenoaina.tpbanquetonyfenoaina.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;
import mg.tfenoaina.tpbanquetonyfenoaina.entities.CompteBancaire;
import mg.tfenoaina.tpbanquetonyfenoaina.service.GestionnaireCompte;

/**
 *
 * @author info5
 */
@ApplicationScoped
public class Init {
      @Inject
      GestionnaireCompte gestionnaireCompte;
      
        @Transactional
    public void init(
            @Observes
            @Initialized(ApplicationScoped.class) ServletContext context
    ) {
        if (gestionnaireCompte.nbComptes() == 0) {
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }

    }
    
}

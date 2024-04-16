/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tfenoaina.tpbanquetonyfenoaina.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.tfenoaina.tpbanquetonyfenoaina.entities.CompteBancaire;
import mg.tfenoaina.tpbanquetonyfenoaina.service.GestionnaireCompte;

/**
 *
 * @author info5
 */
@Named(value = "compteBean")
@ViewScoped
public class CompteBean implements Serializable {

    /**
     * Creates a new instance of CompteBean
     */
    public CompteBean() {
    }
    private List<CompteBancaire> allComptes;
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Retourne la liste de tous les comptes 
     */
    public List<CompteBancaire> getAllCompteBancaires() {
        if (allComptes == null) {
            allComptes = gestionnaireCompte.getAllCompteBancaires();
        }
        return allComptes;
    }

}

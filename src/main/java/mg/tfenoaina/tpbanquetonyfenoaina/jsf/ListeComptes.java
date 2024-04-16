/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tfenoaina.tpbanquetonyfenoaina.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.tfenoaina.tpbanquetonyfenoaina.entities.CompteBancaire;
import java.util.List;
import mg.tfenoaina.tpbanquetonyfenoaina.jsf.util.Util;
import mg.tfenoaina.tpbanquetonyfenoaina.service.GestionnaireCompte;
/**
 *
 * @author info5
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    private List<CompteBancaire> allCompteBancaires;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllCompteBancaires() {
        if (allCompteBancaires == null) {
            allCompteBancaires = gestionnaireCompte.getAllCompteBancaires();
        }
        return allCompteBancaires;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gestionnaireCompte.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }

}
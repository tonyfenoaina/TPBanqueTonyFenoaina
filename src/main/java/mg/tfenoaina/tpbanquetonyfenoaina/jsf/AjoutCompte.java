/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tfenoaina.tpbanquetonyfenoaina.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import mg.tfenoaina.tpbanquetonyfenoaina.entities.CompteBancaire;
import mg.tfenoaina.tpbanquetonyfenoaina.jsf.util.Util;
import mg.tfenoaina.tpbanquetonyfenoaina.service.GestionnaireCompte;

/**
 *
 * @author info5
 */
@Named(value = "ajoutCompte")
@ViewScoped
public class AjoutCompte implements Serializable {

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }
    
       private String nom;
    @PositiveOrZero(message = "Le solde ne peut pas être négatif.")
    private int solde;

    @Inject
    GestionnaireCompte gestionnaireCompte;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

   
    public String action() {
        CompteBancaire compteBancaire = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(compteBancaire);
        Util.addFlashInfoMessage("Ajout de compte correctement effectué!");
        return "listeComptes?faces-redirect=true";
    }
    
}

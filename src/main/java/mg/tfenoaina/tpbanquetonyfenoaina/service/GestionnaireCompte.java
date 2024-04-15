/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.tfenoaina.tpbanquetonyfenoaina.service;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.tfenoaina.tpbanquetonyfenoaina.entities.CompteBancaire;

/**
 *
 * @author info5
 */

@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3308,
        user = "root", // nom et
        password = "root", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver",
            "serverTimezone=UTC",}
)

@ApplicationScoped
public class GestionnaireCompte {
    
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    /**
     * Méthode pour insérer un compte bancaire en passant en paramètre le compte
     * bancaire à enregistrer.
     *
     * @param compteBancaire
     */
    @Transactional
    public void creerCompte(CompteBancaire compteBancaire) {
        em.persist(compteBancaire);
    }
    
     /**
     * Méthode pour récuperer la liste des comptes bancaires.
     *
     * @return
     */
    public List<CompteBancaire> getAllCompteBancaires() {
        TypedQuery<CompteBancaire> query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
        return query.getResultList();
    }
    
        public Long nbComptes() {
            Query query = em.createQuery("SELECT count(c) FROM CompteBancaire c");
        return (long) query.getSingleResult();
    }
    
}

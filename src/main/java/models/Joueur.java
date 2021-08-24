package models;

/**
 *
 * @author z.zafar
 */
public class Joueur {
    String nom;
    String prenom;
    int age;
    String id;
    String mdp;

    public Joueur(String nom, String prenom, int age, String id, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.id = id;
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    
}

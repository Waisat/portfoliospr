package com.portfolio.models;



import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;





@Entity
public class Tache extends ElementProjet{
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "projet_id", referencedColumnName = "id")
	
	private Projet projet;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;
	
	public Tache() {
		
	}
	public Tache(String intitule, String description, LocalDate dateDebut, LocalDate dateFin,
			Boolean etatFormation, Projet projet, Utilisateur utilisateur) {
		super(intitule, description, dateDebut, dateFin, etatFormation);
		this.projet = projet;
		this.utilisateur = utilisateur;
		
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public String toString() {
		return "Tache [projet=" + projet + ", utilisateur=" + utilisateur + ", id=" + id + ", intitule=" + intitule
				+ ", description=" + description + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", etatFormation=" + etatProjet + "]";
	}
	
	
}

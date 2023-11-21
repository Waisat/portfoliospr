package com.portfolio.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;



@Entity
public class Projet extends ElementProjet {
	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	private Set<Tache> taches;
	@ManyToMany
	private Set<Utilisateur> utilisateurs;

	public Projet() {
		
	}
	public Projet(String intitule, String description, LocalDate dateDebut, LocalDate dateFin,
			Boolean etatFormation, Set<Tache> taches, Set<Utilisateur> utilisateurs) {
		super(intitule, description, dateDebut, dateFin, etatFormation);
		this.taches = taches;
		this.utilisateurs = utilisateurs;
		
		
	}
	public Set<Tache> getTaches() {
		return taches;
	}
	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@Override
	public String toString() {
		return "Projet [taches=" + taches + ", utilisateurs=" + utilisateurs + ", id=" + id + ", intitule=" + intitule
				+ ", description=" + description + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", etatFormation=" + etatProjet + "]";
	}
	
	
}

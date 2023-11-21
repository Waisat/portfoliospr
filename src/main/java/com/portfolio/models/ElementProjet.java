package com.portfolio.models;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementProjet{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int id;
	@Column(nullable = false)
	protected String intitule;
	@Column(nullable = false)
	protected String description;
	@Column(nullable = false , name="date_debut")
	protected LocalDate dateDebut;
	@Column(nullable = false ,name="date_fin")
	protected LocalDate dateFin;
	@Column(nullable = false ,name="etat_projet")
	protected Boolean etatProjet;
	
	public ElementProjet() {
		super();
	}

	public ElementProjet(String intitule, String description) {
		super();
		this.intitule = intitule;
		this.description = description;
	}

	public ElementProjet(String intitule, String description, LocalDate dateDebut, LocalDate dateFin,
			Boolean etatFormation) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatProjet = etatFormation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getEtatFormation() {
		return etatProjet;
	}

	public void setEtatFormation(Boolean etatFormation) {
		this.etatProjet = etatFormation;
	}

	@Override
	public String toString() {
		return "ElementProjet [id=" + id + ", intitule=" + intitule + ", description=" + description + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", etatFormation=" + etatProjet + "]";
	}
	
	
	
}

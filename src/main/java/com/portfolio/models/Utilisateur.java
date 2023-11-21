package com.portfolio.models;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	@Size(max = 20)
	private String nom;
	@Column(nullable = false)
	@Size(max = 50)
	private String prenom;
	@Column(nullable = false)
	@NotNull(message = "Email est requis")
	@Size(min = 5, max = 50, message = "Taille de mail invalide")
	@Pattern(message = "Email est invalide", regexp = "^.+@.+\\..+$")
	private String email;
	@Column(nullable = false , name="mot_de_passe")
	private String motDePasse;
	@Embedded
	private Role role;
	@Column(nullable = true)
	private String photo;
	@Column(nullable = false, name="date_naissance")
	private String dateNaissance;
	@ManyToMany
	private Set<Projet> projets;
	
	public Utilisateur() {
		
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Role role, String photo, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Role role, String photo,
			String dateNaissance, Set<Projet> projet) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.projets = projet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
    
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", motDePasse=" + motDePasse + ", role="
				+ role + ", photo=" + photo + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
}

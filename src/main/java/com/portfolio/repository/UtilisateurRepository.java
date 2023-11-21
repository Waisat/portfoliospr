package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.models.Utilisateur;



public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer>{

}

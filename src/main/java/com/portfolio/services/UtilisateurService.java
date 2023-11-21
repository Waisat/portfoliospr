package com.portfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.models.Utilisateur;
import com.portfolio.repository.UtilisateurRepository;




@Service
public class UtilisateurService {
	@Autowired
    private UtilisateurRepository utilisateurRepository;
	
	 public List<Utilisateur> getAllUtilisateur() {
	        return utilisateurRepository.findAll();
	    }
	 
	 public void addUtilisateur(Utilisateur nouveauUtilisateur) {
		 utilisateurRepository.save(nouveauUtilisateur);
	    }
	 
	 
	 public void deleteUtilisateur(Integer id) {
		 utilisateurRepository.deleteById(id);
	    }
	 
	 public Utilisateur getUtilisateurById(Integer id) {
	        return utilisateurRepository.findById(id).orElse(null);
	    }
	 
	 public void updateUtilisateur(Integer id, Utilisateur utilisateurModifie) {
	        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
	        if (utilisateur != null) {
	        	utilisateur.setNom(utilisateurModifie.getNom());
	        	utilisateur.setPrenom(utilisateurModifie.getPrenom());
	        	utilisateur.setPhoto(utilisateurModifie.getPhoto());
	        	utilisateur.setMotDePasse(utilisateurModifie.getMotDePasse());
	        	utilisateurRepository.save(utilisateur);
	        }
	    }
}

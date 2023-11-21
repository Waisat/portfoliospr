package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.portfolio.models.Utilisateur;
import com.portfolio.services.UtilisateurService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	@GetMapping({"/listeUtilisateur", "/"})
    public String listeUtilisateur(Model model) {
        // Utiliser le service pour obtenir la liste des Utilisateurs
       model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateur());
        return "liste-utilisateur";
    }
	
	
	@GetMapping("/ajoutUtilisateur")
    public String ajoutUtilisateur(Model model) {
        // Utiliser le service pour obtenir la liste des Utilisateurs
        //model.addAttribute("utilisateurs", UtilisateurService.getAllUtilisateur());
		 model.addAttribute("nouveauUtilisateur", new Utilisateur());
        return "ajouter-utilisateur";
    }
	
	@PostMapping("/ajoutUtilisateur")
    public String ajouterUtilisateur(@ModelAttribute("nouveauUtilisateur") @Valid Utilisateur nouveauUtilisateur, 
    		BindingResult result) {
        // Utiliser le service pour ajouter le nouveau Utilisateur
		if (result.hasErrors()) { 
			
			return "ajouter-utilisateur"; 
		}
		utilisateurService.addUtilisateur(nouveauUtilisateur);
        // Rediriger vers la liste des Utilisateurs
        return "redirect:/utilisateur/listeUtilisateur";
    }
	
	@GetMapping("/supprimerUtilisateur/{id}")
    public String supprimerUtilisateur(@PathVariable("id") Integer id) {
        // Utiliser le service pour supprimer l'utilisateur
		utilisateurService.deleteUtilisateur(id);
        // Rediriger vers la liste des utilisateurs
        return "redirect:/utilisateur/listeUtilisateur";
    }
	
	
	@GetMapping("/modifierUtilisateur/{id}")
    public String afficherFormulaireModification(@PathVariable("id") Integer id, Model model) {
        // Utiliser le service pour obtenir le utilisateur par ID
        Utilisateur utilisateurAModifier = utilisateurService.getUtilisateurById(id);

        if (utilisateurAModifier != null) {
            // Ajouter le utilisateur au modèle
            model.addAttribute("utilisateurAModifier", utilisateurAModifier);
            return "modifierUtilisateur";
        } else {
            // Rediriger vers la liste des livres si le livre n'est pas trouvé
            return "redirect:/utilisateur/listeUtilisateur";
        }
    }

    @PostMapping("/modifierUtilisateur/{id}")
    public String modifierLivre(@PathVariable("id") Integer id, @ModelAttribute("utilisateurAModifier") Utilisateur utilisateurModifie) {
        // Utiliser le service pour mettre à jour le utilisateur
    	utilisateurService.updateUtilisateur(id, utilisateurModifie);
        // Rediriger vers la liste des utilisteurs après la modification
        return "redirect:/utilisateur/listeUtilisateur";
    }
}

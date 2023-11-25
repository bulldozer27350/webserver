package com.openclassrooms.boulangerie.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.boulangerie.api.model.Article;
import com.openclassrooms.boulangerie.api.model.Category;
import com.openclassrooms.boulangerie.api.service.ArticleService;

@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	/**
	 * Create - Ajoute un nouvel article
	 * @param article Un objet article
	 * @return L'objet article sauvegardé
	 */
	@PostMapping("/article")
	@CrossOrigin(origins = "*")
	public Article createArticle(@RequestBody Article article) {
		return articleService.saveArticle(article);
	}
	/**
	 * Read - Récupère tous les articles
	 * @return - Une collection d'articles complètement renseignés
	 */
	@GetMapping("/articles")
	@CrossOrigin(origins = "*")
	public Iterable<Article> getArticles() {
		return articleService.getArticles();
	}
	
	
	/**
	 * Read - Récupère un article
	 * @param id L'identifiant de l'article
	 * @return Un article complètement renseigné ou null si l'id est inexistant
	 */
	@GetMapping("/article/{id}")
	/* La ligne suivante permet d'accéder à cette requête depuis le même serveur (localhost:8080 dans notre cas) que le client */
	@CrossOrigin(origins = "*")
	public ResponseEntity<Article> getArticle(@PathVariable("id") final Long id) {
		Optional<Article> article = articleService.getArticle(id);
		if(article.isPresent()) {
			return ResponseEntity.ok(article.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/**
	 * Update - Met à jour un article existant
	 * @param id - L'identifiant de l'article à mettre à jour
	 * @param article - L'article mis à jour
	 * @return
	 */
	@PutMapping("/article/{id}")
	@CrossOrigin(origins = "*")
	public Article updateArticle(@PathVariable("id") final Long id, @RequestBody Article article) {
		Optional<Article> e = articleService.getArticle(id);
		if(e.isPresent()) {
			Article currentArticle = e.get();
			String name = article.getName();
			if(name != null) {
				currentArticle.setName(name);
			}
			String shortDesc = article.getShortDescription();
			if(shortDesc != null) {
				currentArticle.setShortDescription(shortDesc);
			}
			String longDesc = article.getLongDescription();
			if(longDesc != null) {
				currentArticle.setLongDescription(longDesc);
			}
			Category category = article.getCategory();
			if(category != null) {
				currentArticle.setCategory(category);
			}
			// Attention, la quantité en stock ne peut pas être négative
			if (currentArticle.getStockNumber()<0) {
				currentArticle.setStockNumber(0);
			}
			currentArticle.setStockNumber(article.getStockNumber());
			articleService.saveArticle(currentArticle);
			return currentArticle;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Supprime un article
	 * @param id - L'identifiant de l'article à supprimer
	 */
	@DeleteMapping("/article/{id}")
	@CrossOrigin(origins = "*")
	public void deleteArticle(@PathVariable("id") final Long id) {
		articleService.deleteArticle(id);
	}
	

}
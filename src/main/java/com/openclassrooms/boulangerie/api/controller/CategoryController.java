package com.openclassrooms.boulangerie.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.boulangerie.api.model.Category;
import com.openclassrooms.boulangerie.api.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Create - Ajoute une nouvelle Category
	 * @param category Un objet category
	 * @return L'objet Category sauvegardée
	 */
	@PostMapping("/category")
	@CrossOrigin(origins = "*")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	
	/**
	 * Read - Récupère une Category
	 * @param id L'identifiant de Category
	 * @return Une category complètement renseignée ou nulle si l'id est inexistant
	 */
	@GetMapping("/category/{id}")
	@CrossOrigin(origins = "*")
	public Category getCategory(@PathVariable("id") final Long id) {
		Optional<Category> Category = categoryService.getCategory(id);
		if(Category.isPresent()) {
			return Category.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Récupère toutes les Categories
	 * @return - Une collection de Categories complètement renseignées
	 */
	@GetMapping("/categories")
	@CrossOrigin(origins = "*")
	public Iterable<Category> getCategorys() {
		return categoryService.getCategorys();
	}
	
	/**
	 * Read - Récupère toutes les Categories
	 * @return - Une collection de Categories complètement renseignées
	 */
	@GetMapping("/categories/fill")
	@CrossOrigin(origins = "*")
	public void fill() {
		this.categoryService.fill();
	}
	
	/**
	 * Update - Met à jour une Category existante
	 * @param id - L'identifiant de la Category à mettre à jour
	 * @param category - La Category mise à jour
	 * @return
	 */
	@PutMapping("/category/{id}")
	@CrossOrigin(origins = "*")
	public Category updateCategory(@PathVariable("id") final Long id, @RequestBody Category category) {
		Optional<Category> e = categoryService.getCategory(id);
		if(e.isPresent()) {
			Category currentCategory = e.get();
			String name = category.getName();
			if(name != null) {
				currentCategory.setName(name);
			}
			categoryService.saveCategory(currentCategory);
			return currentCategory;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Supprime une Category
	 * @param id - L'identifiant de la Category à supprimer
	 */
	@DeleteMapping("/category/{id}")
	@CrossOrigin(origins = "*")
	public void deleteCategory(@PathVariable("id") final Long id) {
		categoryService.deleteCategory(id);
	}
	

}
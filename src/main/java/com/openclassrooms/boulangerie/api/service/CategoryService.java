package com.openclassrooms.boulangerie.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.boulangerie.api.model.Category;
import com.openclassrooms.boulangerie.api.repository.CategoryRepository;

import lombok.Data;

@Data
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> getCategory(final Long id) {
		return categoryRepository.findById(id);
	}
	
	public Iterable<Category> getCategorys() {
		return categoryRepository.findAll();
	}
	
	public void deleteCategory(final Long id) {
		categoryRepository.deleteById(id);
	}
	
	public Category saveCategory(Category employee) {
		Category savedCategory = categoryRepository.save(employee);
		return savedCategory;
	}

}

package com.openclassrooms.boulangerie.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.boulangerie.api.model.Article;
import com.openclassrooms.boulangerie.api.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public Optional<Article> getArticle(final Long id) {
		return articleRepository.findById(id);
	}
	
	public Iterable<Article> getArticles() {
		return articleRepository.findAll();
	}
	
	public void deleteArticle(final Long id) {
		articleRepository.deleteById(id);
	}
	
	public Article saveArticle(Article employee) {
		Article savedArticle = articleRepository.save(employee);
		return savedArticle;
	}

}

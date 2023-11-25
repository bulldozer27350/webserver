package com.openclassrooms.boulangerie.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.boulangerie.api.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{

}
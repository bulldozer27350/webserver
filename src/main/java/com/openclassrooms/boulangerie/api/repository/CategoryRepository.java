package com.openclassrooms.boulangerie.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.boulangerie.api.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
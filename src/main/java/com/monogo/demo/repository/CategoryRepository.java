package com.monogo.demo.repository;

import com.monogo.demo.model.Category;
import com.monogo.demo.model.CategoryPrimaryKey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CategoryRepository extends MongoRepository<Category, CategoryPrimaryKey> {

    @Query(value = "{ $group : { _id : '$_id.name', variant: { $push: '$_id.variant' } } }")
    Map<String, List<String>> groupByName(String name);
}

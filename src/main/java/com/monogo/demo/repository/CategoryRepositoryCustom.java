package com.monogo.demo.repository;

import com.monogo.demo.model.Category;
import com.monogo.demo.model.CategoryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CategoryResults> aggregate() {
        TypedAggregation<Category> categoryAggregation = Aggregation.newAggregation(Category.class,
                Aggregation.group("id.name")
                        .first("id.name").as("name")
                        .push("id.variant").as("variants")
        );
        AggregationResults<CategoryResults> results = mongoTemplate.
                aggregate(categoryAggregation, CategoryResults.class);
        return results.getMappedResults();
    }
}

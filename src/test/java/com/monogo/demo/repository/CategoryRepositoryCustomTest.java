package com.monogo.demo.repository;

import com.monogo.demo.DemoApplication;
import com.monogo.demo.model.CategoryResults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CategoryRepositoryCustomTest {

    @Autowired
    private CategoryRepositoryCustom repository;

    @Test
    public void shouldReturnGroupedResults() throws Exception {
        List<CategoryResults> aggregtedValues = repository.aggregate();

        assertThat(aggregtedValues).isNotNull();
    }
}
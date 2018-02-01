package com.monogo.demo.repository;

import com.monogo.demo.DemoApplication;
import com.monogo.demo.model.Category;
import com.monogo.demo.model.CategoryPrimaryKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void shouldSaveTheCategory() throws Exception {
        CategoryPrimaryKey key = new CategoryPrimaryKey("1", "dummy1");
        Category category = new Category(key, "value");

        repository.save(category);

        Category actualCategory = repository.findOne(key);
        assertThat(actualCategory.getId()).isEqualToComparingFieldByField(key);
    }

    @Test
    public void shouldReturnAllCategories() throws Exception {
        CategoryPrimaryKey key = new CategoryPrimaryKey("2", "dummy2");
        Category category = new Category(key, "value");

        repository.save(category);

        Map<String, List<String>> actualCategory = repository.groupByName("2");
//        assertThat(actualCategory.get(0).getId()).isEqualToComparingFieldByField(key);

    }
}
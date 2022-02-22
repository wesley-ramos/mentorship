package br.com.developertips.sharing.core.category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
       
    public Category findByName(String name);
    public List<Category> findAll();
}

package br.com.developertips.sharing.api.category;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.developertips.sharing.core.category.CategoryRequestDTO;
import br.com.developertips.sharing.core.category.CategoryResponseDTO;
import br.com.developertips.sharing.core.category.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categories", description = "Registration and listing of categories")
public class CategoryController {
    
    private CategoryService service;
    
    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<CategoryResponseDTO> list(){
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public CategoryResponseDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CategoryRequestDTO category) {
        service.create(category);
    }
    
    @PutMapping("/{id}")
    public void change(@PathVariable("id") Long id, @RequestBody @Valid CategoryRequestDTO category) {
        service.change(id, category);
    }
    
    @DeleteMapping("/{id}")
    public void change(@PathVariable("id") Long id) {
        service.delete(id);
    }
}

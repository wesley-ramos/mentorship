package br.com.developertips.sharing.core.category;

import java.util.List;

public interface CategoryService {
    
    public CategoryResponseDTO findById(Long id);
    
    public List<CategoryResponseDTO> findAll();
    
    public void create(CategoryRequestDTO category);
    
    public void change(Long id, CategoryRequestDTO category);
    
    public void delete(Long id);
}

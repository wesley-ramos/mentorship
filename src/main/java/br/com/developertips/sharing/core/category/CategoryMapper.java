package br.com.developertips.sharing.core.category;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    
    public Category toEntity(CategoryRequestDTO model) {
        Category category = new Category();
        category.setName(model.getName());
        category.setExcluded(false);
        return category;
    }
    
    public Category toEntity(Long id, CategoryRequestDTO model) {
        Category category = toEntity(model);
        category.setId(id);
        return category;
    }
    
    public CategoryResponseDTO toDTO(Category entity) {
        return new CategoryResponseDTO(entity.getId() ,entity.getName());
    }
    
    public List<CategoryResponseDTO> toDTO(List<Category> categories){
        return categories.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}

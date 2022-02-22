package br.com.developertips.sharing.core.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.developertips.sharing.core.common.exception.AlreadyExistException;
import br.com.developertips.sharing.core.common.exception.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    private CategoryRepository repository;
    private CategoryMapper mapper;
    
    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Category %d was not found", id)));
        
        return mapper.toDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public void create(CategoryRequestDTO category) {
        
        if (repository.findByName(category.getName()) != null) {
            throw new AlreadyExistException("Category already exist");
        }
        
        repository.save(mapper.toEntity(category));
    }

    @Override
    public void change(Long id, CategoryRequestDTO category) {
        Category old = repository.findByName(category.getName());
        
        if(old != null && !old.getId().equals(id)) {
            throw new AlreadyExistException("Category already exist");
        }
        
        repository.save(mapper.toEntity(category));
    }

    @Override
    public void delete(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Category %d was not found", id)));
        
        category.setExcluded(true);
        repository.save(category);
    }
}

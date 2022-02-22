package br.com.developertips.sharing.core.category;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.developertips.sharing.core.common.exception.AlreadyExistException;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    
    @Mock
    private CategoryRepository repository;
    
    @Mock
    private CategoryMapper mapper;
    
    private CategoryService service;
    
    @BeforeEach
    public void init() {
        this.service = new CategoryServiceImpl(repository, mapper);
    }

    @Test
    public void whenUserTryToRegisterTwoCategoriesWithTheSameNameShouldThrownException() {
        Category category = new Category();
        category.setId(2l);
        category.setName("moveis");
        category.setExcluded(false);
        
        when(repository.findByName(category.getName())).thenReturn(category);
        
        CategoryRequestDTO request = new CategoryRequestDTO(category.getName());
        
        assertThrows(AlreadyExistException.class, () -> {
            service.create(request);
        });
    }
}

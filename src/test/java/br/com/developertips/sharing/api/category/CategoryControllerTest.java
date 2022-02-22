package br.com.developertips.sharing.api.category;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.developertips.sharing.ApplicationLauncher;
import br.com.developertips.sharing.api.IntegrationTest;
import br.com.developertips.sharing.core.category.CategoryRequestDTO;

@SpringBootTest(classes = ApplicationLauncher.class)
@AutoConfigureMockMvc
@IntegrationTest
public class CategoryControllerTest {
    
    @Autowired
    private MockMvc mock;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void create() throws Exception {
        
        CategoryRequestDTO request = new CategoryRequestDTO("Moveis");
        
        mock.perform(post("/api/v1/categories")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}

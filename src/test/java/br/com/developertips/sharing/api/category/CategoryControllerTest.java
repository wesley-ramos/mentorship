package br.com.developertips.sharing.api.category;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void create() throws Exception {
        
        CategoryRequestDTO request = new CategoryRequestDTO("Moveis");
        
        mock.perform(post("/api/v1/categories")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    @Test
    @Transactional
    @Sql(scripts = { "/scene/category/category.sql" })
    public void findCategoryById() throws Exception {
        mock.perform(get("/api/v1/categories/1")).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(Matchers.equalTo(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(Matchers.equalTo("eletrodomesticos")));
    }
}

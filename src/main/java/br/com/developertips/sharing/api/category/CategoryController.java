package br.com.developertips.sharing.api.category;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CategoryRequestDTO request) {
        System.out.println(request);
    }
    
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDTO> list(){
        
        List<CategoryResponseDTO> records = new ArrayList<>();
        
        CategoryResponseDTO moveis = new CategoryResponseDTO();
        moveis.setId(1);
        moveis.setName("Moveis");
        moveis.setExcluded(false);
        records.add(moveis);
        
        return records;
    }
}

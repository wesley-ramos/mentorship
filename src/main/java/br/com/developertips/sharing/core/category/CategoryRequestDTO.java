package br.com.developertips.sharing.core.category;

import javax.validation.constraints.NotEmpty;

public class CategoryRequestDTO {
    
    @NotEmpty(message="O nome é obrigatorio")
    private String name;
    
    public CategoryRequestDTO() {}
    
    public CategoryRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

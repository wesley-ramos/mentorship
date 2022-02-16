package br.com.developertips.sharing.api.category;

import javax.validation.constraints.NotEmpty;

public class CategoryRequestDTO {
    
    @NotEmpty(message="O nome é obrigatorio")
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}

package br.com.developertips.sharing.api.category;

import javax.validation.constraints.NotNull;

public class CategoryRequestDTO {
    
    @NotNull(message="O nome é obrigatorio")
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}

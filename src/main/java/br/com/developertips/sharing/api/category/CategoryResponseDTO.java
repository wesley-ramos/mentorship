package br.com.developertips.sharing.api.category;


public class CategoryResponseDTO {
    
    private Integer id;
    private String name;
    private boolean excluded;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isExcluded() {
        return excluded;
    }
    
    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    } 
}

package com.nanoo.consumer.entities.climb;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
public class Sector {

    private Long id;
    private String name;
    private String description;
    private Long idSite;
    
    public Sector() {
    }
    
    public Sector(Long id, String name, String description, Long idSite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idSite = idSite;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getIdSite() {
        return idSite;
    }
    
    public void setIdSite(Long idSite) {
        this.idSite = idSite;
    }
}

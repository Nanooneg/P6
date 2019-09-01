package com.nanoo.consumer.entities.climb;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
public class Site {

    private Long id;
    private String name;
    private String description;
    private String country;
    private String region;
    private String location;
    private boolean isOfficialLabel;
    private Long id_topo;
    
    public Site() {
    }
    
    public Site(Long id, String name, String description, String country, String region, String location, boolean isOfficialLabel, Long id_topo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.region = region;
        this.location = location;
        this.isOfficialLabel = isOfficialLabel;
        this.id_topo = id_topo;
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
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public boolean isOfficialLabel() {
        return isOfficialLabel;
    }
    
    public void setOfficialLabel(boolean officialLabel) {
        isOfficialLabel = officialLabel;
    }
    
    public Long getId_topo() {
        return id_topo;
    }
    
    public void setId_topo(Long id_topo) {
        this.id_topo = id_topo;
    }
}

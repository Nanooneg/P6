package com.nanoo.consumer.entities.climb;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
public class Way {
    
    private Long id;
    private String name;
    private String description;
    private String rating;
    private int pitchNbr;
    private int anchorNbr;
    private Long idSector;
    
    public Way() {
    }
    
    public Way(Long id, String name, String description, String rating, int pitchNbr, int anchorNbr, Long idSector) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.pitchNbr = pitchNbr;
        this.anchorNbr = anchorNbr;
        this.idSector = idSector;
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
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public int getPitchNbr() {
        return pitchNbr;
    }
    
    public void setPitchNbr(int pitchNbr) {
        this.pitchNbr = pitchNbr;
    }
    
    public int getAnchorNbr() {
        return anchorNbr;
    }
    
    public void setAnchorNbr(int anchorNbr) {
        this.anchorNbr = anchorNbr;
    }
    
    public Long getIdSector() {
        return idSector;
    }
    
    public void setIdSector(Long idSector) {
        this.idSector = idSector;
    }
}

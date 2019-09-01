package com.nanoo.consumer.entities.picture;

/**
 * @author nanoo
 * @create 31/08/2019 - 12:20
 */
public class Picture {

    private Long id;
    private String path;
    private String name;
    private Long idTopo;
    private Long idSite;
    
    public Picture() {
    }
    
    public Picture(Long id, String path, String name, Long idTopo, Long idSite) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.idTopo = idTopo;
        this.idSite = idSite;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getIdTopo() {
        return idTopo;
    }
    
    public void setIdTopo(Long idTopo) {
        this.idTopo = idTopo;
    }
    
    public Long getIdSite() {
        return idSite;
    }
    
    public void setIdSite(Long idSite) {
        this.idSite = idSite;
    }
}

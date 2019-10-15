package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.mapper.TopoMapper;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.business.util.UploadUtil;
import com.nanoo.consumer.repository.TopoRepository;
import com.nanoo.model.entities.Topo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author nanoo
 * @create 24/09/2019 - 00:07
 */
@Service
@Transactional
@Data
public class TopoServiceImpl implements TopoService {
    
    private static final Logger log = LoggerFactory.getLogger(TopoServiceImpl.class);
    
    private static final String SUCCESS_MESS = "L'enregistrement est un succés !";
    private static final String ERROR_MESS = "L'enregistrement est un échec !";
    
    private static final String TOPO_ATT = "topo";
    
    private String result;
    private DateUtil dateUtil;
    private UploadUtil uploadUtil;
    private HandlingEnumValues enumValues;
    
    private final TopoRepository topoRepository;
    
    private final TopoMapper topoMapper;
    
    @Autowired
    public TopoServiceImpl(TopoRepository topoRepository, TopoMapper topoMapper) {
        this.topoRepository = topoRepository;
        this.topoMapper = topoMapper;
    }
    
    
    /**
     * This method save a topo in DB.
     *
     * @param topoDTO topo to save.
     */
    @Override
    public void saveTopo(TopoDTO topoDTO){
        result="";
        dateUtil = new DateUtil();
        uploadUtil = new UploadUtil();
        Topo existingTopo;
    
        Topo topo = topoMapper.fromDtoToTopo(topoDTO);
    
        if (topoDTO.getId() != null) {
            Optional<Topo> oldTopo = topoRepository.findById(topoDTO.getId());
            if (oldTopo.isPresent()) {
                existingTopo = oldTopo.get();
                topo.setDateOfCreation(existingTopo.getDateOfCreation());
                topo.setIdAccount(existingTopo.getIdAccount());
                topo.setPicturePath(existingTopo.getPicturePath());
            }
        }else{
            topo.setDateOfCreation(new Date());
        }
    
        topo.setDateOfUpdate(new Date());
    
        if ((!Objects.equals(topo.getPicture().getOriginalFilename(), "")) && topo.getPicture() != null){
            topo.setPicturePath(uploadUtil.doUpload(topo.getPicture(),topo.getName(),topo.getDateOfUpdate().toString(),TOPO_ATT));
        }
    
        try {
            topoRepository.save(topo);
            result = SUCCESS_MESS;
        }catch (Exception e){
            result = ERROR_MESS;
        }
    }
    
    /**
     * This method delete a topo in DB.
     *
     * @param topoId id of topo to delete
     */
    @Override
    public void deleteTopo(int topoId){
        topoRepository.deleteById(topoId);
    }
    
    /**
     * This method search all topos in DB.
     *
     * @return list of topos
     */
    @Override
    public List<TopoDTO> findAllTopo() {
        Iterable<Topo> topoIterable = topoRepository.findAll(Sort.by("dateOfCreation"));
        List<TopoDTO> topoDTOList = new ArrayList<>();
    
        for (Topo topo : topoIterable){
            topoDTOList.add(topoMapper.fromTopoToDto(topo));
        }
    
        return topoDTOList;
    }
    
    /**
     * This method search a distinct topo in DB
     *
     * @param topoId id of topo searched
     * @return the topo searched if exist
     */
    @Override
    public TopoDTO searchTopoById(int topoId) {
        Optional<Topo> topo = topoRepository.findById(topoId);
    
        if (topo.isPresent()) {
            Topo existingTopo = topo.get();
            return topoMapper.fromTopoToDto(existingTopo);
        }
    
        return null;
    }
    
    /**
     * This method search topo who match with criteria
     * contained in object {@code filter}
     *
     * @param filter object with search criteria as attributs
     * @return a list of topos who match with criteria if exist
     */
    @Override
    public List<TopoDTO> searchTopoByFilter(SearchFilter filter) {
        result = "";
        dateUtil = new DateUtil();
        enumValues = new HandlingEnumValues();
        
        String fRegion = filter.getRegion();
        boolean fLendable = filter.isLendable();
        Date fPublication = dateUtil.calculateDate(filter.getPublication());
        
        List<Topo> topoList = topoRepository.findAllByFilter(fRegion,fLendable,fPublication);
        List<TopoDTO> topoDTOList = new ArrayList<>();
        
        for (Topo topo : topoList){
            TopoDTO topoDTO = topoMapper.fromTopoToDto(topo);
            topoDTOList.add(topoDTO);
        }
        
        if (topoDTOList.isEmpty())
            result = "Aucun site ne correspond à vos critères";
        else if (topoDTOList.size() == 1)
            result = topoDTOList.size() + " site correspond à vos critères";
        else
            result = topoDTOList.size() + " sites correspondent à vos critères";
        
        return topoDTOList;
    }
    
    /**
     * This method search topo posted by a particular user
     *
     * @param accountId of the user
     * @return a list of topo if exist
     */
    @Override
    public List<TopoDTO> searchTopoByAccountId(Integer accountId) {
        Iterable<Topo> topoIterable = topoRepository.findAllByIdAccount(accountId, Sort.by("dateOfCreation"));
        List<TopoDTO> topoDTOList = new ArrayList<>();
    
        for (Topo topo : topoIterable){
            topoDTOList.add(topoMapper.fromTopoToDto(topo));
        }
    
        return topoDTOList;
    }
}

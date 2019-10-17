package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.dto.TopoDTO;
import com.nanoo.business.mapper.TopoBookingMapper;
import com.nanoo.business.mapper.TopoMapper;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.business.util.DateUtil;
import com.nanoo.business.util.HandlingEnumValues;
import com.nanoo.business.util.SearchFilter;
import com.nanoo.business.util.UploadUtil;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.consumer.repository.TopoBookingRepository;
import com.nanoo.consumer.repository.TopoRepository;
import com.nanoo.model.entities.Topo;
import com.nanoo.model.entities.TopoBooking;
import com.nanoo.model.enums.EnumStatus;
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
    private Calendar calendar;
    
    
    private final TopoRepository topoRepository;
    private final TopoBookingRepository topoBookingRepository;
    private final AccountRepository accountRepository;
    
    private final TopoMapper topoMapper;
    private final TopoBookingMapper topoBookingMapper;
    
    @Autowired
    public TopoServiceImpl(TopoRepository topoRepository, TopoBookingRepository topoBookingRepository, AccountRepository accountRepository, TopoMapper topoMapper, TopoBookingMapper topoBookingMapper) {
        this.topoRepository = topoRepository;
        this.topoBookingRepository = topoBookingRepository;
        this.accountRepository = accountRepository;
        this.topoMapper = topoMapper;
        this.topoBookingMapper = topoBookingMapper;
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
    
    /**
     * This method save a topoBooking in DB.
     *
     * @param accountId id of borrower
     * @param topoId id of topo who's lended
     */
    @Override
    public void saveTopoBooking(Integer accountId, Integer topoId){
        
        TopoBooking tBooking = new TopoBooking();
        calendar = Calendar.getInstance();
        //calendar.add(Calendar.DAY_OF_WEEK,2);
        calendar.add(Calendar.MINUTE,5);
        
        tBooking.setIdTopo(topoId);
        tBooking.setIdAccountBorrower(accountId);
        tBooking.setStatus(EnumStatus.PENDING.getAbbreviation());
        tBooking.setDateOfCreation(new Date());
        tBooking.setDateOfUpdate(new Date());
        tBooking.setDateOfExpiry(calendar.getTime());
        
        topoBookingRepository.save(tBooking);
    }
    
    /**
     * This method search all topobooking who concern particular Topo owner user.
     *
     * @param accountId id of user concerned
     * @return list of topobooking if exist
     */
    @Override
    public List<TopoBookingDTO> searchAllTopoBookingByTopoAccountId(Integer accountId){
        
        Set<Integer> topoIdList = topoRepository.getTopoIdByAccountId(accountId);
        List<TopoBooking> topoBookingList = topoBookingRepository.findAllTopoBookingByIdTopo(topoIdList);
        List<TopoBookingDTO> topoBookingDTOList = new ArrayList<>();
        
        for (TopoBooking topoBooking : topoBookingList){
            topoBookingDTOList.add(topoBookingMapper.fromTopoBookingToDto(topoBooking));
        }
        
        return topoBookingDTOList;
    }
    
    /**
     * This method search all topobooking who concern particular user.
     *
     * @param accountId id of user
     * @return list of topoBooking if exist
     */
    @Override
    public List<TopoBookingDTO> searchAllTopoBookingByAccountId(int accountId) {
    
        List<TopoBooking> topoBookingList = topoBookingRepository.findAllByIdAccountBorrower(accountId);
        List<TopoBookingDTO> topoBookingDTOList = new ArrayList<>();
    
        for (TopoBooking topoBooking : topoBookingList){
            topoBookingDTOList.add(topoBookingMapper.fromTopoBookingToDto(topoBooking));
        }
    
        return topoBookingDTOList;
    }
    
    /**
     * This method change topobooking status and if needed topo Lendable status too.
     *
     * @param userId        id of user who answer the request
     * @param topoBookingId id of topobooking the status will be changed
     * @param answer        answer of user
     */
    @Override
    public void changeStatus(String userId, String topoBookingId, String answer) {
    
        Optional<TopoBooking> topoBooking = topoBookingRepository.findById(Integer.parseInt(topoBookingId));
        TopoBooking existingTopoBooking;
        calendar = Calendar.getInstance();
        //calendar.add(Calendar.DAY_OF_WEEK,2);
        calendar.add(Calendar.MINUTE,5);
        
        if(topoBooking.isPresent()){
            existingTopoBooking = topoBooking.get();
            if (answer.equals("acceptance")) {
                String ownerMail = accountRepository.findMailById(Integer.parseInt(userId));
                Optional<Topo> topo = topoRepository.findById(existingTopoBooking.getIdTopo());
                Topo existingTopo;
                
                existingTopoBooking.setStatus(EnumStatus.ACCEPTED.getAbbreviation());
                existingTopoBooking.setOwnerMail(ownerMail);
                existingTopoBooking.setDateOfUpdate(new Date());
                existingTopoBooking.setDateOfExpiry(calendar.getTime());
                
                topoBookingRepository.save(existingTopoBooking);
                
                if (topo.isPresent()){
                    existingTopo = topo.get();
                    existingTopo.setLendable(false);
                    topoRepository.save(existingTopo);
                }
            }else if (answer.equals("refusal")){
                existingTopoBooking.setStatus(EnumStatus.REFUSED.getAbbreviation());
                topoBookingRepository.save(existingTopoBooking);
            }
        }
    }
}

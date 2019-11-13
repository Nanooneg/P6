package com.nanoo.business.serviceImpl;

import com.nanoo.business.dto.TopoBookingDTO;
import com.nanoo.business.mapper.TopoBookingMapper;
import com.nanoo.business.serviceContract.TopoBookingService;
import com.nanoo.business.serviceContract.TopoService;
import com.nanoo.consumer.repository.AccountRepository;
import com.nanoo.consumer.repository.TopoBookingRepository;
import com.nanoo.consumer.repository.TopoRepository;
import com.nanoo.model.entities.Topo;
import com.nanoo.model.entities.TopoBooking;
import com.nanoo.model.enums.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author nanoo
 * @create 03/11/2019 - 13:38
 */
@Service
public class TopoBookingServiceImpl implements TopoBookingService {
    
    private Calendar calendar;
    
    private final TopoBookingRepository topoBookingRepository;
    private final AccountRepository accountRepository;
    private final TopoRepository topoRepository;
    
    private final TopoBookingMapper topoBookingMapper;
    
    @Autowired
    public TopoBookingServiceImpl(TopoService topoService, TopoBookingRepository topoBookingRepository, AccountRepository accountRepository, TopoRepository topoRepository, TopoBookingMapper topoBookingMapper) {
        this.topoBookingRepository = topoBookingRepository;
        this.accountRepository = accountRepository;
        this.topoRepository = topoRepository;
        this.topoBookingMapper = topoBookingMapper;
    }
    
    
    /**
     * This method save a topoBooking in DB.
     *
     * @param accountId id of borrower
     * @param topoId id of topo who's lent
     */
    @Override
    public void saveTopoBooking(Integer accountId, Integer topoId){
        
        TopoBooking tBooking = new TopoBooking();
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK,2);
        
        tBooking.setIdTopo(topoId);
        tBooking.setIdAccountBorrower(accountId);
        tBooking.setIdAccountOwner(topoRepository.getAccountIdByTopoId(topoId));
        tBooking.setStatus(EnumStatus.PENDING.getAbbreviation());
        tBooking.setDateOfCreation(new Date());
        tBooking.setDateOfUpdate(new Date());
        tBooking.setDateOfExpiry(calendar.getTime());
        
        topoBookingRepository.save(tBooking);
    }
    
    
    
    /**
     * This method search all topobooking who concern particular Topo owner user but return only pending status topobooking.
     *
     * @param accountId id of user concerned
     * @return list of topobooking with pending status if exist
     */
    @Override
    public List<TopoBookingDTO> searchAllTopoBookingByIdOwnerWithPendingStatus(Integer accountId){
        List<TopoBookingDTO> topoBookingDTOList = searchAllTopoBookingByIdOwner(accountId);
        List<TopoBookingDTO> topoBookingPendingDTOList = new ArrayList<>();
        
        for (TopoBookingDTO topoBookingDTO : topoBookingDTOList){
            if(topoBookingDTO.getStatus().equals(EnumStatus.PENDING.getAbbreviation())){
                topoBookingPendingDTOList.add(topoBookingDTO);
            }
        }
        
        return topoBookingPendingDTOList;
    }
    
    /**
     * This method search all topobooking who concern particular user.
     *
     * @param accountId id of user
     * @return list of topoBooking if exist
     */
    @Override
    public List<TopoBookingDTO> searchAllTopoBookingByIdBorrower(int accountId) {
        
        List<TopoBooking> topoBookingList = topoBookingRepository.findAllByIdAccountBorrower(accountId);
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
    public List<TopoBookingDTO> searchAllTopoBookingByIdOwner(int accountId) {
        
        List<TopoBooking> topoBookingList = topoBookingRepository.findAllByIdAccountOwner(accountId);
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
        calendar.add(Calendar.DAY_OF_WEEK,2);
        
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
    
    /**
     * This method delete a topoBooking in DB
     *
     * @param topoBookingId id of topobooking to delete
     */
    @Override
    public void deleteTopoBooking(int topoBookingId) {
        
        topoBookingRepository.deleteById(topoBookingId);
    }
    
    /**
     * This method search if a topoBooking exist in db
     *
     * @param accountId id of user
     * @param topoId    id of topo
     * @return true if exist
     */
    @Override
    public boolean checkTopoBookingAskRequest(String accountId, String topoId) {
        
        return topoBookingRepository.findByIdAccountBorrowerAndIdTopo(Integer.parseInt(accountId), Integer.parseInt(topoId)) == null;
    }
    
}

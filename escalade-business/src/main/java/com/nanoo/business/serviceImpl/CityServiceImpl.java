package com.nanoo.business.serviceImpl;

import com.nanoo.business.serviceContrat.CityService;
import com.nanoo.consumer.repoContrat.user.CityRepository;
import com.nanoo.model.entities.user.CityCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 01/09/2019 - 17:38
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityRepository cityRepository;
    
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository=cityRepository;
    }
    
    public void saveTest (CityCode cityCode){
        cityRepository.save(cityCode);
    }
    
}

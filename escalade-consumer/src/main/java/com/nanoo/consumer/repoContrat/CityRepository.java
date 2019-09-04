package com.nanoo.consumer.repoContrat;

import com.nanoo.model.entities.user.CityCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 01/09/2019 - 17:37
 */
@Repository
public interface CityRepository extends CrudRepository<CityCode,Integer> {
    
}

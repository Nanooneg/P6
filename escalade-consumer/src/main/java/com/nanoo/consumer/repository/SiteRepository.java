package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:52
 */
@Repository
public interface SiteRepository extends CrudRepository<Site,Integer> {
}

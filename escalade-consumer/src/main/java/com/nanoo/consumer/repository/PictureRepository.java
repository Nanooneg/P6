package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:04
 */
@Repository
public interface PictureRepository extends CrudRepository<Picture,Integer> {
}

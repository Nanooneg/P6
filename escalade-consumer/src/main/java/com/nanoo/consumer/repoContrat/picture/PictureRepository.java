package com.nanoo.consumer.repoContrat.picture;

import com.nanoo.model.entities.picture.Picture;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nanoo
 * @create 04/09/2019 - 18:04
 */
public interface PictureRepository extends CrudRepository<Picture,Integer> {
}

package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Commentary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:47
 */
@Repository
public interface CommentaryRepository extends CrudRepository<Commentary,Integer> {
}

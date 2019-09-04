package com.nanoo.consumer.repoContrat.publication;

import com.nanoo.model.entities.publication.Commentary;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:47
 */
public interface CommentaryRepository extends CrudRepository<Commentary,Integer> {
}

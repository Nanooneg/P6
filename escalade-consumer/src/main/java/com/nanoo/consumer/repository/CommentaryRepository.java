package com.nanoo.consumer.repository;

import com.nanoo.model.entities.Commentary;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:47
 */
@Repository
public interface CommentaryRepository extends PagingAndSortingRepository<Commentary,Integer> {
    
    /**
     * This method find all commentaries associated to a particular publication.
     *
     * @param publicationId id of the publication we are looking commentaries for
     * @param sort way to sort commentaries
     * @return a list of commentaries if exist
     */
    List<Commentary> findAllByIdPublication(Integer publicationId, Sort sort);
    
}

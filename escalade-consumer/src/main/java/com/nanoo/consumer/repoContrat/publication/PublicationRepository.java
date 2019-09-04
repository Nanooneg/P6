package com.nanoo.consumer.repoContrat.publication;

import com.nanoo.model.entities.publication.Publication;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nanoo
 * @create 04/09/2019 - 17:51
 */
public interface PublicationRepository extends CrudRepository<Publication,Integer> {
}

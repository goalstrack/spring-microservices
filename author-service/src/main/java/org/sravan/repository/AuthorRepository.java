package org.sravan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.sravan.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}

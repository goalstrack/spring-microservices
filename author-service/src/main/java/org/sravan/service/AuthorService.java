package org.sravan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sravan.entity.Author;
import org.sravan.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	public Author addAuthor(Author author) {
		return repository.save(author);
	}

	public Author updateAuthor(Author author) {
		if (repository.existsById(author.getId())) {
			return repository.save(author);
		}
		throw new RuntimeException("Author with id " + author.getId() + " not exists");
	}

	public void delete(long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new RuntimeException("Author with id " + id + " not exists");
		}
	}

	public Iterable<Author> getAll() {
		return repository.findAll();
	}

	public Author finidById(long id) {
		if (repository.existsById(id)) {
			return repository.findById(id).get();
		}
		throw new RuntimeException("author with id " + id + " not exists");
	}
}

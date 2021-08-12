package org.sravan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sravan.entity.Author;
import org.sravan.service.AuthorService;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Author addAuthor(@RequestBody Author author) {
		return service.addAuthor(author);
	}

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public Author updateAuthor(@RequestBody Author author) {
		return service.updateAuthor(author);
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.DELETE, path = "/{id}")
	public void deleteAuthor(@PathVariable long id) {
		service.delete(id);
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public Iterable<Author> getAuthors() {
		return service.getAll();
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET, path = "/{id}")
	public Author getAuthor(@PathVariable long id) {
		return service.finidById(id);
	}
}

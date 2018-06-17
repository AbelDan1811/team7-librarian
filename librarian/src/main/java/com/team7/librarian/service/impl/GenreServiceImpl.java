package com.team7.librarian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.Book;
import com.team7.librarian.model.Genre;
import com.team7.librarian.repository.GenreRepository;
import com.team7.librarian.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public Genre findGenreByType(String type) {
		return genreRepository.findByType(type);
	}

	@Override
	public List<Book> getAllBooksByGenre(String type) {
		Genre genre = findGenreByType(type);
		return genre.getBooks();
	}

	@Override
	public void save(Genre genre) {
		genreRepository.save(genre);
	}

}

package com.team7.librarian.service;

import java.util.List;

import com.team7.librarian.model.Book;
import com.team7.librarian.model.Genre;

public interface GenreService {
	public Genre findGenreByType(String type);
	public List<Book> getAllBooksByGenre(String type);
	public void save(Genre genre);
}

package com.team7.librarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team7.librarian.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	public Genre findByType(String type);
}

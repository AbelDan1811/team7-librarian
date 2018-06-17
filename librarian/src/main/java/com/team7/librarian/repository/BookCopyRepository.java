package com.team7.librarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team7.librarian.model.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

}

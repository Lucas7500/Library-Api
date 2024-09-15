package com.library.api.repositories;

import com.library.api.domain.book.Book;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository extends BaseRepository<Book> {
    @Override
    public Book get(String id) {
        try(IDocumentSession session = openSession()) {
            return session.load(Book.class, id);
        }
    }

    @Override
    public List<Book> getAll() {
        try(IDocumentSession session = openSession()) {
            return session.query(Book.class).toList();
        }
    }

    @Override
    public Book save(Book book) {
        try(IDocumentSession session = openSession()) {
            session.store(book);
            session.saveChanges();

            return book;
        }
    }

    @Override
    public void update(Book updatedBook) {
        try(IDocumentSession session = openSession()) {
            Book book = session.load(Book.class, updatedBook.getId());

            book.setTitle(updatedBook.getTitle());
            book.setGenres(updatedBook.getGenres());
            book.setPages(updatedBook.getPages());
            book.setRelease(updatedBook.getRelease());
            book.setSynopsis(updatedBook.getSynopsis());
            book.setAuthorsIds(updatedBook.getAuthorsIds());
            book.setPublisherId(updatedBook.getPublisherId());

            session.saveChanges();
        }
    }

    @Override
    public void delete(String id) {
        try (IDocumentSession session = openSession()) {
            if (session.advanced().exists(id)) {
                session.delete(id);
                session.saveChanges();
            }
        }
    }

}

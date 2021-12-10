package hu.unideb.inf.bookdepository.service;

import hu.unideb.inf.bookdepository.exception.BookNotFoundException;
import hu.unideb.inf.bookdepository.model.Book;
import hu.unideb.inf.bookdepository.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book){
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepo.save(book);
    }

    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteBook(Long id){
        bookRepo.deleteBookById(id);
    }

    public Book findBookById(Long id){
        return bookRepo.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book by id " + id + "was not found."));
    }
}

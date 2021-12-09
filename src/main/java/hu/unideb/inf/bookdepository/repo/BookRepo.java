package hu.unideb.inf.bookdepository.repo;

import hu.unideb.inf.bookdepository.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {
    void deleteBookById(Long id);

    Optional<Book> findBookById(Long id);
}

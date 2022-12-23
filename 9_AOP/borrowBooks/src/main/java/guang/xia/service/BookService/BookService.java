package guang.xia.service.BookService;

import guang.xia.model.Book;
import guang.xia.model.User;
import guang.xia.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserByCode(String code) {
        return Optional.empty();
    }
}

package domain;

import domain.exception.ServiceFailedToGetBooksException;
import ports.reader.InMemoryBooksRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookService {
    private final BooksRepository booksRepository;
    private InMemoryBooksRepository inMemoryBooksRepository;

    public BookService(BooksRepository booksRepository) throws Exception {
        this.booksRepository = booksRepository;
        this.inMemoryBooksRepository = new InMemoryBooksRepository(booksRepository.getAllBooks());
    }

    List<Book> getBooks() throws ServiceFailedToGetBooksException {
        try {
            return inMemoryBooksRepository.getAllBooks();
        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to get all books");
        }
    }

    List<Book> getBooksAbc() throws ServiceFailedToGetBooksException {
        try {
            List<Book> allBooks = inMemoryBooksRepository.getAllBooks();

            if (allBooks.size() > 0) {
                allBooks.sort(new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getAuthor().compareTo(o2.getAuthor());
                    }
                });
            }
            return allBooks;

        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to get all books");
        }
    }

    List<Book> getBooksByAuthors(String author) throws ServiceFailedToGetBooksException {
        try {
            return inMemoryBooksRepository.getAllBooks().stream().filter(
                    book -> book.getAuthor().contains(author)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to get books by author");
        }
    }

    List<Book> getBooksAfterRemovingAuthors(String author) throws ServiceFailedToGetBooksException {
        try {
            Set<String> authors = inMemoryBooksRepository.getAllBooks().stream().map(Book::getAuthor).filter(
                    bookAuthor -> bookAuthor.contains(author)).collect(Collectors.toSet());

            List<Book> books = inMemoryBooksRepository.getAllBooks();

            books.removeIf(a -> authors.contains(a.getAuthor()));

            return books;

        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to delete books");
        }
    }
}

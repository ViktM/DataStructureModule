package domain;

import domain.exception.ServiceFailedToGetBooksException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookService {
    private final BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    List<Book> getBooks() throws ServiceFailedToGetBooksException {
        try {
            return booksRepository.getAllBooks();
        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to get all books");
        }
    }

    //Try this with Trees perhaps?
    List<Book> getBooksAbc() throws ServiceFailedToGetBooksException {
        try {
            List<Book> allBooks = booksRepository.getAllBooks();

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
            return booksRepository.getAllBooks().stream().filter(
                    book -> book.getAuthor().contains(author)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to get books by author");
        }
    }

    //Implement this to actually delete entries from books list. It now just re-fetches the list from the json file
    //so the entries deleted will be put back
    List<Book> getBooksAfterRemovingAuthors(String author) throws ServiceFailedToGetBooksException {
        try {
            Set<String> authors = booksRepository.getAllBooks().stream().map(Book::getAuthor).filter(
                    bookAuthor -> bookAuthor.contains(author)).collect(Collectors.toSet());

            List<Book> books = booksRepository.getAllBooks();

            books.removeIf(a -> authors.contains(a.getAuthor()));

            return books;

        } catch (Exception e) {
            throw new ServiceFailedToGetBooksException("Service failed to delete books");
        }
    }
}

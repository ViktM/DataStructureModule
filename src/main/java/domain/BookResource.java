package domain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;
    private String defaultAuthor;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    public BookResource(BookService bookService, String defaultAuthor) {
        this.bookService = bookService;
        this.defaultAuthor = defaultAuthor;
    }

    @GET
    @Path("/allbooks")
    public List<Book> showAllBooks() throws Exception {
        return bookService.getBooks();
    }

    @GET
    @Path("/allbooksAbc")
    public List<Book> showAllBooksAbc() throws Exception {
        return bookService.getBooksAbc();
    }

    @GET
    @Path("/authorSearch")
    public List<Book> showAllBooksByAuthor(@QueryParam("author") Optional<String> author) throws Exception {
        return bookService.getBooksByAuthors(author.orElse(defaultAuthor));
    }

    @GET
    @Path("/deleteAuthor")
    public List<Book> showAllBooksAfterDeleted(@QueryParam("author") Optional<String> author) throws Exception {
        return bookService.getBooksAfterRemovingAuthors(author.orElse(defaultAuthor));
    }

    @GET
    @Path("/addBook")
    public List<Book> showAllBooksAfterAddingNew(
            @QueryParam("author") Optional<String> author,
            @QueryParam("country") Optional<String> country,
            @QueryParam("imageLink") Optional<String> imageLink,
            @QueryParam("language") Optional<String> language,
            @QueryParam("link") Optional<String> link,
            @QueryParam("pages") Optional<Integer> pages,
            @QueryParam("title") Optional<String> title,
            @QueryParam("year") Optional<Integer> year
    ) throws Exception {
        return bookService.getBooksAfterAddingAuthor(
                author.orElse(null),
                country.orElse(null),
                imageLink.orElse(null),
                language.orElse(null),
                link.orElse(null),
                pages.orElse(0),
                title.orElse(null),
                year.orElse(0));
    }
}

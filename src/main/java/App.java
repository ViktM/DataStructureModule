import config.AppConfig;
import domain.BookResource;
import domain.BookService;
import domain.BooksRepository;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import ports.reader.JsonBookRepository;

public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfig config, Environment environment) throws Exception {
        registerBookResources(config, environment);
        registerBookResourcesByAuthor(config, environment);
    }

    private void registerBookResources(AppConfig config, Environment environment) {
        BooksRepository booksRepository =
                new JsonBookRepository(config.getLibraryPath(), environment.getObjectMapper());
        BookService bookService = new BookService(booksRepository);
        final BookResource bookResource = new BookResource(bookService);
        environment.jersey().register(bookResource);
    }

    private void registerBookResourcesByAuthor(AppConfig config, Environment environment) {
        BooksRepository booksRepository =
                new JsonBookRepository(config.getLibraryPath(), environment.getObjectMapper());
        BookService bookService = new BookService(booksRepository);
        final BookResource bookResource =
                new BookResource(bookService, config.getDefaultAuthor());
        environment.jersey().register(bookResource);
    }
}

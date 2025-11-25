import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {
    BookStorage bookStorage;
    Book inputBook;

    @BeforeEach
    void setUp() {
        bookStorage = new BookStorage();
        inputBook = new Book("홍길동전","소설", "허균");
    }

    @Test
    void addBook() {
        bookStorage.addBook(inputBook);

        assertTrue(bookStorage.getBooks().contains(inputBook));
    }
}
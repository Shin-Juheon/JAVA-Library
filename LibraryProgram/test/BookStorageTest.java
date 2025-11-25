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

    // 입력 단위테스트
    // https://github.com/Shin-Juheon/JAVA-Library/issues/6
    @Test
    void addBook() {
        bookStorage.addBook(inputBook);

        assertTrue(bookStorage.getBooks().contains(inputBook));
    }
}
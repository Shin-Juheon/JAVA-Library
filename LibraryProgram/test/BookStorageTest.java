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
        bookStorage.addBook(inputBook);
    }

    // 입력 단위테스트
    // https://github.com/Shin-Juheon/JAVA-Library/issues/6
    @Test
    void addBook() {
        assertTrue(bookStorage.getBooks().contains(inputBook));
    }

    // 검색 단위테스트
    // https://github.com/Shin-Juheon/JAVA-Library/issues/7
    @Test
    void SearchBook() {
        assertDoesNotThrow(() -> bookStorage.searchBook("홍길"));
        assertDoesNotThrow(() -> bookStorage.searchBook("소설"));
        assertDoesNotThrow(() -> bookStorage.searchBook("균"));


    }
}
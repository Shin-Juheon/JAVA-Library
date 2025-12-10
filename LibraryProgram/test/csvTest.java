import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class CsvTest {
    BookStorage bookStorage;
    Book inputBook;
    private static final String TEST_FILE = "library.csv";

    @BeforeEach
    void setUp() {
        deleteTestFile();

        bookStorage = new BookStorage();
        inputBook = new Book("홍길동전","소설", "허균");
        bookStorage.addBook(inputBook);
    }

    @AfterEach
    void tearDown() {
        deleteTestFile();
    }

    // 저장 단위테스트
    // https://github.com/Shin-Juheon/JAVA-Library/issues/21
    @Test
    void saveToCsv() {
        assertDoesNotThrow(() -> bookStorage.saveToCsv());

        File file = new File(TEST_FILE);
        assertTrue(file.exists());

        try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
            String isHeader = br.readLine();
            assertEquals("BookName,Category,Author", isHeader, "다른 헤더값입니다");

            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains("홍길동전")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    // 불러오기 단위테스트
    // https://github.com/Shin-Juheon/JAVA-Library/issues/22
    @Test
    void loadFromCsv() {
        int storageSize = bookStorage.getBooks().size();
        bookStorage.saveToCsv();

        BookStorage newBookStorage = new BookStorage();

        assertEquals(storageSize, newBookStorage.getBooks().size());

        boolean found = false;
        for (Book book : newBookStorage.getBooks()) {
            if (book.getBookName().equals("홍길동전") &&
                    book.getCategory().equals("소설") &&
                    book.getAuthor().equals("허균")) {
                found = true;
                break;
            }

        }
        assertTrue(found);
    }

    private void deleteTestFile() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            boolean deleted = file.delete();
            System.out.println("파일이 삭제되었습니다");
            if (!deleted) {
                System.out.println("테스트 파일 삭제 실패");
            }
        }
    }
}
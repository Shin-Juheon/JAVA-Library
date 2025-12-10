import java.io.*;
import java.util.*;

public class BookStorage {
    private static final String FILE_NAME = "library.csv";
    private static final ArrayList<Book> books = new ArrayList<>();

    public BookStorage() {
        loadFromCsv();
        if (books.isEmpty()) {
            DefaultBooks();
        }
    }

    // JCF를 이용하여 데이터를 관리하는 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/18
    private void DefaultBooks() {
        books.add(new Book("데미안", "소설", "헤르만 헤세"));
        books.add(new Book("변신", "소설", "프란츠 카프카"));
        books.add(new Book("모모", "소설", "미하엘 엔데"));
        books.add(new Book("삼국지", "역사", "나관중"));
        books.add(new Book("파친코", "소설", "이민진"));
        books.add(new Book("칼의노래", "소설", "김훈"));
        books.add(new Book("채식주의자", "소설", "한강"));
        books.add(new Book("언어의온도", "에세이", "이기주"));
        books.add(new Book("종의기원", "과학", "찰스 다윈"));
        books.add(new Book("노인과바다", "소설", "어니스트 헤밍웨이"));
        books.add(new Book("어린왕자", "소설", "생텍쥐페리"));
        books.add(new Book("1984", "소설", "조지 오웰"));
        books.add(new Book("멋진신세계", "소설", "올더스 헉슬리"));
        books.add(new Book("코스모스", "과학", "칼 세이건"));
        books.add(new Book("이기적유전자", "과학", "리처드 도킨스"));
        books.add(new Book("82년생김지영", "소설", "조남주"));
        books.add(new Book("살인자의기억법", "소설", "김영하"));
        books.add(new Book("총균쇠", "역사", "제레드 다이아몬드"));
        books.add(new Book("사피엔스", "역사", "유발 하라리"));
        books.add(new Book("나미야잡화점의기적", "소설", "히가시노 게이고"));
        System.out.println("책 20권을 불러왔습니다.");
        System.out.println();
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    // 입력 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/2
    public void addBook(Book book) {
        books.add(book);
    }

    // 검색 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/3
    public void searchBook(String allType) {
        printType();
        for (Book book : books) {
            if (book.getBookName().contains(allType) ||
                book.getAuthor().contains(allType) ||
                book.getCategory().contains(allType)) {
                book.printResult();
                System.out.println();
            }
        }
    }
    // 출력 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/5
    public void printAllBooks() {
        printType();
        for (Book book : books) {
            book.printResult();
        }
    }

    //대출 기능 개발
    //https://github.com/Shin-Juheon/JAVA-Library/issues/4
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getBookName().equals(title)) {
                if (book.isBorrowed()) {
                    System.out.println("이미 대출중인 책입니다.");
                } else {
                    book.borrow();
                    System.out.println("대출을 완료했습니다.");
                }
                return;
            }
        }
        System.out.println("찾는 책이 없습니다.");

    }

    // 불러오기 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/20
    private void loadFromCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");

                if (data.length < 3) continue;

                books.add(new Book(data[0], data[1], data[2]));
            }
            System.out.println("파일 불러오기를 완료했습니다. (" + books.size() + "권)");
        } catch (FileNotFoundException e) {
            System.out.println("CSV 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("저장 오류: " + e.getMessage());
        }
    }


    private void printType()
    {
        System.out.println("분야\t\t\t책이름\t\t\t저자\t\t\t\t대출상태");
        System.out.println();
    }
    // 저장 기능 개발
    // https://github.com/Shin-Juheon/JAVA-Library/issues/19
    public void saveToCsv() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.write("BookName,Category,Author\n");

            for (Book book : books) {
                pw.write(book.getBookName() + "," + book.getCategory() + "," + book.getAuthor() + "\n");
            }
            System.out.println("저장을 완료했습니다.");
        } catch (IOException e) {
            System.out.println("저장 오류: " + e.getMessage());
        }
    }
}

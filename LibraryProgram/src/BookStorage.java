import java.util.ArrayList;

public class BookStorage {
    private ArrayList<Book> books = new ArrayList<>();


    public BookStorage() {

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
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchBook(String allType) {
        System.out.println("분야\t\t책이름\t\t저자\t\t대출상태");
        for (Book book : books) {
            if (book.getBookName().contains(allType) ||
                book.getAuthor().contains(allType) ||
                book.getCategory().contains(allType)) {
                book.printResult();
            }
        }
    }

}

public class Book {
    // 책 정보 수정 기능은 아직 없어서 final 이용
    private final String bookName;
    private final String category;
    private final String author;
    private boolean isBorrowed;

    public Book(String bookName, String category, String author) {
        this.bookName = bookName;
        this.category = category;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        }
        return false;
    }

    public void printResult() {
        System.out.printf("%-11s%-14s%-14s%s\n", category, bookName, author, (isBorrowed ? "대출중" : "대출가능"));
    }

}

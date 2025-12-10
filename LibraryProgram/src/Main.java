// 도서 관리 프로그램 v1.0
// https://github.com/Shin-Juheon/JAVA-Library/issues/1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("책 이름: ");
                    String name = sc.nextLine();
                    System.out.print("분야: ");
                    String category = sc.nextLine();
                    System.out.print("저자: ");
                    String author = sc.nextLine();
                    storage.addBook(new Book(name, category, author));
                    System.out.println("책을 등록했습니다.");
                    break;
                case 2:
                    System.out.print("검색할(책이름/분야/저자)를 적어주세요: ");
                    String allType = sc.nextLine();
                    storage.searchBook(allType);
                    break;
                case 3:
                    System.out.print("대출할 책 제목을 입력하세요: ");
                    String Title = sc.nextLine();
                    storage.borrowBook(Title);

                    System.out.println(Title);
                    break;
                case 4:
                    storage.printAllBooks();
                    break;
                case 5:
                    storage.saveToCsv();
                    break;
                case 0:
                    storage.saveToCsv();
                    System.out.println("종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("옳은 번호로 다시 입력해주세요.");
            }
        }
    }

    public static void printMenu()
    {
        System.out.println("== 도서 관리 프로그램 ==");
        System.out.println("1. 책 정보 입력");
        System.out.println("2. 책 검색하기");
        System.out.println("3. 책 대출하기");
        System.out.println("4. 전체 출력");
        System.out.println("5. 저장하기");
        System.out.println("0. 종료");
        System.out.print("메뉴 선택: ");
    }
}
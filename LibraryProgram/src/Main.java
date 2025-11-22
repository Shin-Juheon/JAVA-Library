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
                    System.out.print("저자: ");
                    String author = sc.nextLine();
                    System.out.print("분야: ");
                    String category = sc.nextLine();
                    storage.addBook(new Book(name, author, category));
                    System.out.println("책을 등록했습니다.");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("옳은 번호로 다시 입력해주세요.");
            }
        }
    }

    public static void printMenu()
    {
        System.out.println("== 도서 관리 프로그램 ==");
        System.out.println("1. 책 정보 입력\n2. 책 검색하기\n3. 책 대출하기\n4. 전체 출력\n0. 종료");
        System.out.print("메뉴 선택: ");
    }

}
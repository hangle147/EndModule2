import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------Hệ thống quản lý----------");
            System.out.println("1. Quản lí sinh viên");
            System.out.println("2. Quản lí giáo viên");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn: ");

            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    student(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Giá trị không nằm trong pham vi xử lí");
            }
        }
    }

    public static void student(Scanner scanner) {
        while (true) {
            System.out.println("----------Hệ thống quản lý sinh viên----------");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Xoá sinh viên");
            System.out.println("3. Xem danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");

            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Giá trị không nằm trong pham vi xử lí");
            }
        }
    }

    public static void teacher(Scanner scanner) {
        while (true) {
            System.out.println("----------Hệ thống quản lý giáo viên----------");
            System.out.println("1. Thêm mới giáo viên");
            System.out.println("2. Xoá giáo viên");
            System.out.println("3. Xem danh sách giáo viên");
            System.out.println("4. Tìm kiếm giáo viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");

            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Giá trị không nằm trong pham vi xử lí");
            }
        }
    }

    public static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Thông tin không hợp lệ");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
        return choice;
    }
}

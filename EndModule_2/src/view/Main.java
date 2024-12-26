package view;

import entity.DienThoai;
import entity.DienThoaiChinhHang;
import entity.DienThoaiXachTay;
import repository.DienThoaiChinhHangRepository;
import repository.DienThoaiXachTayRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------Chương trình quản lí điện thoại----------");
            System.out.println("Chọn chức năng theo số để tếp tục: ");
            System.out.println("1, Thêm mới");
            System.out.println("2, Xoá");
            System.out.println("3, Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5, Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");

            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:

                    break;
                case 3:
                    displayDanhsach();
                    break;
                case 4:

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại");
            }
        }
    }

    public static int getChoice(Scanner sc) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng, nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
        return choice;
    }


    private static void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn một trong hai loại điện thoại");
        System.out.println("1. Điện thoại chính hãng");
        System.out.println("2. Điện thoại xách tay");
        System.out.println("3. Thoát");
        System.out.print("Mời bạn nhập lựa chọn: ");

        int choice = getChoice(scanner);

        switch (choice) {
            case 1:
                DienThoaiChinhHang dienThoaiChinhHangs = inputDienThoaiChinhHang(scanner);
                DienThoaiChinhHangRepository dienThoaiChinhHangRepository = new DienThoaiChinhHangRepository();
                dienThoaiChinhHangRepository.save(dienThoaiChinhHangs);
                System.out.println("Thêm mới thành công");
                break;
            case 2:
                DienThoaiXachTay dienThoaiXachTay = inputDienThoaiXachTay(scanner);
                DienThoaiXachTayRepository dienThoaiXachTayRepository = new DienThoaiXachTayRepository();
                dienThoaiXachTayRepository.save(dienThoaiXachTay);
                System.out.println("Thêm mới thành công");
                break;
            case 3:
                return;
            default:
                System.out.println("Nhập sai, vui lòng nhập lại");
        }
    }

    private static int currentId = 0;

    public static int idGeneratorChinhHang() {
        currentId++;
        return currentId;
    }

    private static DienThoaiChinhHang inputDienThoaiChinhHang(Scanner scanner) {
        System.out.print("Nhập tên điện thoại: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá bán: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập thời gian bảo hành: ");
        int warrantyPeriod = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập phạm vi bảo hành: ");
        String scopeOfProtectionOnion = scanner.nextLine();

        return new DienThoaiChinhHang(idGeneratorChinhHang(), name, price, quantity, manufacturer, warrantyPeriod, scopeOfProtectionOnion);
    }

    public static int idGeneratorXachTay() {
        currentId++;
        return currentId;
    }

    private static DienThoaiXachTay inputDienThoaiXachTay(Scanner scanner) {
        System.out.print("Nhập tên điện thoại: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá bán: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập quốc gia xách tay: ");
        String importCountry = scanner.nextLine();
        System.out.print("Nhập trạng thái (Còn bảo hành/Hết bảo hành): ");
        String condition = scanner.nextLine();

        return new DienThoaiXachTay(idGeneratorXachTay(), name, price, quantity, manufacturer, importCountry, condition);
    }

    private static void displayDanhsach() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn một trong hai loại điện thoại");
        System.out.println("1. Điện thoại chính hãng");
        System.out.println("2. Điện thoại xách tay");
        System.out.println("3. Thoát");
        System.out.print("Mời bạn nhập lựa chọn: ");

        int choice = getChoice(scanner);

        switch (choice) {
            case 1:
//                displayDanhsachChinhHang();
                break;
            case 2:
                break;
            case 3:
                return;
            default:
                System.out.println("Nhập sai, vui lòng nhập lại");
        }
    }
//
//    private static void displayDanhsachChinhHang() {
//        DienThoaiChinhHangRepository dienThoaiChinhHangRepository = new DienThoaiChinhHangRepository();
//        dienThoaiChinhHangRepository.getAll();
//        printDienThoaiChinhHang();
//    }
//
//    private static void printDienThoaiChinhHang() {
//        System.out.println("ID: " + getId());
//        System.out.println("Tên: " + getName());
//        System.out.println("Giá: " + getPrice());
//        System.out.println("Số lượng: " + getQuantity());
//        System.out.println("Nhà sản xuất: " + getManufacturer());
//        System.out.println("Thời gian bảo hành: " + warrantyPeriod + " tháng");
//        System.out.println("Phạm vi bảo hành: " + scopeOfProtectionOnion);
//        System.out.println("------------------------------");
//    }

}

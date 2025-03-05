package service;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentService {

    public static void addStudent(Scanner scanner) {
        int newStudentId = getNextStudentId();

        System.out.println("Nhập tên sinh viên");
        String nameRegex = "^[a-zA-ZÀ-ỹ\\s]{4,50}$";
        Pattern namePattern = Pattern.compile(nameRegex);

        String name;
        while (true) {
            System.out.print("Nhập tên sinh viên (từ 4 đến 50 ký tự): ");
            name = scanner.nextLine().trim();

            if (namePattern.matcher(name).matches()) {
                System.out.println("✅ Tên hợp lệ: " + name);
                break;
            } else {
                System.out.println("❌ Tên không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập ngày sinh");
        String birthdayRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|20[0-9]{2})$";
        Pattern birthdayPattern = Pattern.compile(birthdayRegex);

        String birthday;
        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            birthday = scanner.nextLine().trim();

            if (birthdayPattern.matcher(birthday).matches()) {
                System.out.println("✅ Ngày sinh hợp lệ: " + birthday);
                break;
            } else {
                System.out.println("❌ Ngày sinh không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập giới tính");
        String genderRegex = "^[a-zA-ZÀ-ỹ\\s]{1,20}$";
        Pattern genderPattern = Pattern.compile(genderRegex);

        String gender;
        while (true) {
            System.out.print("Nhập giới tính (tối đa 20 ký tự, chỉ chữ): ");
            gender = scanner.nextLine().trim();

            if (genderPattern.matcher(gender).matches()) {
                System.out.println("✅ Giới tính hợp lệ: " + gender);
                break;
            } else {
                System.out.println("❌ Giới tính không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập số điện thoại");
        String phoneNumberRegex = "^(090|091)\\d{7}$";
        Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);

        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại (bắt đầu bằng 090 hoặc 091, có 10 số): ");
            phoneNumber = scanner.nextLine().trim();

            if (phoneNumberPattern.matcher(phoneNumber).matches()) {
                System.out.println("✅ Số điện thoại hợp lệ: " + phoneNumber);
                break;
            } else {
                System.out.println("❌ Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập mã lớp học");
        int classId = scanner.nextInt();

        addStudent(newStudentId, name, birthday, gender, phoneNumber, classId);
    }


    public static final String STUDENT_CSV = "D:\\Codegym\\EndModule2\\EndModule_2\\src\\data\\student.csv";

    private static int getNextStudentId() {
        int lastId = 0;
        File file = new File(STUDENT_CSV);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length > 0) {
                        try {
                            lastId = Integer.parseInt(data[0]);
                        } catch (NumberFormatException e) {
                            System.err.println("Lỗi đọc mã sinh viên: " + e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Lỗi đọc file CSV: " + e.getMessage());
            }
        }

        return lastId + 1;
    }

    public static void addStudent(int id, String name, String birthday, String gender, String phoneNumber, int classId) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_CSV, true))) {
            bw.write(id + "," + name + "," + birthday + "," + gender + "," + phoneNumber + "," + classId);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Lỗi ghi file CSV: " + e.getMessage());
        }
    }
}

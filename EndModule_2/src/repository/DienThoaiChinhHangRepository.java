package repository;

import entity.DienThoaiChinhHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiChinhHangRepository implements IService<DienThoaiChinhHang>{
    public static final String DienThoaiChinhHang_CSV = "data/dienThoaiChinhHang.csv";

    @Override
    public void save(DienThoaiChinhHang dienThoaiChinhHang) {
        File file = new File(DienThoaiChinhHang_CSV);
        List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
        dienThoaiChinhHangs.add(dienThoaiChinhHang);
        writeFile(dienThoaiChinhHangs, true);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<DienThoaiChinhHang> getAll() {
        File file = new File(DienThoaiChinhHang_CSV);
        List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            String[] temp;
            DienThoaiChinhHang dienThoaiChinhHang;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                dienThoaiChinhHang = new DienThoaiChinhHang(Integer.parseInt(temp[0]), temp[1], Long.parseLong(temp[2]), Integer.parseInt(temp[3]), temp[4], Integer.parseInt(temp[5]), temp[6]);
                dienThoaiChinhHangs.add(dienThoaiChinhHang);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return dienThoaiChinhHangs;
    }

    @Override
    public List<DienThoaiChinhHang> findAllByName(String name) {
        return List.of();
    }

    @Override
    public DienThoaiChinhHang findById(int id) {
        return null;
    }

    public void writeFile(List<DienThoaiChinhHang> dienThoaiChinhHangs, boolean append) {
        File file = new File(DienThoaiChinhHang_CSV);
        try (
                FileWriter fileWriter = new FileWriter(file, append);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for (DienThoaiChinhHang dienThoaiChinhHang : dienThoaiChinhHangs) {
                bufferedWriter.write(menuToString(dienThoaiChinhHang));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String menuToString(DienThoaiChinhHang dienThoaiChinhHang) {
        return dienThoaiChinhHang.getId() + ","
                + dienThoaiChinhHang.getName() + ","
                + dienThoaiChinhHang.getPrice() + ","
                + dienThoaiChinhHang.getQuantity() + ","
                + dienThoaiChinhHang.getManufacturer() + ","
                + dienThoaiChinhHang.getWarrantyPeriod() + ","
                + dienThoaiChinhHang.getScopeOfProtectionOnion();
    }
}

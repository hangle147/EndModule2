package repository;

import entity.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiXachTayRepository implements IService<DienThoaiXachTay>{
    public static final String DienThoaiXachTay_CSV = "data/dienThoaiXachTay.csv";

    @Override
    public void save(DienThoaiXachTay dienThoaiXachTay) {
        File file = new File(DienThoaiXachTay_CSV);
        List<DienThoaiXachTay> dienThoaiXachTays = new ArrayList<>();
        dienThoaiXachTays.add(dienThoaiXachTay);
        writeFile(dienThoaiXachTays, true);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<DienThoaiXachTay> getAll() {
        File file = new File(DienThoaiXachTay_CSV);
        List<DienThoaiXachTay> dienThoaiXachTays = new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            String[] temp;
            DienThoaiXachTay dienThoaiXachTay;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                dienThoaiXachTay = new DienThoaiXachTay(Integer.parseInt(temp[0]), temp[1], Long.parseLong(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], temp[6]);
                dienThoaiXachTays.add(dienThoaiXachTay);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return dienThoaiXachTays;
    }

    @Override
    public List<DienThoaiXachTay> findAllByName(String name) {
        return List.of();
    }

    @Override
    public DienThoaiXachTay findById(int id) {
        return null;
    }

    public void writeFile(List<DienThoaiXachTay> dienThoaiXachTays, boolean append) {
        File file = new File(DienThoaiXachTay_CSV);
        try (
                FileWriter fileWriter = new FileWriter(file, append);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for (DienThoaiXachTay dienThoaiXachTay : dienThoaiXachTays) {
                bufferedWriter.write(menuToString(dienThoaiXachTay));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String menuToString(DienThoaiXachTay dienThoaiXachTay) {
        return dienThoaiXachTay.getId() + ","
                + dienThoaiXachTay.getName() + ","
                + dienThoaiXachTay.getPrice() + ","
                + dienThoaiXachTay.getQuantity() + ","
                + dienThoaiXachTay.getManufacturer() + ","
                + dienThoaiXachTay.getPortableCountry() + ","
                + dienThoaiXachTay.getCondition();
    }
}

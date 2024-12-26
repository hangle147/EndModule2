package entity;

public class DienThoaiXachTay extends DienThoai{
    private String portableCountry;
    private String condition;

    public DienThoaiXachTay(int id, String name, long price, int quantity, String manufacturer, String portableCountry, String condition) {
        super(id, name, price, quantity, manufacturer);
        this.portableCountry = portableCountry;
        this.condition = condition;
    }

    public DienThoaiXachTay(String portableCountry, String condition) {
        this.portableCountry = portableCountry;
        this.condition = condition;
    }

    public DienThoaiXachTay() {}

    public String getPortableCountry() {
        return portableCountry;
    }

    public void setPortableCountry(String portableCountry) {
        this.portableCountry = portableCountry;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

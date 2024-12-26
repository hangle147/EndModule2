package entity;

public class DienThoaiChinhHang extends DienThoai{
    private int warrantyPeriod;
    private String scopeOfProtectionOnion;

    public DienThoaiChinhHang(int id, String name, long price, int quantity, String manufacturer, int warrantyPeriod, String scopeOfProtectionOnion) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.scopeOfProtectionOnion = scopeOfProtectionOnion;
    }

    public DienThoaiChinhHang(int warrantyPeriod, String scopeOfProtectionOnion) {
        this.warrantyPeriod = warrantyPeriod;
        this.scopeOfProtectionOnion = scopeOfProtectionOnion;
    }

    public DienThoaiChinhHang() {}

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getScopeOfProtectionOnion() {
        return scopeOfProtectionOnion;
    }

    public void setScopeOfProtectionOnion(String scopeOfProtectionOnion) {
        this.scopeOfProtectionOnion = scopeOfProtectionOnion;
    }
}

package Po;

public class ShopsType {
    private int BU_Id;//店面种类id
    private String BU_Name;//店面种类名
    private int BU_shopTypeId;//店面种类父id

    public ShopsType() {

    }

    public ShopsType(int BU_Id, String BU_Name, int BU_shopTypeId) {
        this.BU_Id = BU_Id;
        this.BU_Name = BU_Name;
        this.BU_shopTypeId = BU_shopTypeId;
    }

    public int getBU_Id() {
        return BU_Id;
    }

    public void setBU_Id(int BU_Id) {
        this.BU_Id = BU_Id;
    }

    public String getBU_Name() {
        return BU_Name;
    }

    public void setBU_Name(String BU_Name) {
        this.BU_Name = BU_Name;
    }

    public int getBU_shopTypeId() {
        return BU_shopTypeId;
    }

    public void setBU_shopTypeId(int BU_shopTypeId) {
        this.BU_shopTypeId = BU_shopTypeId;
    }

    @Override
    public String toString() {
        return "ShopType{" +
                "BU_Id=" + BU_Id +
                ", BU_Name='" + BU_Name + '\'' +
                ", BU_shopTypeId=" + BU_shopTypeId +
                '}';
    }
}

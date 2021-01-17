package Po;

public class Foods {
    private int fId;//菜品id
    private String foodName;//菜品名
    private String fPrice;//菜品价格
    private String fPicture;//菜品图片
    private int fTid;//菜品种类id
    private String foodPrint;//菜品介绍

    public Foods() {

    }

    @Override
    public String toString() {
        return "Foods{" +
                "fId=" + fId +
                ", foodName='" + foodName + '\'' +
                ", fPrice='" + fPrice + '\'' +
                ", fPicture='" + fPicture + '\'' +
                ", fTid=" + fTid +
                ", foodPrint='" + foodPrint + '\'' +
                '}';
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }

    public String getfPicture() {
        return fPicture;
    }

    public void setfPicture(String fPicture) {
        this.fPicture = fPicture;
    }

    public int getfTid() {
        return fTid;
    }

    public void setfTid(int fTid) {
        this.fTid = fTid;
    }

    public String getFoodPrint() {
        return foodPrint;
    }

    public void setFoodPrint(String foodPrint) {
        this.foodPrint = foodPrint;
    }

    public Foods(int fId, String foodName, String fPrice, String fPicture, int fTid, String foodPrint) {
        this.fId = fId;
        this.foodName = foodName;
        this.fPrice = fPrice;
        this.fPicture = fPicture;
        this.fTid = fTid;
        this.foodPrint = foodPrint;
    }
}

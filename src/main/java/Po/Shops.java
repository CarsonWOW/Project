package Po;

public class Shops {
    private int shopId;//店面id
    private String shopName;//店面名字
    private int shopTypeId;//店面种类id
    private String shopCuisine;//特色菜品
    private String shopBusiness;//营业时间
    private String shopPark;//停车泊位
    private String shopSite;//餐厅地址
    private String shopLabel;//餐厅标签
    private String shopPicture;//店面图片

    public Shops() {

    }

    public Shops(int shopId, String shopName, int shopTypeId, String shopCuisine, String shopBusiness, String shopPark, String shopSite, String shopLabel, String shopPicture) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopTypeId = shopTypeId;
        this.shopCuisine = shopCuisine;
        this.shopBusiness = shopBusiness;
        this.shopPark = shopPark;
        this.shopSite = shopSite;
        this.shopLabel = shopLabel;
        this.shopPicture = shopPicture;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(int shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getShopCuisine() {
        return shopCuisine;
    }

    public void setShopCuisine(String shopCuisine) {
        this.shopCuisine = shopCuisine;
    }

    public String getShopBusiness() {
        return shopBusiness;
    }

    public void setShopBusiness(String shopBusiness) {
        this.shopBusiness = shopBusiness;
    }

    public String getShopPark() {
        return shopPark;
    }

    public void setShopPark(String shopPark) {
        this.shopPark = shopPark;
    }

    public String getShopSite() {
        return shopSite;
    }

    public void setShopSite(String shopSite) {
        this.shopSite = shopSite;
    }

    public String getShopLabel() {
        return shopLabel;
    }

    public void setShopLabel(String shopLabel) {
        this.shopLabel = shopLabel;
    }

    public String getShopPicture() {
        return shopPicture;
    }

    public void setShopPicture(String shopPicture) {
        this.shopPicture = shopPicture;
    }

    @Override
    public String toString() {
        return "Shops{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopTypeId=" + shopTypeId +
                ", shopCuisine='" + shopCuisine + '\'' +
                ", shopBusiness='" + shopBusiness + '\'' +
                ", shopPark='" + shopPark + '\'' +
                ", shopSite='" + shopSite + '\'' +
                ", shopLabel='" + shopLabel + '\'' +
                ", shopPicture='" + shopPicture + '\'' +
                '}';
    }
}

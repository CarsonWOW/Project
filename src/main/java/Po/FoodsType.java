package Po;

public class FoodsType {
    private int foodsTypeId;//种类id
    private String foodsTypeName;//菜品种类名
    private int childId;//菜品种类父id

    public FoodsType() {

    }

    @Override
    public String toString() {
        return "FoodsType{" +
                "foodsTypeId=" + foodsTypeId +
                ", foodsTypeName='" + foodsTypeName + '\'' +
                ", childId=" + childId +
                '}';
    }

    public FoodsType(int foodsTypeId, String foodsTypeName, int childId) {
        this.foodsTypeId = foodsTypeId;
        this.foodsTypeName = foodsTypeName;
        this.childId = childId;
    }

    public int getFoodsTypeId() {
        return foodsTypeId;
    }

    public void setFoodsTypeId(int foodsTypeId) {
        this.foodsTypeId = foodsTypeId;
    }

    public String getFoodsTypeName() {
        return foodsTypeName;
    }

    public void setFoodsTypeName(String foodsTypeName) {
        this.foodsTypeName = foodsTypeName;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}

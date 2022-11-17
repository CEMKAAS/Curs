public class CategoryTSV {
    private String name;
    private String categotyTSV;
    private String data;

    @Override
    public String toString() {
        return "CategoryTSV{" +
                "name='" + name + '\'' +
                ", categotyTSV='" + categotyTSV + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategotyTSV() {
        return categotyTSV;
    }

    public void setCategotyTSV(String categotyTSV) {
        this.categotyTSV = categotyTSV;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CategoryTSV(String name, String categotyTSV, String data) {
        this.name = name;
        this.categotyTSV = categotyTSV;
        this.data = data;
    }
}

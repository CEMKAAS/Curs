public class MaxJson {
    private String maxCategory;
    private String category;
    private Integer sum;

    public MaxJson(String maxCategory, String category, Integer sum) {
        this.maxCategory = maxCategory;
        this.category = category;
        this.sum = sum;
    }

    public String getMaxCategory() {
        return maxCategory;
    }

    public void setMaxCategory(String maxCategory) {
        this.maxCategory = maxCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "MaxJson{" +
                "maxCategory='" + maxCategory + '\'' +
                ", category='" + category + '\'' +
                ", sum=" + sum +
                '}';
    }
}

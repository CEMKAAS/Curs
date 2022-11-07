public class TsvCategories {
    private String title;
    private String titleCategory;

    public TsvCategories(String title, String titleCategory) {
        this.title = title;
        this.titleCategory = titleCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        this.titleCategory = titleCategory;
    }

    @Override
    public String toString() {
        return "TsvCategories{" +
                "title='" + title + '\'' +
                ", titleCategory='" + titleCategory + '\'' +
                '}';
    }
}

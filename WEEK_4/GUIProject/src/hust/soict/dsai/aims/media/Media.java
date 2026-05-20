package hust.soict.dsai.aims.media;

public abstract class Media {
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return title + " - " + category + ": " + cost + "$";
    }
}

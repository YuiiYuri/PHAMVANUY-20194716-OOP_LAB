package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;
    private static int nbDVDs = 0;
    private int id;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
        this.id = ++nbDVDs;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public int getId() {
        return id;
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String play() {
        return "Playing DVD: " + getTitle() + "\nLength: " + length + " minutes";
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() +
               " - " + director + " - " + length + " min: " + getCost() + "$";
    }
}
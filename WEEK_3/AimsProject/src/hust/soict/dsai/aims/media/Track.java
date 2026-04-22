package hust.soict.dsai.aims.media;

public class Track {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title.equalsIgnoreCase(other.title);
        }
        return false;
    }

    public void play() {
        System.out.println("Playing Track: " + title);
        System.out.println("Track length: " + length);
    }
}

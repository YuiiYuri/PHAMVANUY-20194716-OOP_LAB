package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String play() {
        if (tracks.isEmpty()) {
            return "CD \"" + getTitle() + "\" has no tracks!";
        }

        StringBuilder result = new StringBuilder("Playing CD: " + getTitle() + "\n");
        for (Track track : tracks) {
            result.append("- ").append(track.toString()).append("\n");
        }
        result.append("Total length: ").append(getLength()).append(" minutes");
        return result.toString();
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + ": " + getCost() + "$";
    }
}

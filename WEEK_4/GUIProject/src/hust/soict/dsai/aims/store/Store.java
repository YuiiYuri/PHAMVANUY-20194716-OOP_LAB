package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }
}

package hust.soict.dsai.aims;

import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        // Có thể thêm sẵn vài media mẫu nếu muốn
        new StoreManagerScreen(store);
    }
}

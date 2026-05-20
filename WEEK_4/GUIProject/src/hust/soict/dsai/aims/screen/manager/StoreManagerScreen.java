package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View Store");
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        // Sự kiện nút
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        viewStore.addActionListener(e -> {
            dispose(); // đóng màn hình hiện tại
            new StoreManagerScreen(store); // tạo lại màn hình chính
        });

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        title.setForeground(Color.BLUE);

        header.add(Box.createRigidArea(new Dimension(0, 10)));
        header.add(title);
        header.add(Box.createRigidArea(new Dimension(0, 10)));

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10));

        List<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }
}

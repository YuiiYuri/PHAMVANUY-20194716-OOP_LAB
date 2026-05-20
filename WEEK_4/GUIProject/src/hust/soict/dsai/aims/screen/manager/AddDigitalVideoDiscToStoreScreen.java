package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add DVD to Store");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();

        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add DVD");

        add(titleLabel); add(titleField);
        add(categoryLabel); add(categoryField);
        add(directorLabel); add(directorField);
        add(lengthLabel); add(lengthField);
        add(costLabel); add(costField);
        add(new JLabel()); add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = titleField.getText().trim();
                    String category = categoryField.getText().trim();
                    String director = directorField.getText().trim();
                    int length = Integer.parseInt(lengthField.getText().trim());
                    float cost = Float.parseFloat(costField.getText().trim());

                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(dvd);
                    JOptionPane.showMessageDialog(null, "DVD added successfully!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please check all fields.");
                }
            }
        });

        setVisible(true);
    }
}

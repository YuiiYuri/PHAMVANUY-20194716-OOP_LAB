package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {

    private Store store;
    private List<String> authors = new ArrayList<>();

    public AddBookToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Book to Store");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel thông tin sách
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        inputPanel.add(titleLabel); inputPanel.add(titleField);
        inputPanel.add(categoryLabel); inputPanel.add(categoryField);
        inputPanel.add(costLabel); inputPanel.add(costField);

        // Panel tác giả
        JPanel authorPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();
        JButton addAuthorButton = new JButton("Add Author");

        authorPanel.add(authorLabel); authorPanel.add(authorField);
        authorPanel.add(new JLabel()); authorPanel.add(addAuthorButton);

        // Danh sách tác giả hiển thị
        JTextArea authorArea = new JTextArea(5, 30);
        authorArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(authorArea);

        // Nút thêm sách
        JButton addBookButton = new JButton("Add Book to Store");

        // Gộp các panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(authorPanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
        add(addBookButton, BorderLayout.SOUTH);

        // Xử lý thêm tác giả
        addAuthorButton.addActionListener(e -> {
            String author = authorField.getText().trim();
            if (!author.isEmpty() && !authors.contains(author)) {
                authors.add(author);
                authorArea.append("- " + author + "\n");
                authorField.setText("");
            }
        });

        // Xử lý thêm sách vào store
        addBookButton.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String category = categoryField.getText().trim();
                float cost = Float.parseFloat(costField.getText().trim());

                Book book = new Book(title, category, cost);
                for (String author : authors) {
                    book.addAuthor(author);
                }

                store.addMedia(book);
                JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Cost must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}

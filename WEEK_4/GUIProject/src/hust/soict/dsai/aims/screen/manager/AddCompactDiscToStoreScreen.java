package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {

    private Store store;
    private List<Track> trackList = new ArrayList<>();

    public AddCompactDiscToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add CD to Store");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel nhập thông tin chính
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        inputPanel.add(titleLabel); inputPanel.add(titleField);
        inputPanel.add(categoryLabel); inputPanel.add(categoryField);
        inputPanel.add(artistLabel); inputPanel.add(artistField);
        inputPanel.add(costLabel); inputPanel.add(costField);

        // Panel thêm track
        JPanel trackPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel trackTitleLabel = new JLabel("Track Title:");
        JTextField trackTitleField = new JTextField();

        JLabel trackLengthLabel = new JLabel("Track Length:");
        JTextField trackLengthField = new JTextField();

        JButton addTrackButton = new JButton("Add Track");

        trackPanel.add(trackTitleLabel); trackPanel.add(trackTitleField);
        trackPanel.add(trackLengthLabel); trackPanel.add(trackLengthField);
        trackPanel.add(new JLabel()); trackPanel.add(addTrackButton);

        // Danh sách track tạm thời
        JTextArea trackArea = new JTextArea(5, 30);
        trackArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(trackArea);

        // Button thêm CD
        JButton addCDButton = new JButton("Add CD to Store");

        // Gộp panel chính
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(trackPanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
        add(addCDButton, BorderLayout.SOUTH);

        // Sự kiện: Thêm track vào list
        addTrackButton.addActionListener(e -> {
            String tTitle = trackTitleField.getText().trim();
            String tLengthStr = trackLengthField.getText().trim();

            try {
                int length = Integer.parseInt(tLengthStr);
                Track track = new Track(tTitle, length);
                trackList.add(track);
                trackArea.append("- " + tTitle + " (" + length + " min)\n");
                trackTitleField.setText("");
                trackLengthField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Track length must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sự kiện: Thêm CD vào store
        addCDButton.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String category = categoryField.getText().trim();
                String artist = artistField.getText().trim();
                float cost = Float.parseFloat(costField.getText().trim());

                CompactDisc cd = new CompactDisc(title, category, artist, cost);
                for (Track track : trackList) {
                    cd.addTrack(track);
                }

                store.addMedia(cd);

                JOptionPane.showMessageDialog(this, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Cost must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}

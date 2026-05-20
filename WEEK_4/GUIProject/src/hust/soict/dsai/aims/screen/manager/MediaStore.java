package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Cost
        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalStrut(10));

        // Nút Play nếu có thể
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String result = ((Playable) media).play();
                    JOptionPane.showMessageDialog(null, result, "Play Media", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            add(playButton);
        }

        // Nút Add to Cart (tùy chọn)
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.setAlignmentX(CENTER_ALIGNMENT);
        addToCartButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "This feature is not implemented yet.");
        });
        add(addToCartButton);

        add(Box.createVerticalGlue());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}

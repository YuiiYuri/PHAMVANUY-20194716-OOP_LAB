package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame implements ActionListener {

    private JTextField tfDisplay;        // Vùng hiển thị số
    private JButton[] btnNumbers;        // Mảng chứa nút 0-9
    private JButton btnDel, btnClear;    // Nút DEL, C

    public NumberGrid() {
        tfDisplay = new JTextField(20);
        tfDisplay.setEditable(false);    // Không cho gõ bàn phím

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        btnNumbers = new JButton[10];

        // Tạo nút 1–9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(this);
        }

        // Thêm nút DEL, 0, C
        btnDel = new JButton("DEL");
        btnClear = new JButton("C");
        btnNumbers[0] = new JButton("0");

        panelButtons.add(btnDel);
        panelButtons.add(btnNumbers[0]);
        panelButtons.add(btnClear);

        btnDel.addActionListener(this);
        btnClear.addActionListener(this);
        btnNumbers[0].addActionListener(this);

        // Layout chính
        setLayout(new BorderLayout(5, 5));
        add(tfDisplay, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Xử lý sự kiện nút
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String current = tfDisplay.getText();

        if (cmd.equals("DEL")) {
            if (current.length() > 0) {
                tfDisplay.setText(current.substring(0, current.length() - 1));
            }
        } else if (cmd.equals("C")) {
            tfDisplay.setText("");
        } else {
            tfDisplay.setText(current + cmd); // Nối thêm số
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}

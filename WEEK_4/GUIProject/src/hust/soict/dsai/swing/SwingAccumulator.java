package hust.soict.dsai.swing;

import javax.swing.*;               // JFrame, JLabel, JTextField
import java.awt.*;                  // Layout
import java.awt.event.*;           // ActionListener

public class SwingAccumulator extends JFrame {

    private JTextField tfInput;     // ô nhập liệu
    private JTextField tfOutput;    // ô hiện tổng
    private int sum = 0;

    public SwingAccumulator() {
        // Giao diện dùng FlowLayout
        setLayout(new FlowLayout());

        add(new JLabel("Enter an Integer: ")); // Label hướng dẫn

        tfInput = new JTextField(10);          // TextField nhập số
        add(tfInput);

        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(tfInput.getText());
                sum += number;
                tfOutput.setText(sum + "");
                tfInput.setText("");           // Clear input
            }
        });

        add(new JLabel("Accumulated sum is: "));  // Label tổng

        tfOutput = new JTextField(10);        // TextField hiển thị tổng
        tfOutput.setEditable(false);          // Không cho người dùng nhập vào
        add(tfOutput);

        setTitle("Swing Accumulator");        // Tiêu đề cửa sổ
        setSize(300, 120);                    // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);                     // Hiển thị giao diện
    }

    public static void main(String[] args) {
        // Tạo cửa sổ mới
        new SwingAccumulator();
    }
}

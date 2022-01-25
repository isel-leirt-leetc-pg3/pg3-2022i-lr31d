// no teste, não seria necessário colocar package e imports
package leirt.pg3.i1920_t2.registers_swing;
import leirt.pg3.i1920_t2.Date;
import leirt.pg3.i1920_t2.Group2;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RegistersFrame extends JFrame {
    private JTextField filename_box = newJTextField("filename");
    private JTextField data_box = newJTextField("data");
    private JButton reg_but = new JButton("registers");
    private JTextArea reg_list_area = newJTextArea("list of registers");

    private void initComponents() {
        Container pane = getContentPane();
        JPanel inputPanel = new JPanel();
        inputPanel.add(filename_box);
        inputPanel.add(data_box);
        inputPanel.add(reg_but);
        pane.add(inputPanel, BorderLayout.NORTH);
        pane.add(reg_list_area, BorderLayout.CENTER);
    }

    private void initListeners() {
        reg_but.addActionListener(evt -> {
            reg_list_area.setText("");
            try {
                String date = data_box.getText();
                Group2.acceptIf(filename_box.getText(),
                         new Date(date),
                         (s, d) -> reg_list_area.append(s + "\n"));
            }
            catch(Exception e) {
                showMessage(this, e.getMessage());
            }
        });
    }

    // métodos auxiliares, não era necessário transcrever no teste
    public static JTextField newJTextField( String title ) {
        JTextField tf = new JTextField( 10 ); tf.setBorder( new TitledBorder( title ) );
        return tf;
    }
    public static JTextArea newJTextArea( String title ) {
        JTextArea ta = new JTextArea( 10, 20 ); ta.setBorder(new TitledBorder( title ));
        return ta;
    }

    public static void showMessage(Component parent, String msg ) {
        JOptionPane.showMessageDialog( parent, msg );
    }

    public RegistersFrame() {
        initComponents();
        initListeners();
        setTitle("REGISTERS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
}

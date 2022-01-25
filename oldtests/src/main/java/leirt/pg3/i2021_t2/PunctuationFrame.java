package leirt.pg3.i2021_t2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class PunctuationFrame extends JFrame {
    JTextField newJTextField( String title) {
        JTextField tf = new JTextField( 12 );
        tf.setBorder( new TitledBorder( title ) );
        return tf;
    }
    JTextArea newJTextArea( String title ) {
        JTextArea ta = new JTextArea( 10, 16 );
        ta.setBorder( new TitledBorder( title ) );
        return ta;
    }

    JTextField filenameField = newJTextField("Nome do ficheiro");
    JTextField namePlayerField = newJTextField("Nome do jogador");
    JTextArea listArea = newJTextArea("List");
    public PunctuationFrame() {
        super("Pontuações");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        JPanel north = new JPanel( new GridLayout(1,2));
        north.add( filenameField);
        north.add( namePlayerField);
        cp.add(north, BorderLayout.NORTH);
        cp.add(listArea, BorderLayout.CENTER);
        JButton b = new JButton( "pontuaçoes");
        b.addActionListener( this::punctuations);
        cp.add(b, BorderLayout.SOUTH);
        pack();
    }

    private void punctuations(ActionEvent actionEvent) {
        try( BufferedReader br= new BufferedReader( new FileReader(filenameField.getText())) ) {
            listArea.setText("");
            Group3.punctuationsOf(br, namePlayerField.getText(), p-> listArea.append(p+'\n'));
        }  catch (IOException e) {
           listArea.setText("Erro no acesso ao ficheiro");
        }
    }

    public static void main(String[] args) {
        new PunctuationFrame().setVisible( true );
    }
}

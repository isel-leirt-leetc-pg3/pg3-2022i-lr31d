package leirt.pg3.swing.converter;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverterFrame extends JFrame {
    private static final int TEXT_FIELD_SIZE = 16;

    private static final double POUNDS_TO_EUROS = 1.20;
    private static final double EUROS_TO_POUNDS = 1/POUNDS_TO_EUROS;

    private JLabel eurosMsg;
    private JTextField eurosVal;
    private JButton eurosToPoundsBut;

    private JLabel poundsMsg;
    private JTextField poundsVal;
    private JButton poundsToEurosBut;

    private void initComponents() {
        eurosMsg = new JLabel("Euros");
        eurosVal = new JTextField(TEXT_FIELD_SIZE);
        eurosVal.setHorizontalAlignment(SwingConstants.RIGHT);

        eurosToPoundsBut = new JButton("\u20ac -> \u00a3");

        poundsMsg = new JLabel("Pounds");
        poundsVal = new JTextField(TEXT_FIELD_SIZE);
        poundsToEurosBut = new JButton("\u00a3 -> \u20ac");
        poundsVal.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel eurosPanel = new JPanel();
        eurosPanel.setLayout(new FlowLayout());
        eurosPanel.add(eurosMsg);
        eurosPanel.add(eurosVal);

        eurosPanel.add(eurosToPoundsBut);

        JPanel poundsPanel = new JPanel();

        poundsPanel.add(poundsMsg);
        poundsPanel.add(poundsVal);
        poundsPanel.add(poundsToEurosBut);

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1));
        container.add(eurosPanel);
        container.add(poundsPanel);

        pack();
    }

    private void currencyConversion(JTextField src, JTextField dst, double tax) {
        try {
            String text = src.getText();
            double srcValue = Double.parseDouble(text);
            double dstValue = srcValue * tax;
            dst.setText(String.format("%.2f", dstValue));
        }
        catch(Exception e) {
            src.setText("");
            dst.setText("");
        }
    }

    private void initListeners() {
        eurosToPoundsBut.addActionListener(evt -> currencyConversion(eurosVal, poundsVal, EUROS_TO_POUNDS));

        poundsToEurosBut.addActionListener(evt -> currencyConversion(poundsVal, eurosVal, POUNDS_TO_EUROS));
    }

    public CurrencyConverterFrame() {
        initComponents();
        initListeners();
        //setSize(200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

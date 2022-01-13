package leirt.pg3.swing.cards.view;

import leirt.pg3.swing.cards.model.Board;

import javax.swing.*;
import java.awt.*;

public class CardGameFrame extends JFrame {
    private BoardViewer boardViewer;
    private Board model;
    private Container container;
    private JLabel label;
    private boolean suspended;

    private void createBoard(int lines, int cols) {
        if (boardViewer != null) container.remove(boardViewer);
        model = new Board(lines,cols, CardView.NVALUES);
        boardViewer = new BoardViewer(model);
        container.add(boardViewer);
        setSize(CardView.CARD_WIDTH*cols + 50*cols,
            CardView.CARD_HEIGHT*lines + 40*lines);
        container.setComponentZOrder(boardViewer, 0);
        container.setComponentZOrder(label, 1);

        boardViewer.setCardSelectedListener(cv -> {
            if (suspended) return;

            if (model.play(cv.getCard())) {
                Timer timer = new Timer(2000, e -> {

                    model.hidePair();
                    suspended = false;
                });
                timer.setRepeats(false);
                timer.start();
                suspended = true;
            } else if (model.isEmpty()) {

                boardViewer.setVisible(false);

                JOptionPane.showMessageDialog(
                        null, String.format("You win in %d moves", model.getMoves()));


            }

        });
    }
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Sizes");

        JMenuItem small = new JMenuItem("2 x 4");
        JMenuItem medium = new JMenuItem("4 x 4");
        JMenuItem large = new JMenuItem("5 x 6");
        small.addActionListener(e -> createBoard(2, 4));
        medium.addActionListener(e -> createBoard(4, 4));
        large.addActionListener(e -> createBoard(5, 6));

        menu.add(small);
        menu.add(medium);
        menu.add(large);
        menuBar.add(menu);


        setJMenuBar(menuBar);

    }

    private void initComponents() {
        container = getContentPane();
        label = new JLabel("Please select a board");
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label);
    }

    public  CardGameFrame(){
        buildMenu();
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
    }
}

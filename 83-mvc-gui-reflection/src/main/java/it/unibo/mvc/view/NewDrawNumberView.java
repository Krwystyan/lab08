package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static javax.swing.JOptionPane.showMessageDialog;


public class NewDrawNumberView implements DrawNumberView{
    private static final String FRAME_NAME = "Second Draw Number App";
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberController controller;
    private final JFrame frame = new JFrame(FRAME_NAME);

    /**
     * Builds a new Swing-based interactive view.
     */
    public NewDrawNumberView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JPanel(new BorderLayout()));
        final JPanel pNorth = new JPanel(new FlowLayout());
        final JTextField tNumber = new JTextField(10);
        pNorth.add(tNumber);

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }


    @Override
    public void setController(final DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                plainMessage(res.getDescription());
                return;
            }
            case YOU_WON -> plainMessage(res.getDescription() + NEW_GAME);
            case YOU_LOST -> showMessageDialog(
                frame,
                res.getDescription() + NEW_GAME, "Lost",
                JOptionPane.WARNING_MESSAGE
            );
            default -> throw new IllegalStateException("Unknown game state");
        }
        controller.resetGame();
    }

    private void plainMessage(final String msg) {
        showMessageDialog(frame, msg, "Result", JOptionPane.PLAIN_MESSAGE);
    }
}

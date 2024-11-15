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
    

    @Override
    public void start() {
        //Is for output only
    }


    @Override
    public void setController(final DrawNumberController observer) {
        //
    }

    @Override
    public void result(final DrawResult res) {
        java.lang.System.out.println(res.getDescription());
    }
}

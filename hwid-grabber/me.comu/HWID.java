package me.comu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import me.comu.utils.*;
import java.security.*;
import java.io.*;

public class HWID extends JFrame implements ActionListener
{
    private JButton jbutton;
    private JTextField jtext;
    private JLabel jlabel;
    
    public HWID() {
        super("HWID Grabber");
        this.setLayout(new FlowLayout());
        (this.jbutton = new JButton("Grab HWID")).setToolTipText("Press to grab your HWID");
        this.jbutton.addActionListener(this);
        (this.jtext = new JTextField(80)).setEditable(false);
        this.jtext.setSize(300, 250);
        (this.jlabel = new JLabel("HWID Grabber v1.0 | Made by comu")).setToolTipText("gun#9799");
        this.add(this.jbutton);
        this.add(this.jtext);
        this.add(this.jlabel);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.jbutton) {
            try {
                this.jtext.setText(HWIDUtils.getHWID());
            }
            catch (NoSuchAlgorithmException | UnsupportedEncodingException ex2) {
                final Exception ex;
                final Exception e2 = ex;
                e2.printStackTrace();
            }
        }
    }
}

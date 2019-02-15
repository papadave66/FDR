package org.rivoreo.fdr.client;

import javax.swing.*;

/**
 * Created by papadave on 2018/10/5.
 */
public class StatusWindow {
    private JPanel panel1;
    private JLabel JLabelUsernameText;
    private JLabel JLableUsername;
    private JLabel JLabelNetworkplanText;
    private JLabel JLabelNetworkplan;
    private JLabel JLabelTimerText;
    private JLabel JLabelTimer;
    private JButton BtnDisconnect;
    private JButton BtnWebsite;

    public StatusWindow(String username,String password,String Interface,String plan){
        PPPoE pppoe = new PPPoE(new PaulsPPPPackage());
        pppoe.dial(username,password,Interface);
    }
    StatusWindow(){

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("status");
        frame.setContentPane(new StatusWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}

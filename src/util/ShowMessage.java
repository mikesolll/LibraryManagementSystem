package util;

import javax.swing.*;

public class ShowMessage {

    private ShowMessage(){}

    public static void error(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public static void success(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}

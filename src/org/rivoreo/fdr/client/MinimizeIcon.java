package org.rivoreo.fdr.client;

import java.awt.*;
/**
 * Created by papadave on 2018/10/4.
 */
public class MinimizeIcon {
    //private TrayIcon trayIcon;//
    //private SystemTray systemTray;

    public void minimizeToTray() throws AWTException {
        if (SystemTray.isSupported()){
            // get the SystemTray instance
            SystemTray tray = SystemTray.getSystemTray();
            // load an image
            Image image = Toolkit.getDefaultToolkit().getImage("image/network-server.png");
            TrayIcon trayIcon = new TrayIcon(image,"FDR client");
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
}

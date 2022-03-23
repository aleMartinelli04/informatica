package gui.magazzino.panels;

import javax.swing.*;

public abstract class CustomPanel extends JFrame {
    public abstract JPanel getPanel();

    @Override
    public void setVisible(boolean visible) {
        getPanel().setVisible(visible);
    }
}

package gui.magazzino.panels;

import gui.magazzino.Gui;

import javax.swing.*;

public class MainPanel extends CustomPanel {
    private JPanel mainPanel;
    private JButton inserisciProdotto;
    private JButton visualizzaProdotti;
    private JButton altro;

    public MainPanel(Gui gui) {
        inserisciProdotto.addActionListener(e -> gui.setVisiblePanel(gui.getInserisciProdotti()));

        visualizzaProdotti.addActionListener(e -> gui.setVisiblePanel(gui.getVisualizzaProdotti()));

        altro.addActionListener(e -> gui.setVisiblePanel(gui.getAvanzato()));
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}

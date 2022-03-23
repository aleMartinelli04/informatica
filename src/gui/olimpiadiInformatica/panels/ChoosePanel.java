package gui.olimpiadiInformatica.panels;

import gui.olimpiadiInformatica.Gui;

import javax.swing.*;

public class ChoosePanel extends CustomPanel {
    private JPanel choosePanel;
    private JButton inserisciPartecipantiButton;
    private JButton mostraPartecipantiButton;
    private JButton altroButton;

    public ChoosePanel(Gui gui) {
        inserisciPartecipantiButton.addActionListener(e -> gui.setVisibleJPanel(gui.getInsertPartecipantPanel()));
        mostraPartecipantiButton.addActionListener(e -> gui.setVisibleJPanel(gui.getShowPartecipantPanel()));
        altroButton.addActionListener(e -> gui.setVisibleJPanel(gui.getAltroPanel()));
    }

    @Override
    public JPanel getPanel() {
        return choosePanel;
    }
}

package gui.olimpiadiInformatica.panels;

import gui.olimpiadiInformatica.Gui;
import gui.olimpiadiInformatica.Partecipante;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class ShowPartecipantPanel extends CustomPanel {
    private JPanel showPartecipantPanel;
    private JPanel selectPanel;
    private JTextField codiceFiscale;
    private JTextField nome;
    private JTextField classe;
    private JTextField punteggio;
    private JButton indietroButton;
    private JButton saveButton;

    private final Gui gui;

    public ShowPartecipantPanel(Gui gui) {
        this.gui = gui;
        indietroButton.addActionListener(e -> gui.setVisibleJPanel(gui.getChoosePanel()));
        saveButton.addActionListener(e -> {
            try {
                FileWriter file = new FileWriter("src/gui/olimpiadiInformatica/partecipants.txt");

                for (Partecipante partecipante : gui.getPartecipants()) {
                    file.write(partecipante.serialzie() + "\n");
                }

                file.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gui, ex.getMessage(), "Attenzione", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void updatePartecipants() {
        selectPanel.removeAll();

        for (Partecipante partecipante : gui.getPartecipants()) {
            JButton button = new JButton(partecipante.getNome());

            button.addActionListener(e -> {
                codiceFiscale.setText(partecipante.getCodiceFiscale());
                nome.setText(partecipante.getNome());
                classe.setText(String.valueOf(partecipante.getClasse()));
                punteggio.setText(String.valueOf(partecipante.getPunteggio()));
            });

            selectPanel.add(button);
        }
    }

    @Override
    public JPanel getPanel() {
        updatePartecipants();
        return showPartecipantPanel;
    }

    private void createUIComponents() {
        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
    }
}

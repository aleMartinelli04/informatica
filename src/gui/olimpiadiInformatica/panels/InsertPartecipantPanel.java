package gui.olimpiadiInformatica.panels;

import gui.olimpiadiInformatica.Gui;
import gui.olimpiadiInformatica.Partecipante;
import gui.olimpiadiInformatica.ValidatorePartecipante;

import javax.swing.*;
import java.io.FileReader;
import java.util.Scanner;

public class InsertPartecipantPanel extends CustomPanel {
    private JPanel insertPartecipantPanel;
    private JTextField codiceFiscaleText;
    private JTextField nomeText;
    private JTextField classeText;
    private JTextField punteggioText;
    private JButton inserisciStudenteButton;
    private JButton indietroButton;
    private JButton fileButton;

    private final ValidatorePartecipante validatore;

    public InsertPartecipantPanel(Gui gui) {
        validatore = new ValidatorePartecipante();

        inserisciStudenteButton.addActionListener(e -> {
            try {
                validatore.validaCodiceFiscale(codiceFiscaleText.getText());
                validatore.validaNome(nomeText.getText());
                validatore.validaClasse(Integer.parseInt(classeText.getText()));
                validatore.validaPunteggio(Integer.parseInt(punteggioText.getText()));

                Partecipante partecipante = new Partecipante(codiceFiscaleText.getText(), nomeText.getText(),
                        Integer.parseInt(classeText.getText()), Integer.parseInt(punteggioText.getText()));

                gui.getPartecipants().add(partecipante);

                JOptionPane.showMessageDialog(gui, "Studente inserito con successo", "", JOptionPane.WARNING_MESSAGE);
                resetInputFields();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gui, ex.getMessage(), "Attenzione", JOptionPane.WARNING_MESSAGE);
            }
        });

        indietroButton.addActionListener(e -> gui.setVisibleJPanel(gui.getChoosePanel()));

        fileButton.addActionListener(e -> {
            try {
                FileReader fileReader = new FileReader("src/gui/olimpiadiInformatica/partecipants.txt");
                Scanner scanner = new Scanner(fileReader);

                int i = 0;

                while (scanner.hasNextLine()) {
                    gui.getPartecipants().add(Partecipante.deserialzie(scanner.nextLine()));
                    i++;
                }

                JOptionPane.showMessageDialog(gui, "Aggiunti con successo " + i + " partecipanti!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gui, ex.getMessage());
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return insertPartecipantPanel;
    }

    public void resetInputFields() {
        codiceFiscaleText.setText("");
        nomeText.setText("");
        classeText.setText("");
        punteggioText.setText("");
    }
}

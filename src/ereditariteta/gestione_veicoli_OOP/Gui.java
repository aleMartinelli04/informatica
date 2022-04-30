package ereditariteta.gestione_veicoli_OOP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTextArea inputDescrizioneField;
    private JTextField inputPrezzoField;
    private JTabbedPane tabbedPaneInserimento;
    private JTextField inputPotenzaField;
    private JComboBox<Carburanti> carburanteComboBox;
    private JSpinner inputRuoteSpinner;
    private JRadioButton inputSiRadioButton;
    private JRadioButton inputNoRadioButton;
    private JButton inputInserisciButton;


    private final List<Veicolo> veicoli;

    public Gui() {
        super("Gestione veicoli");

        setSize(700, 500);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        this.veicoli = new ArrayList<>();

        for (Carburanti c : Carburanti.values()) {
            carburanteComboBox.addItem(c);
        }

        inputInserisciButton.addActionListener(this::inserisciVeicolo);
    }

    private void inserisciVeicolo(ActionEvent ignored) {
        try {
            Veicolo veicolo;

            String descrizione = inputDescrizioneField.getText();
            if (descrizione.isEmpty()) {
                throw new Exception("Descrizione non inserita");
            }

            double prezzo = Double.parseDouble(inputPrezzoField.getText());
            if (prezzo <= 0) {
                throw new Exception("Prezzo non valido");
            }

            if (tabbedPaneInserimento.getSelectedIndex() == 0) {
                double potenza = Double.parseDouble(inputPotenzaField.getText());
                if (potenza <= 0) {
                    throw new Exception("Potenza non valida");
                }

                Carburanti carburante = (Carburanti) carburanteComboBox.getSelectedItem();

                veicolo = new VeicoloAMotore(descrizione, prezzo, potenza, carburante);

            } else if (tabbedPaneInserimento.getSelectedIndex() == 1) {
                int ruote = (int) inputRuoteSpinner.getValue();
                if (ruote <= 0) {
                    throw new Exception("Numero di ruote non valido");
                }

                if (!inputSiRadioButton.isSelected() && !inputNoRadioButton.isSelected()) {
                    throw new Exception("Selezionare se il veicolo ha o no la licenza");
                }
                boolean licenza = inputSiRadioButton.isSelected();

                veicolo = new VeicoloSenzaMotore(descrizione, prezzo, ruote, licenza);

            } else {
                JOptionPane.showMessageDialog(this, "Selezionare un tipo di veicolo", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            veicoli.add(veicolo);
            JOptionPane.showMessageDialog(this, "Veicolo inserito correttamente", "Inserimento veicolo", JOptionPane.INFORMATION_MESSAGE);

            inputDescrizioneField.setText("");
            inputPrezzoField.setText("");
            inputPotenzaField.setText("");
            inputRuoteSpinner.setValue(0);
            inputSiRadioButton.setSelected(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }


}

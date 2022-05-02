package ereditariteta.gestione_veicoli_OOP;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gui extends JFrame {
    private JPanel mainPanel;

    private JTextArea inputDescrizioneField;
    private JTextField inputPrezzoField;
    private JTabbedPane tabbedPaneInserimento;
    private JTextField inputPotenzaField;
    private JComboBox<Carburanti> inputCarburanteComboBox;
    private JSpinner inputRuoteSpinner;
    private JRadioButton inputSiRadioButton;
    private JRadioButton inputNoRadioButton;
    private JButton inputInserisciButton;

    private JTabbedPane visualizzazioneTabbedPane;
    private JTextField visualizzazioneCodiceField;
    private JTextField visualizzazioneDataField;
    private JTextArea visualizzazioneDescrizioneField;
    private JTextField visualizzazionePrezzoField;
    private JList<Veicolo> visualizzazioneList;
    private JTextField visualizzazionePotenzaField;
    private JComboBox<Carburanti> visualizzazioneCarburanteBox;
    private JSpinner visualizzazioneRuoteField;
    private JRadioButton visualizzazioneSiRadioButton;
    private JRadioButton visualizzazioneNoRadioButton;
    private JButton visualizzazioneOrdinaButton;
    private JButton visualizzazioneSalvaButton;
    private JComboBox<Ordinamenti> visualizzazioneOrdinamentoBox;
    private JTextField visualizzazionePrezzoVenditaField;

    private final DefaultListModel<Veicolo> listModel;

    public Gui() throws InterruptedException {
        super("Gestione veicoli");

        setSize(700, 550);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        this.listModel = new DefaultListModel<>();

        for (Carburanti c : Carburanti.values()) {
            inputCarburanteComboBox.addItem(c);
            visualizzazioneCarburanteBox.addItem(c);
        }

        for (Ordinamenti ordinamento : Ordinamenti.values()) {
            visualizzazioneOrdinamentoBox.addItem(ordinamento);
        }

        inputInserisciButton.addActionListener(this::inserisciVeicolo);

        visualizzazioneList.addListSelectionListener(this::veicoloSelezionato);
        visualizzazioneList.setModel(listModel);
        visualizzazioneOrdinaButton.addActionListener(this::ordinaVeicoli);
        visualizzazioneSalvaButton.addActionListener(this::salvaModifiche);
    }

    private void salvaModifiche(ActionEvent ignored) {
        Veicolo veicolo = visualizzazioneList.getSelectedValue();

        if (veicolo == null) {
            JOptionPane.showMessageDialog(this, "Selezionare un veicolo", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            veicolo.setDescrizione(visualizzazioneDescrizioneField.getText());
            veicolo.setPrezzo(Double.parseDouble(visualizzazionePrezzoField.getText()));
            visualizzazionePrezzoVenditaField.setText(String.valueOf(veicolo.getPrezzoVendita()));

            if (veicolo instanceof VeicoloSenzaMotore veicoloSenzaMotore) {
                veicoloSenzaMotore.setLicenza(visualizzazioneSiRadioButton.isSelected());
            }

            JOptionPane.showMessageDialog(this, "Modifiche salvate", "Info", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato del prezzo non valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ordinaVeicoli(ActionEvent ignored) {
        List<Veicolo> veicoli = Collections.list(listModel.elements());

        ListSelectionListener listener = visualizzazioneList.getListSelectionListeners()[0];
        visualizzazioneList.removeListSelectionListener(listener);

        Comparator<Veicolo> comparator = visualizzazioneOrdinamentoBox.getItemAt(visualizzazioneOrdinamentoBox.getSelectedIndex()).getComparator();
        veicoli.sort(comparator);

        listModel.clear();
        for (Veicolo v : veicoli) {
            listModel.addElement(v);
        }

        visualizzazioneList.addListSelectionListener(listener);
    }

    private void veicoloSelezionato(ListSelectionEvent ignored) {
        Veicolo veicolo = visualizzazioneList.getSelectedValue();

        if (veicolo == null) {
            JOptionPane.showMessageDialog(this, "Nessun veicolo selezionato", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        visualizzazioneCodiceField.setText(veicolo.getCodice());
        visualizzazioneDataField.setText(veicolo.getFormattedDate());
        visualizzazioneDescrizioneField.setText(veicolo.getDescrizione());
        visualizzazionePrezzoField.setText(String.valueOf(veicolo.getPrezzo()));
        visualizzazionePrezzoVenditaField.setText(String.valueOf(veicolo.getPrezzoVendita()));

        if (veicolo instanceof VeicoloAMotore veicoloAMotore) {
            visualizzazioneTabbedPane.setSelectedIndex(0);
            visualizzazionePotenzaField.setText(String.valueOf(veicoloAMotore.getPotenza()));
            visualizzazioneCarburanteBox.setSelectedItem(veicoloAMotore.getCarburante());

        } else if (veicolo instanceof VeicoloSenzaMotore veicoloSenzaMotore) {
            visualizzazioneTabbedPane.setSelectedIndex(1);
            visualizzazioneRuoteField.setValue(veicoloSenzaMotore.getRuote());
            visualizzazioneSiRadioButton.setSelected(veicoloSenzaMotore.hasLicenza());
            visualizzazioneNoRadioButton.setSelected(!veicoloSenzaMotore.hasLicenza());
        }
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

                Carburanti carburante = (Carburanti) inputCarburanteComboBox.getSelectedItem();

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

            listModel.addElement(veicolo);
            JOptionPane.showMessageDialog(this, "Veicolo inserito correttamente", "Inserimento veicolo", JOptionPane.INFORMATION_MESSAGE);

            inputDescrizioneField.setText("");
            inputPrezzoField.setText("");
            inputPotenzaField.setText("");
            inputRuoteSpinner.setValue(0);
            inputSiRadioButton.setSelected(true);

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Inserire un numero valido", "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
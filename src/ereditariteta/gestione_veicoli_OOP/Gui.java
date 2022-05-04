package ereditariteta.gestione_veicoli_OOP;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane mainTabbedPane;

    private JTextArea inputDescrizioneField;
    private JTextField inputPrezzoField;
    private JTabbedPane tabbedPaneInserimento;
    private JTextField inputPotenzaField;
    private JComboBox<Carburanti> inputCarburanteComboBox;
    private JSpinner inputRuoteSpinner;
    private JRadioButton inputSiRadioButton;
    private JRadioButton inputNoRadioButton;
    private JButton inputInserisciButton;
    private JButton inputVeicoloRandomButton;

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

    private JTextField eliminazioneCodiceVeicoloField;
    private JButton eliminazioneButton;

    private JTextField statsPrezzoMaggioreField;
    private JTextField statsPrezzoMinoreField;

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

        mainTabbedPane.addChangeListener(e -> {
            if (mainTabbedPane.getSelectedIndex() == 3) {
                updateStatsPanel();
            }
        });

        inputInserisciButton.addActionListener(this::inserisciVeicolo);
        inputVeicoloRandomButton.addActionListener(this::inserisciVeicoloRandom);

        visualizzazioneList.addListSelectionListener(this::veicoloSelezionato);
        visualizzazioneList.setModel(listModel);
        visualizzazioneOrdinaButton.addActionListener(this::ordinaVeicoli);
        visualizzazioneSalvaButton.addActionListener(this::salvaModifiche);

        eliminazioneButton.addActionListener(this::eliminaVeicolo);
    }

    private void inserisciVeicoloRandom(ActionEvent ignored) {
        Veicolo veicolo = Veicolo.getRandom();

        listModel.addElement(veicolo);

        JOptionPane.showMessageDialog(this, "Veicolo \"" + veicolo.getDescrizione() + "\" inserito", "Inserimento", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateStatsPanel() {
        List<Veicolo> veicoli = Collections.list(listModel.elements());

        if (veicoli.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Non ci sono veicoli da visualizzare", "Errore", JOptionPane.ERROR_MESSAGE);
            mainTabbedPane.setSelectedIndex(0);
            return;
        }

        double maggiore = veicoli.stream()
                .mapToDouble(Veicolo::getPrezzoVendita)
                .max()
                .getAsDouble();

        double minore = veicoli.stream()
                .mapToDouble(Veicolo::getPrezzoVendita)
                .min()
                .getAsDouble();

        statsPrezzoMaggioreField.setText(NumberFormat.getCurrencyInstance().format(maggiore));
        statsPrezzoMinoreField.setText(NumberFormat.getCurrencyInstance().format(minore));
    }

    private void eliminaVeicolo(ActionEvent ignored) {
        String codice = eliminazioneCodiceVeicoloField.getText();
        if (codice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inserire un codice", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Veicolo> veicoli = Collections.list(listModel.elements());

        Veicolo veicolo = veicoli.stream()
                .filter(v -> v.getCodice().equalsIgnoreCase(codice))
                .findFirst()
                .orElse(null);

        if (veicolo == null) {
            JOptionPane.showMessageDialog(this, "Veicolo non trovato", "Errore", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Veicolo eliminato", "Info", JOptionPane.INFORMATION_MESSAGE);
        veicoli.remove(veicolo);
        updateJList(veicoli);
        eliminazioneCodiceVeicoloField.setText("");
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

        Comparator<Veicolo> comparator = visualizzazioneOrdinamentoBox.getItemAt(visualizzazioneOrdinamentoBox.getSelectedIndex()).getComparator();
        veicoli.sort(comparator);

        updateJList(veicoli);
    }

    private void updateJList(List<Veicolo> veicoli) {
        ListSelectionListener listener = visualizzazioneList.getListSelectionListeners()[0];
        visualizzazioneList.removeListSelectionListener(listener);

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

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Inserire un numero valido", "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
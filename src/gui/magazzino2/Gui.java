package gui.magazzino2;

import gui.magazzino2.classes.Articolo;
import gui.magazzino2.classes.GestoreArticoli;
import gui.magazzino2.classes.ValidatoreArticolo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Gui extends JFrame {
    private JTabbedPane tabbedPane1;
    private JTextField descrizioneField;
    private JSpinner quantitaSpinner;
    private JTextField prezzoField;
    private JButton aggiungiButton;
    private JTextField _descrizioneField;
    private JSpinner _quantitaSpinner;
    private JTextField _prezzoField;
    private JButton aggiungiOrdineButton;
    private JList<Articolo> jList;
    private JButton evadiOrdineButton;
    private JList<Articolo> ordineList;

    private final ValidatoreArticolo validatore;
    private final GestoreArticoli ordine;
    private final GestoreArticoli articoli;

    public Gui() {
        super("Magazzino");

        setContentPane(tabbedPane1);

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.validatore = new ValidatoreArticolo();
        this.ordine = new GestoreArticoli();
        this.articoli = new GestoreArticoli();

        aggiungiButton.addActionListener(this::creaArticlo);
        aggiungiOrdineButton.addActionListener(this::aggiungiOrdine);
        evadiOrdineButton.addActionListener(this::evadiOrdine);

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Articolo articolo = jList.getSelectedValue();

                if (articolo == null) {
                    return;
                }

                _descrizioneField.setText(articolo.getDescrizione());
                _quantitaSpinner.setValue(articolo.getQuantita());
                _prezzoField.setText(String.valueOf(articolo.getPrezzo()));
            }
        });
    }

    private void creaArticlo(ActionEvent ignored) {
        try {
            String descrizione = descrizioneField.getText();
            int quantita = (int) quantitaSpinner.getValue();
            double prezzo = Double.parseDouble(prezzoField.getText());

            validatore.validaArticolo(descrizione, quantita, prezzo);

            articoli.add(new Articolo(descrizione, quantita, prezzo));

            descrizioneField.setText("");
            quantitaSpinner.setValue(0);
            prezzoField.setText("");

            updateJList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aggiungiOrdine(ActionEvent ignored) {
        Articolo articolo = jList.getSelectedValue();

        ordine.add(articolo);

        DefaultListModel<Articolo> listModel = new DefaultListModel<>();
        listModel.addAll(ordine.getArticoli());
        ordineList.setModel(listModel);
    }

    private void evadiOrdine(ActionEvent ignored) {
        List<Articolo> articoliOrdine = ordine.getArticoli();

        ordineList.setModel(new DefaultListModel<>());

        if (articoliOrdine.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        articoliOrdine.stream().map(Articolo::toString).forEach(str -> sb.append(str).append("\n"));

        JOptionPane.showMessageDialog(this, sb.toString(), "Ordine", JOptionPane.WARNING_MESSAGE);

        ordine.reset();
    }

    private void updateJList() {
        DefaultListModel<Articolo> listModel = new DefaultListModel<>();

        listModel.addAll(articoli.getArticoli());

        jList.setModel(listModel);
    }
}

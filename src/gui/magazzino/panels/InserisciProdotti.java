package gui.magazzino.panels;

import gui.magazzino.Categorie;
import gui.magazzino.Gui;
import gui.magazzino.Prodotto;
import gui.magazzino.ValidatoreProdotto;

import javax.swing.*;

public class InserisciProdotti extends CustomPanel {
    private JPanel mainPanel;
    private JTextField codiceField;
    private JTextField nomeField;
    private JTextField prezzoField;
    private JComboBox<Categorie> categoriaBox;
    private JTextField quantitaField;
    private JButton inserisciButton;
    private JButton indietroButton;

    private final ValidatoreProdotto validatore;

    public InserisciProdotti(Gui gui) {
        this.validatore = new ValidatoreProdotto();

        for (Categorie categorie : Categorie.values()) {
            categoriaBox.addItem(categorie);
        }

        inserisciButton.addActionListener(e -> {
            try {
                String codice = codiceField.getText();
                String nome = nomeField.getText();
                double prezzo = Double.parseDouble(prezzoField.getText());
                Categorie categoria = (Categorie) categoriaBox.getSelectedItem();
                int quantita = Integer.parseInt(quantitaField.getText());

                validatore.validaProdotto(codice, nome, prezzo, quantita);

                gui.addProdotto(new Prodotto(codice, nome, prezzo, categoria, quantita));

                JOptionPane.showMessageDialog(gui, "Prodotto aggiunto!");

                codiceField.setText("");
                nomeField.setText("");
                prezzoField.setText("");
                categoriaBox.setSelectedIndex(0);
                quantitaField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gui, ex.getMessage(), "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
            }
        });

        indietroButton.addActionListener(e -> gui.setVisiblePanel(gui.getMainPanel()));
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}

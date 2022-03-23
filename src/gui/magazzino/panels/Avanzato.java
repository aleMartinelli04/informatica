package gui.magazzino.panels;

import gui.magazzino.Categorie;
import gui.magazzino.Gui;
import gui.magazzino.Prodotto;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;

public class Avanzato extends CustomPanel {
    private JPanel mainPanel;
    private JComboBox<Categorie> comboBox;
    private JButton indietro;
    private JButton loadButton;
    private JButton saveButton;

    public Avanzato(Gui gui) {
        for (Categorie categoria : Categorie.values()) {
            comboBox.addItem(categoria);
        }

        comboBox.addActionListener(e -> {
            Categorie categoria = (Categorie) comboBox.getSelectedItem();

            Prodotto max = gui.getProdotti().stream()
                    .filter(prodotto -> prodotto.getCategoria() == categoria)
                    .max(Comparator.comparingDouble(Prodotto::getPrezzo))
                    .orElse(null);

            System.out.println(max);
        });

        loadButton.addActionListener(e -> {
            try {
                gui.loadFromFile();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        saveButton.addActionListener(e -> {
            try {
                gui.saveOnFile();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        indietro.addActionListener(e -> gui.setVisiblePanel(gui.getMainPanel()));
    }

    @Override
    public JPanel getPanel() {
        return mainPanel;
    }
}

package gui.magazzino;

import gui.magazzino.panels.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gui extends JFrame {
    private final MainPanel mainPanel;
    private final InserisciProdotti inserisciProdotti;
    private final VisualizzaProdotti visualizzaProdotti;
    private final Avanzato avanzato;

    private final List<CustomPanel> panels;

    private final List<Prodotto> prodotti;

    public Gui() {
        super("Magazzino");

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        this.prodotti = new ArrayList<>();
        this.panels = new ArrayList<>();

        this.mainPanel = new MainPanel(this);
        panels.add(mainPanel);
        add(mainPanel.getPanel());

        this.inserisciProdotti = new InserisciProdotti(this);
        panels.add(inserisciProdotti);
        add(inserisciProdotti.getPanel());

        this.visualizzaProdotti = new VisualizzaProdotti(this);
        panels.add(visualizzaProdotti);
        add(visualizzaProdotti.getPanel());

        this.avanzato = new Avanzato(this);
        panels.add(avanzato);
        add(avanzato.getPanel());

        setVisiblePanel(mainPanel);
    }

    public void setVisiblePanel(CustomPanel customPanel) {
        for (CustomPanel component : panels) {
            component.setVisible(false);
        }

        customPanel.setVisible(true);
    }

    public void addProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public InserisciProdotti getInserisciProdotti() {
        return inserisciProdotti;
    }

    public VisualizzaProdotti getVisualizzaProdotti() {
        return visualizzaProdotti;
    }

    public Avanzato getAvanzato() {
        return avanzato;
    }

    public void loadFromFile() throws FileNotFoundException {
        Serializzatore serializzatore = new Serializzatore();

        Scanner scanner = new Scanner(new FileReader("src/gui/magazzino/prodotti.txt"));

        while (scanner.hasNextLine()) {
            prodotti.add(serializzatore.deserializza(scanner.nextLine()));
        }
    }

    public void saveOnFile() throws IOException {
        Serializzatore serializzatore = new Serializzatore();

        FileWriter fileWriter = new FileWriter("src/gui/magazzino/prodotti.txt");

        for (Prodotto prodotto : prodotti) {
            fileWriter.write(serializzatore.serializza(prodotto) + "\n");
        }

        fileWriter.close();
    }
}

package gui.magazzino.panels;

import gui.magazzino.Gui;
import gui.magazzino.Prodotto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisualizzaProdotti extends CustomPanel {
    private JPanel mainPanel;
    private JButton indietroButton;
    private JScrollPane scrollPane;
    private JTable table;

    private final List<Prodotto> prodotti;

    public VisualizzaProdotti(Gui gui) {
        indietroButton.addActionListener(e -> gui.setVisiblePanel(gui.getMainPanel()));

        this.prodotti = gui.getProdotti();

        updatePanel();
    }

    public void updatePanel() {
        Object[][] data = prodotti.stream().map(Prodotto::toArray).toArray(Object[][]::new);

        DefaultTableModel tableModel = new DefaultTableModel(data, Prodotto.getCampi()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(tableModel);
    }

    @Override
    public JPanel getPanel() {
        updatePanel();
        return mainPanel;
    }
}

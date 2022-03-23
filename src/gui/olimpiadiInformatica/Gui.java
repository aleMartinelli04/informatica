package gui.olimpiadiInformatica;

import gui.olimpiadiInformatica.panels.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
    private final List<Partecipante> partecipants;

    private final ChoosePanel choosePanel;
    private final ShowPartecipantPanel showPartecipantPanel;
    private final InsertPartecipantPanel insertPartecipantPanel;
    private final Altro altroPanel;

    public Gui() {
        super("Partecipanti Olimpiadi di Informatica");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width * 3 / 5, Toolkit.getDefaultToolkit().getScreenSize().height * 3 / 5);
        setLocationRelativeTo(null);

        this.partecipants = new ArrayList<>();

        this.choosePanel = new ChoosePanel(this);
        this.showPartecipantPanel = new ShowPartecipantPanel(this);
        this.insertPartecipantPanel = new InsertPartecipantPanel(this);
        this.altroPanel = new Altro(this);

        setLayout(new CardLayout());
        add(choosePanel.getPanel());
        add(showPartecipantPanel.getPanel());
        add(insertPartecipantPanel.getPanel());
        add(altroPanel.getPanel());

        setVisibleJPanel(choosePanel);
    }

    public List<Partecipante> getPartecipants() {
        return partecipants;
    }

    public void setVisibleJPanel(CustomPanel customPanel) {
        /*if (customPanel instanceof ChoosePanel) {
            choosePanel.getPanel().setVisible(true);

            showPartecipantPanel.getPanel().setVisible(false);
            insertPartecipantPanel.getPanel().setVisible(false);
            altroPanel.getPanel().setVisible(false);

        } else if (customPanel instanceof ShowPartecipantPanel) {
            showPartecipantPanel.getPanel().setVisible(true);
            showPartecipantPanel.updatePartecipants();

            choosePanel.getPanel().setVisible(false);
            insertPartecipantPanel.getPanel().setVisible(false);
            altroPanel.getPanel().setVisible(false);

        } else if (customPanel instanceof InsertPartecipantPanel) {
            insertPartecipantPanel.getPanel().setVisible(true);

            choosePanel.getPanel().setVisible(false);
            showPartecipantPanel.getPanel().setVisible(false);
            altroPanel.getPanel().setVisible(false);

        } else if (customPanel instanceof Altro) {
            altroPanel.getPanel().setVisible(true);

            choosePanel.getPanel().setVisible(false);
            showPartecipantPanel.getPanel().setVisible(false);
            insertPartecipantPanel.getPanel().setVisible(false);
        }*/

        for (Component component : getComponents()) {
            if (component instanceof CustomPanel) {
                ((CustomPanel) component).getPanel().setVisible(false);
            }
        }

        customPanel.getPanel().setVisible(true);
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }

    public InsertPartecipantPanel getInsertPartecipantPanel() {
        return insertPartecipantPanel;
    }

    public ShowPartecipantPanel getShowPartecipantPanel() {
        return showPartecipantPanel;
    }

    public Altro getAltroPanel() {
        return altroPanel;
    }
}

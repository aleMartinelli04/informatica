package ereditariteta.contocorrente_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;

    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JTextField saldoTextField;
    private JRadioButton contoSpecialeRadioButton;
    private JRadioButton contoNormaleRadioButton;
    private JButton apriContoButton;

    private JList<ContoCorrente> listContiCorrenti;
    private JTextField tipoDiContoField;
    private JTextField importoDisponibileField;
    private JTextField importoField;
    private JButton versaButton;
    private JButton prelevaButton;

    private final List<ContoCorrente> contiCorrenti;

    public Gui() {
        super("Conti Correnti");
        setContentPane(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);

        contiCorrenti = new ArrayList<>();

        apriContoButton.addActionListener(event -> {
            try {
                apriConto(event);
            } catch (Exception e) {
                showException(e);
            }
        });

        tabbedPane1.addChangeListener(event -> {
            if (tabbedPane1.getSelectedIndex() == 1) {
                DefaultListModel<ContoCorrente> model = new DefaultListModel<>();

                for (ContoCorrente contoCorrente : contiCorrenti) {
                    model.addElement(contoCorrente);
                }

                listContiCorrenti.setModel(model);
            }
        });

    }


    private void apriConto(ActionEvent ignored) throws Exception {
        String nome = nomeTextField.getText();
        String cognome = cognomeTextField.getText();
        double saldo = Double.parseDouble(saldoTextField.getText());
        boolean contoSpeciale = contoSpecialeRadioButton.isSelected();

        if (contoSpeciale) {
            contiCorrenti.add(new ContoSpeciale(nome, cognome, saldo));
        } else {
            contiCorrenti.add(new ContoCorrente(nome, cognome, saldo));
        }

        nomeTextField.setText("");
        cognomeTextField.setText("");
        saldoTextField.setText("");

        contoNormaleRadioButton.setSelected(true);
        contoSpecialeRadioButton.setSelected(false);

        JOptionPane.showMessageDialog(this, "Conto corrente aperto", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showException(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
    }
}

package ereditariteta.cilindro_OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {
    private JPanel panel;
    private JTextField raggioCerchioField;
    private JTextField altezzaCilindroField;
    private JButton areaCilindroButton;
    private JButton volumeCilindroButton;
    private JButton areaCerchioButton;
    private JTextField raggioCilindroField;
    private JButton mostraCilindroButton;
    private JButton mostraCerchioButton;

    private Cerchio cerchio;
    private Cilindro cilindro;

    public Gui() {
        super("Cilindro OOP");

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(panel);

        areaCerchioButton.addActionListener(ignored -> {
            try {
                calcolaAreaCerchio(ignored);
            } catch (Exception e) {
                showException(e);
            }
        });

        areaCilindroButton.addActionListener(ignored -> {
            try {
                calcolaAreaCilindro(ignored);
            } catch (Exception e) {
                showException(e);
            }
        });

        volumeCilindroButton.addActionListener(ignored -> {
            try {
                calcolaVolumeCilindro(ignored);
            } catch (Exception e) {
                showException(e);
            }
        });

        mostraCerchioButton.addActionListener(ignored -> showData(cerchio, "Cerchio"));
        mostraCilindroButton.addActionListener(ignored -> showData(cilindro, "Cilindro"));
    }

    private void calcolaAreaCerchio(ActionEvent ignored) throws Exception {
        double raggio = Double.parseDouble(raggioCerchioField.getText());

        if (cerchio == null) {
            cerchio = new Cerchio(raggio);
        } else {
            cerchio.setRaggio(raggio);
        }

        showData(cerchio.area(), "Area del cerhio");
    }

    private void calcolaAreaCilindro(ActionEvent ignored) throws Exception {
        double raggio = Double.parseDouble(raggioCilindroField.getText());
        double altezza = Double.parseDouble(altezzaCilindroField.getText());

        if (cilindro == null) {
            cilindro = new Cilindro(raggio, altezza);
        } else {
            cilindro.setRaggio(raggio);
        }

        showData(cilindro.area(), "Area del cilindro");
    }

    private void calcolaVolumeCilindro(ActionEvent ignored) throws Exception {
        double raggio = Double.parseDouble(raggioCilindroField.getText());
        double altezza = Double.parseDouble(altezzaCilindroField.getText());

        if (cilindro == null) {
            cilindro = new Cilindro(raggio, altezza);
        } else {
            cilindro.setRaggio(raggio);
            cilindro.setAltezza(altezza);
        }

        showData(cilindro.volume(), "Volume del cilindro");
    }

    private void showException(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
    }

    private void showData(Object data, String name) {
        if (data == null) {
            showException(new Exception("Inserisci i dati prima"));
            return;
        }

        JOptionPane.showMessageDialog(this, data.toString(), name, JOptionPane.INFORMATION_MESSAGE);
    }
}

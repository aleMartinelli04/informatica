package gui.olimpiadiInformatica.panels;

import gui.olimpiadiInformatica.Gui;
import gui.olimpiadiInformatica.Partecipante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Altro extends CustomPanel {
    private JPanel panel;
    private JButton ammittedButton;

    public Altro(Gui gui) {
        ammittedButton.addActionListener(e -> {
            if (gui.getPartecipants().isEmpty()) {
                return;
            }

            int ammitted = 0;

            List<Partecipante> sorted = new ArrayList<>(gui.getPartecipants());
            sorted.sort(Comparator.comparingInt(Partecipante::getPunteggio));
            Collections.reverse(sorted);

            List<Partecipante> ammittedPartecipants = new ArrayList<>();
            ammittedPartecipants.add(sorted.get(0));

            double average = sorted.stream().mapToDouble(Partecipante::getPunteggio).average().getAsDouble();

            for (int i = 1; i < sorted.size(); i++) {
                if (sorted.get(i).getPunteggio() <= average) {
                    break;
                }

                if (ammitted == 10) {
                    break;
                }

                ammittedPartecipants.add(sorted.get(i));
                ammitted++;
            }

            StringBuilder message = new StringBuilder();
            for (Partecipante partecipante : ammittedPartecipants) {
                message.append(partecipante.getNome())
                        .append(" - ")
                        .append(partecipante.getPunteggio());
            }

            JOptionPane.showMessageDialog(gui, message.toString());
        });

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}

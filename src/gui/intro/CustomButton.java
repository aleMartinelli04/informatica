package gui.intro;

import javax.swing.*;

public class CustomButton extends JButton {
    private final String note;

    public CustomButton(String note) {
        super(note.toUpperCase());

        this.note = note;
    }

    public String getNote() {
        return note;
    }
}

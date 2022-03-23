package gui.intro;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardMusic extends JFrame {

    private JTextField noteMusicali;
    private JButton DOButton;
    private JButton REButton;
    private JButton MIButton;
    private JButton FAButton;
    private JButton SOLButton;
    private JButton LAButton;
    private JButton SIButton;
    private JPanel panel;
    private JTextField cosooo;

    private final PlayerThread player;

    public KeyboardMusic(String title) {
        super(title);
        this.player = new PlayerThread();

        DOButton.setMnemonic('Q');

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DOButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "DO ");
            player.play("C");
        });
        REButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "RE ");
            player.play("D");
        });
        MIButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "MI ");
            player.play("E");
        });
        FAButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "FA ");
            player.play("F");
        });
        SOLButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "SOL ");
            player.play("G");
        });
        LAButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "LA ");
            player.play("A");
        });
        SIButton.addActionListener(e -> {
            noteMusicali.setText(noteMusicali.getText() + "SI ");
            player.play("B");
        });

        cosooo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        setContentPane(panel);
        pack();
    }
}

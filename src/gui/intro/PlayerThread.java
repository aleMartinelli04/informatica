package gui.intro;

import org.jfugue.player.Player;

public class PlayerThread {
    public void play(String... note) {
        try {
            new Thread(() -> new Player().play(note)).start();
        } catch (Exception ignored) {
        }
    }
}

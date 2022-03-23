package gui.intro;

public class NoteConverter {

    public String convert(char keyboardChar) {
        return switch (Character.toLowerCase(keyboardChar)){
            case 'q' -> "Cmaj";
            case '2' -> "C#maj";
            case 'w' -> "Dmaj";
            case '3' -> "D#maj";
            case 'e' -> "Emaj";
            case 'r' -> "Fmaj";
            case '5' -> "F#maj";
            case 't' -> "Gmaj";
            case '6' -> "G#maj";
            case 'y' -> "Amaj";
            case '7' -> "A#maj";
            case 'u' -> "Bmaj";
            default -> null;
        };
    }
}

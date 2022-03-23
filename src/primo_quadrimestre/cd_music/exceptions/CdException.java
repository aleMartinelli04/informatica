package primo_quadrimestre.cd_music.exceptions;

public abstract class CdException extends Exception {
    public CdException() {
    }

    public CdException(String message) {
        super(message);
    }
}

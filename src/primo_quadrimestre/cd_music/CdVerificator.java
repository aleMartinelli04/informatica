package primo_quadrimestre.cd_music;

import primo_quadrimestre.cd_music.exceptions.InvalidArgumentException;

public class CdVerificator {
    public void checkTitle(String titolo) throws InvalidArgumentException {
        if (titolo == null || titolo.length() < 3) {
            throw new InvalidArgumentException(titolo, "titolo");
        }
    }

    public void checkInterprete(String interprete) throws InvalidArgumentException {
        if (interprete == null || interprete.length() < 3) {
            throw new InvalidArgumentException(interprete, "interprete");
        }
    }

    public void checkPrezzo(double prezzo) throws InvalidArgumentException {
        if (prezzo < 0) {
            throw new InvalidArgumentException(prezzo);
        }
    }
}

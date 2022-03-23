package primo_quadrimestre.cd_music;

import primo_quadrimestre.cd_music.exceptions.InvalidArgumentException;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Cd extends CdVerificator {
    private String codice;
    private String titolo;
    private String interprete;
    private double prezzo;
    private boolean inVetrina;

    private static int cds = 0;


    private Cd() {
        cds++;
    }

    public Cd(String titolo, String interprete, double prezzo) throws InvalidArgumentException {
        this();
        setTitolo(titolo);
        setInterprete(interprete);
        setPrezzo(prezzo);
        setCodice();

        this.inVetrina = ThreadLocalRandom.current().nextBoolean();
    }

    private Cd(String codice, String titolo, String interprete, double prezzo, boolean inVetrina)
            throws InvalidArgumentException {
        this(titolo, interprete, prezzo);
        this.codice = codice;

        this.inVetrina = inVetrina;
    }

    public Cd(Cd cd) {
        this.titolo = cd.titolo;
        this.interprete = cd.interprete;
        this.prezzo = cd.prezzo;
        this.inVetrina = cd.inVetrina;
        this.codice = cd.codice;
    }


    public String toStringFile() {
        return codice + " - " + titolo + " - " + interprete + " - " + prezzo + " - " + inVetrina;
    }

    public static Cd fromFile(String cdString) {
        try {
            String[] parts = cdString.split(" - ");

            return new Cd(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Boolean.parseBoolean(parts[4]));
        } catch (InvalidArgumentException ignored) {
            return null;
        }
    }


    public String getCodice() {
        return codice;
    }

    private void setCodice() {
        this.codice = getSiglaOf(titolo) + getSiglaOf(interprete) + String.format("%03d", cds);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws InvalidArgumentException {
        checkTitle(titolo);

        this.titolo = getFormatted(titolo);
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) throws InvalidArgumentException {
        checkInterprete(interprete);

        this.interprete = getFormatted(interprete);
    }

    public double getPrezzo() {
        if (inVetrina) {
            return prezzo * 0.75;
        }

        return prezzo;
    }

    public void setPrezzo(double prezzo) throws InvalidArgumentException {
        checkPrezzo(prezzo);

        this.prezzo = prezzo;
    }

    public boolean isInVetrina() {
        return inVetrina;
    }


    private String getFormatted(String toFormat) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String part : toFormat.split(" ")) {
            if (part.equals(" ") || part.equals("")) {
                continue;
            }

            if (part.length() == 1) {
                stringBuilder.append(part.toUpperCase(Locale.ROOT));
                stringBuilder.append(" ");
                continue;
            }

            stringBuilder.append(part.substring(0, 1).toUpperCase());
            stringBuilder.append(part.substring(1).toLowerCase());

            stringBuilder.append(" ");
        }

        return stringBuilder.toString().substring(0, stringBuilder.length() - 2);
    }

    private String getSiglaOf(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append(string.replace(" ", "").substring(0, 3).toUpperCase());

        } catch (StringIndexOutOfBoundsException e) {
            stringBuilder.append(string.toUpperCase());

            while (stringBuilder.length() < 3) {
                stringBuilder.append("-");
            }
        }

        return stringBuilder.toString();
    }


    public double calcolaPreventivo(int copie) {
        if (copie >= 10) {
            return getPrezzo() * 0.8 * copie;
        }

        if (copie >= 5) {
            return getPrezzo() * 0.9 * copie;
        }

        if (copie >= 3) {
            return getPrezzo() * 0.95 * copie;
        }

        return getPrezzo() * copie;
    }


    @Override
    public String toString() {
        return titolo + " di " + interprete + " | costo " + NumberFormat.getCurrencyInstance().format(getPrezzo());
    }
}

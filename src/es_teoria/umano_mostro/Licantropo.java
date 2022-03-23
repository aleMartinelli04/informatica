package es_teoria.umano_mostro;

import java.util.Calendar;

public class Licantropo extends Personaggio implements Umano, Mostro {
    private int forzaMostro;

    public Licantropo() {
        super(Umano.FORZAMAX);

        this.forzaMostro = Mostro.FORZAMAX;
    }


    @Override
    public void combatti() throws LunaPienaException {
        if (lunaPiena()) {
            throw new LunaPienaException();
        }

        diminuisciForza(Umano.COSTOATTACCO);
    }

    @Override
    public void azzanna() throws LunaPienaException {
        if (!lunaPiena()) {
            throw new LunaPienaException(new Object());
        }

        this.forzaMostro -= Mostro.COSTOATTACCO;
    }

    @Override
    public int getForza() {
        if (lunaPiena()) {
            return forzaMostro;
        }

        return super.getForza();
    }

    public boolean lunaPiena() {
        return Math.abs(MoonPhase.phase(Calendar.getInstance())) >= 99;
    }
}

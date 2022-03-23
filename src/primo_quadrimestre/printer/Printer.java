package primo_quadrimestre.printer;

import primo_quadrimestre.printer.exceptions.FinishedSheetsException;
import primo_quadrimestre.printer.exceptions.PrinterAlreadyOffException;
import primo_quadrimestre.printer.exceptions.PrinterAlreadyOnException;

public class Printer {
    private int sheetsLeft;
    private boolean on;

    public Printer(int sheetsLeft) {
        this.sheetsLeft = sheetsLeft;
        this.on = false;
    }

    public int getSheetsLeft() {
        return sheetsLeft;
    }

    public void setSheetsLeft(int sheetsLeft) throws FinishedSheetsException {
        if (sheetsLeft <= 0) {
            throw new FinishedSheetsException();
        }

        this.sheetsLeft = sheetsLeft;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() throws PrinterAlreadyOnException {
        if (on) {
            throw new PrinterAlreadyOnException();
        }

        on = true;
    }

    public void turnOff() throws PrinterAlreadyOffException {
        if (!on) {
            throw new PrinterAlreadyOffException();
        }

        on = false;
    }

    public int print(int sheets) {
        try {
            setSheetsLeft(sheetsLeft - sheets);

            return sheetsLeft;
        } catch (FinishedSheetsException e) {
            return -1;
        }
    }



}

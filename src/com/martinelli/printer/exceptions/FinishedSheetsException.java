package com.martinelli.printer.exceptions;

public class FinishedSheetsException extends PrinterException {
    public FinishedSheetsException() {
        super("La stampante ha finito i fogli!");
    }
}

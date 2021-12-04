package com.martinelli.printer.exceptions;

public class PrinterAlreadyOffException extends PrinterException {
    public PrinterAlreadyOffException() {
        super("La stampante è già spenta!");
    }
}

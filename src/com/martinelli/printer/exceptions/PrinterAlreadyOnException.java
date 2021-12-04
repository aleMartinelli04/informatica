package com.martinelli.printer.exceptions;

public class PrinterAlreadyOnException extends PrinterException {
    public PrinterAlreadyOnException() {
        super("La stampante è già accesa!");
    }
}

package com.martinelli.housework.sasso_carta_forbice;

public enum SassoCartaForbice {
    SASSO("sasso"),
    CARTA("carta"),
    FORBICE("forbice");

    private final String nome;

    SassoCartaForbice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean vinceContro(SassoCartaForbice avversario) {
        return this == avversario.getStronger();
    }

    public boolean perdeContro(SassoCartaForbice avversario) {
        return this == avversario.getWeaker();
    }

    private SassoCartaForbice getStronger() {
        return switch (this) {
            case SASSO -> CARTA;
            case CARTA -> FORBICE;
            case FORBICE -> SASSO;
        };
    }

    private SassoCartaForbice getWeaker() {
        return switch (this) {
            case SASSO -> FORBICE;
            case CARTA -> SASSO;
            case FORBICE -> CARTA;
        };
    }
}

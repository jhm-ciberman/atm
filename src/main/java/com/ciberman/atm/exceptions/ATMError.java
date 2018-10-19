package com.ciberman.atm.exceptions;

public class ATMError extends RuntimeException {

    private String title;
    private String description;

    ATMError() {
        this.title = "No se pudo completar la operación";
        this.description = "";
    }

    ATMError(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ATMError(Throwable e) {
        this.title = "No se pudo completar la operación";
        this.description = e.getMessage();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String redirect() {
        return "";
    }
}

package com.example.tasbeehcountere;

public class Tasbeeh {

    private String date;
    private String countKalma;
    private String countDarud;
    private String countAstigfar;

    public Tasbeeh(String date, String countKalma, String countDarud, String countAstigfar) {
        this.date = date;
        this.countKalma = countKalma;
        this.countDarud = countDarud;
        this.countAstigfar = countAstigfar;
    }

    public Tasbeeh(String countKalma, String countDarud, String countAstigfar) {
        this.countKalma = countKalma;
        this.countDarud = countDarud;
        this.countAstigfar = countAstigfar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountKalma() {
        return countKalma;
    }

    public void setCountKalma(String countKalma) {
        this.countKalma = countKalma;
    }

    public String getCountDarud() {
        return countDarud;
    }

    public void setCountDarud(String countDarud) {
        this.countDarud = countDarud;
    }

    public String getCountAstigfar() {
        return countAstigfar;
    }

    public void setCountAstigfar(String countAstigfar) {
        this.countAstigfar = countAstigfar;
    }
}

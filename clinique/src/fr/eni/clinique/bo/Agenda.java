package fr.eni.clinique.bo;


import java.util.Date;

public class Agenda {

    /**
     * Attributs
     */
    private int codeVeto;
    private Date dateRdv;
    private int codeAnimal;

    /**
     * Constructeur
     * @param codeVeto
     * @param dateRdv
     * @param codeAnimal
     */
    public Agenda(int codeVeto, Date dateRdv, int codeAnimal) {
        this.codeVeto = codeVeto;
        this.dateRdv = dateRdv;
        this.codeAnimal = codeAnimal;
    }

    /*
    INUTILE POUR LE MOMENT

    public Agenda(){

    }
    */

    /**
     * GETTERS AND SETTERS
     * (@return)
     */

    public int getCodeVeto() {
        return this.codeVeto;
    }

    public void setCodeVeto(int codeVeto) {
        this.codeVeto = codeVeto;
    }

    public Date getDateRdv() {
        return this.dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public int getCodeAnimal() {
        return this.codeAnimal;
    }

    public void setCodeAnimal(int codeAnimal) {
        this.codeAnimal = codeAnimal;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Agendas{" +
                "CodeVeto=" + this.codeVeto +
                ", DateRdv=" + this.dateRdv +
                ", CodeAnimal=" + this.codeAnimal +
                '}';
    }
}
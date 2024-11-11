/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sighorta;

/**
 *
 * @author giuli
 */
public class cultivarData {
    private int cultivar_id;
    private String cultivar_nomepopular;
    private String cultivar_nomecientifico;
    private int cultivar_diasatecolheita;
    
    public cultivarData(int cultivar_id, String cultivar_nomepopular, String cultivar_nomecientifico, int cultivar_diasatecolheita){
        this.cultivar_id = cultivar_id;
        this.cultivar_nomepopular = cultivar_nomepopular;
        this.cultivar_nomecientifico = cultivar_nomecientifico;
        this.cultivar_diasatecolheita = cultivar_diasatecolheita;    
    }

    public int getCultivar_id() {
        return cultivar_id;
    }

    public void setCultivar_id(int cultivar_id) {
        this.cultivar_id = cultivar_id;
    }

    public String getCultivar_nomepopular() {
        return cultivar_nomepopular;
    }

    public void setCultivar_nomepopular(String cultivar_nomepopular) {
        this.cultivar_nomepopular = cultivar_nomepopular;
    }

    public String getCultivar_nomecientifico() {
        return cultivar_nomecientifico;
    }

    public void setCultivar_nomecientifico(String cultivar_nomecientifico) {
        this.cultivar_nomecientifico = cultivar_nomecientifico;
    }

    public int getCultivar_diasatecolheita() {
        return cultivar_diasatecolheita;
    }

    public void setCultivar_diasatecolheita(int cultivar_diasatecolheita) {
        this.cultivar_diasatecolheita = cultivar_diasatecolheita;
    }
    
}

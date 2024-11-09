/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sighorta;

import java.sql.Date;

/**
 *
 * @author giuli
 */
public class plantioData {
    private int plantio_id;
    private String plantio_cultivar;
    private String plantio_localizacao;
    private Date plantio_dataplantio;
    private Date plantio_datacolheita;
    private String plantio_estado;
    
    public plantioData(int plantio_id, String plantio_cultivar, String plantio_localizacao, 
         Date plantio_dataplantio, Date plantio_datacolheita){
        this.plantio_id = plantio_id;
        this.plantio_cultivar = plantio_cultivar;
        this.plantio_localizacao = plantio_localizacao;
        this.plantio_dataplantio = plantio_dataplantio;
        this.plantio_datacolheita = plantio_datacolheita;
    }
    
    public int getPlantio_id() {
        return plantio_id;
    }

    public void setPlantio_id(int plantio_id) {
        this.plantio_id = plantio_id;
    }

    public String getPlantio_cultivar() {
        return plantio_cultivar;
    }

    public void setPlantio_cultivar(String plantio_cultivar) {
        this.plantio_cultivar = plantio_cultivar;
    }

    public String getPlantio_localizacao() {
        return plantio_localizacao;
    }

    public void setPlantio_localizacao(String plantio_localizacao) {
        this.plantio_localizacao = plantio_localizacao;
    }

    public Date getPlantio_dataplantio() {
        return plantio_dataplantio;
    }

    public void setPlantio_dataplantio(Date plantio_dataplantio) {
        this.plantio_dataplantio = plantio_dataplantio;
    }

    public Date getPlantio_datacolheita() {
        return plantio_datacolheita;
    }

    public void setPlantio_datacolheita(Date plantio_datacolheita) {
        this.plantio_datacolheita = plantio_datacolheita;
    }

    public String getPlantio_estado() {
        return plantio_estado;
    }

    public void setPlantio_estado(String plantio_estado) {
        this.plantio_estado = plantio_estado;
    }
    
    
}

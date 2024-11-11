/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sighorta;

/**
 *
 * @author giuli
 */
public class localizacaoData {
    private int localizacao_id;
    private String localizacao_descricao;
    private int localizacao_coluna;
    private int localizacao_linha;
    
    public localizacaoData(int localizacao_id, String localizacao_descricao, int localizacao_coluna, int localizacao_linha){
        this.localizacao_id = localizacao_id;
        this.localizacao_descricao = localizacao_descricao;
        this.localizacao_coluna = localizacao_coluna;
        this.localizacao_linha = localizacao_linha;    
    }

    public int getLocalizacao_id() {
        return localizacao_id;
    }

    public void setLocalizacao_id(int localizacao_id) {
        this.localizacao_id = localizacao_id;
    }

    public String getLocalizacao_descricao() {
        return localizacao_descricao;
    }

    public void setLocalizacao_descricao(String localizacao_descricao) {
        this.localizacao_descricao = localizacao_descricao;
    }

    public int getLocalizacao_coluna() {
        return localizacao_coluna;
    }

    public void setLocalizacao_coluna(int localizacao_coluna) {
        this.localizacao_coluna = localizacao_coluna;
    }

    public int getLocalizacao_linha() {
        return localizacao_linha;
    }

    public void setLocalizacao_linha(int localizacao_linha) {
        this.localizacao_linha = localizacao_linha;
    }

            
}

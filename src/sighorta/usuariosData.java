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
public class usuariosData {
    private int usuarios_id ;
    private String usuarios_nome;
    private String usuarios_email;
    private String usuarios_senha;
    private String usuarios_tipo;
    
    public usuariosData(int usuarios_id, String usuarios_nome, String usuarios_email, String usuarios_tipo){
        this.usuarios_id = usuarios_id;
        this.usuarios_nome = usuarios_nome;
        this.usuarios_email = usuarios_email;
        this.usuarios_tipo = usuarios_tipo;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getUsuarios_nome() {
        return usuarios_nome;
    }

    public void setUsuarios_nome(String usuarios_nome) {
        this.usuarios_nome = usuarios_nome;
    }

    public String getUsuarios_email() {
        return usuarios_email;
    }

    public void setUsuarios_email(String usuarios_email) {
        this.usuarios_email = usuarios_email;
    }

    public String getUsuarios_senha() {
        return usuarios_senha;
    }

    public void setUsuarios_senha(String usuarios_senha) {
        this.usuarios_senha = usuarios_senha;
    }

    public String getUsuarios_tipo() {
        return usuarios_tipo;
    }

    public void setUsuarios_tipo(String usuarios_tipo) {
        this.usuarios_tipo = usuarios_tipo;
    }

    
}

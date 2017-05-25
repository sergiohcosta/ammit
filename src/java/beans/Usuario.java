package beans;

import java.io.Serializable;
import java.text.ParseException;

/**
 *
 * @author sergio
 */
public class Usuario implements Serializable {

    public Usuario() {

    }

    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int pessoaId) {
        this.id = pessoaId;
    }

    private String nome = "";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String email = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String senha = "";

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String perfil = "";

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    private boolean situacao = true;

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    private byte[] salt;

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
    private byte[] pwd;

    public byte[] getPwd() {
        return pwd;
    }

    public void setPwd(byte[] pwd) {
        this.pwd = pwd;
    }
    
}

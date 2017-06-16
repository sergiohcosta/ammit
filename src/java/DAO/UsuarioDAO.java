package DAO;

import beans.Usuario;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Utilidades.PasswordEncryptionService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UsuarioDAO {

    private Connection con = null;
    private PreparedStatement stmtListar, stmtListarProfessor;
    private PreparedStatement stmtAtualizar, stmtAtualizarManterSenha;
    private PreparedStatement stmtObtemUsuario;
    private PreparedStatement stmtObtemUsuarioByEmail;
    private PreparedStatement stmtInserir;
    private PreparedStatement stmtAlteraSituacao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        con = ConnectionFactory.getConnection();

        stmtListar = con.prepareStatement(
                "SELECT * FROM usuario"
        );

        stmtListarProfessor = con.prepareStatement(
                "SELECT * FROM usuario WHERE perfil='Professor'"
        );

        stmtAtualizar = con.prepareStatement(
                "UPDATE usuario SET "
                + "nome = ?"
                + ",email = ?"
                + ",perfil = ?"
                + ",situacao = ?"
                + ",pwd = ?"
                + ",salt = ?"
                + " WHERE id = ?"
        );

        stmtAtualizarManterSenha = con.prepareStatement(
                "UPDATE usuario SET "
                + "nome = ?"
                + ",email = ?"
                + ",perfil = ?"
                + ",situacao = ?"
                + " WHERE id = ?"
        );
        stmtObtemUsuario = con.prepareStatement(
                "SELECT * FROM usuario WHERE id=?"
        );

        stmtObtemUsuarioByEmail = con.prepareStatement(
                "SELECT * FROM usuario WHERE email=?"
        );

        stmtInserir = con.prepareStatement(
                "INSERT INTO usuario ("
                + "nome, email, perfil, situacao, salt, pwd"
                + ") VALUES ("
                + "?, ?, ?, ?, ?, ?"
                + ")"
        );

        stmtAlteraSituacao = con.prepareStatement(
                "UPDATE usuario SET situacao = ? WHERE id=?"
        );
    }

    public List<Usuario> listarUsuarios() throws SQLException {

        List<Usuario> listaUsuarios = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Usuario c = new Usuario();
            c.setId(rs1.getInt("id"));
            c.setNome(rs1.getString("nome"));
            c.setEmail(rs1.getString("email"));
            c.setPerfil(rs1.getString("perfil"));
            c.setSituacao(rs1.getBoolean("situacao"));

            listaUsuarios.add(c);

        }

        return listaUsuarios;

    }

    public List<Usuario> listarProfessores() throws SQLException {

        List<Usuario> listaUsuarios = new ArrayList<>();

        ResultSet rs1 = stmtListar.executeQuery();

        while (rs1.next()) {
            Usuario c = new Usuario();
            c.setId(rs1.getInt("id"));
            c.setNome(rs1.getString("nome"));
            c.setEmail(rs1.getString("email"));
            c.setPerfil(rs1.getString("perfil"));
            c.setSituacao(rs1.getBoolean("situacao"));

            listaUsuarios.add(c);

        }

        return listaUsuarios;

    }

    public int alteraUsuario(Usuario c)
            throws SQLException, ParseException, NoSuchAlgorithmException, InvalidKeySpecException {

        PasswordEncryptionService PES = new PasswordEncryptionService();

        if (c.getSenha() != "") {
            
            /*  "UPDATE usuario SET "
               1 + "nome = ?"
               2 + ",email = ?"
               3 + ",perfil = ?"
               4 + ",situacao = ?"
               5 + ",pwd = ?"
               6 + ",salt = ?"
               7 + " WHERE id = ?"  */
            
            byte[] salt = PES.generateSalt();
            byte[] pwd = PES.getEncryptedPassword(c.getSenha(), salt);
            stmtAtualizar.setString(1, c.getNome());
            stmtAtualizar.setString(2, c.getEmail());
            stmtAtualizar.setString(3, c.getPerfil());
            stmtAtualizar.setBoolean(4, c.isSituacao());
            stmtAtualizar.setBytes(5, pwd);
            stmtAtualizar.setBytes(6, salt);
            stmtAtualizar.setInt(7, c.getId());

            System.out.println(stmtAtualizar);
            return stmtAtualizar.executeUpdate();
        } else {
            
        /*  UPDATE usuario SET "
               1 + "nome = ?"
               2 + ",email = ?"
               3 + ",perfil = ?"
               4 + ",situacao = ?"
               5 + " WHERE id = ?"  */
            stmtAtualizarManterSenha.setString(1, c.getNome());
            stmtAtualizarManterSenha.setString(2, c.getEmail());
            stmtAtualizarManterSenha.setString(3, c.getPerfil());
            stmtAtualizarManterSenha.setBoolean(4, c.isSituacao());
            stmtAtualizarManterSenha.setInt(4, c.getId());
            
            System.out.println(stmtAtualizarManterSenha);
            return stmtAtualizarManterSenha.executeUpdate();
        }

    }

    public Usuario obtemUsuario(int id) throws SQLException {

        stmtObtemUsuario.setInt(1, id);

        System.out.println(stmtObtemUsuario);

        ResultSet rs1 = stmtObtemUsuario.executeQuery();

        Usuario f = null;

        if (rs1.next()) {
            f = new Usuario();
            f.setId(rs1.getInt("id"));
            f.setPerfil(rs1.getString("perfil"));
            f.setNome(rs1.getString("nome"));
            f.setEmail(rs1.getString("email"));
            f.setSituacao(rs1.getBoolean("situacao"));
        }

        return f;
    }

    public void insereUsuario(Usuario c)
            throws SQLException, ParseException, NoSuchAlgorithmException, InvalidKeySpecException {
        // INSERT INTO usuario (nome, email, perfil, situacao, salt, pwd)
        // VALUES              (1,    2,     3,      4,        5,    6 )

        String senha = c.getSenha();

        PasswordEncryptionService PES = new PasswordEncryptionService();
        byte[] salt = PES.generateSalt();
        byte[] pwd = PES.getEncryptedPassword(senha, salt);

        stmtInserir.setString(1, c.getNome());
        stmtInserir.setString(2, c.getEmail());
        stmtInserir.setString(3, c.getPerfil());
        stmtInserir.setBoolean(4, c.isSituacao());
        stmtInserir.setBytes(5, salt);
        stmtInserir.setBytes(6, pwd);

        System.out.println(stmtInserir);

        stmtInserir.executeUpdate();

    }

    public void alteraSituacao(int pId) throws SQLException {

        Usuario f = obtemUsuario(pId);
        boolean s = f.isSituacao();
        s = !s;

        // "UPDATE usuario SET situacao = ? WHERE id=?"
        //                                    1          2
        stmtAlteraSituacao.setBoolean(1, s);
        stmtAlteraSituacao.setInt(2, pId);

        System.out.println(stmtAlteraSituacao);

        stmtAlteraSituacao.executeUpdate();
    }

    /*
   * metodo autenticar
   * params: String email, String senha
   * cruza os dados do usuário usando PasswordEcryptionService
   * retorna um objeto usuário com dados válidos ou um usuário invalido com id -1
     */
    public Usuario autenticar(String email, String senha) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {

        Usuario f;
        f = obtemUsuarioByEmail(email);

        if (f.getId() != -1) {//se nao achou nao interessa

            PasswordEncryptionService PES = new PasswordEncryptionService();
            byte[] salt = f.getSalt();
            byte[] pwd = f.getPwd();

            if (!PES.authenticate(senha, pwd, salt)) {
                f.setId(-1);
            }

        }

        return f;

    }

    private Usuario obtemUsuarioByEmail(String email) throws SQLException {

        stmtObtemUsuarioByEmail.setString(1, email);

        ResultSet rs1 = stmtObtemUsuarioByEmail.executeQuery();

        Usuario f = new Usuario();

        if (rs1.next()) {
            f.setId(rs1.getInt("id"));
            f.setPerfil(rs1.getString("perfil"));
            f.setNome(rs1.getString("nome"));
            f.setEmail(rs1.getString("email"));
            f.setSalt(rs1.getBytes("salt"));
            f.setPwd(rs1.getBytes("pwd"));
        } else {
            f.setId(-1);
        }

        return f;
    }

}

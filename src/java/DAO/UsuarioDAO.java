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
  private PreparedStatement stmtListar;
  private PreparedStatement stmtAtualizar;
  private PreparedStatement stmtObtemUsuario;
  private PreparedStatement stmtObtemUsuarioByEmail;
  private PreparedStatement stmtInserir;
  private PreparedStatement stmtAlteraSituacao;

  public UsuarioDAO() throws SQLException, ClassNotFoundException {
    con = ConnectionFactory.getConnection();

    stmtListar = con.prepareStatement(
            "SELECT * FROM usuario"
    );
    stmtAtualizar = con.prepareStatement(
            "UPDATE usuario SET "
            + "nome = ?"
            + ",email = ?"
            + ",cpf = ?"
            + ",crm = ?"
            + ",senha = ?"
            + ",perfil = ?"
            + ",situacao = ?"
            + ",endereco = ?"
            + ",telefone = ?"
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
            + "nome, email, senha, perfil, situacao, salt, pwd"
            + ") VALUES ("
            + "?, ?, ?, ?, ?, ?, ?"
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

  public int alteraUsuario(Usuario c) throws SQLException {
    /* 1 nome = ?"
     2 + ",email = ?"
     3 + ",cpf = ?"
     4 + ",crm = ?"
     5 + ",senha = ?"
     6 + ",perfil = ?"
     7 + ",situacao = ?"
     8+ ",endereco = ?"
     9+ ",telefone = ?"
     10+ " WHERE id = ?" */

    stmtAtualizar.setString(1, c.getNome());
    stmtAtualizar.setString(2, c.getEmail());
    stmtAtualizar.setString(5, c.getSenha());
    stmtAtualizar.setString(6, c.getPerfil());
    stmtAtualizar.setBoolean(7, c.isSituacao());
    stmtAtualizar.setInt(10, c.getId());

    System.out.println(stmtAtualizar);

    return stmtAtualizar.executeUpdate();

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
      f.setSenha(rs1.getString("senha"));
      f.setSituacao(rs1.getBoolean("situacao"));
    }

    return f;
  }

  public void insereUsuario(Usuario c) throws SQLException, ParseException, NoSuchAlgorithmException, InvalidKeySpecException {
        // INSERT INTO usuario (nome, email, senha, perfil, situacao, salt, pwd)
    // VALUES                  (1,    2,     3,     4,      5,        6,    7  )

    String senha = c.getSenha();

    PasswordEncryptionService PES = new PasswordEncryptionService();
    byte[] salt = PES.generateSalt();
    byte[] pwd = PES.getEncryptedPassword(senha, salt);

    stmtInserir.setString(1, c.getNome());
    stmtInserir.setString(2, c.getEmail());
    stmtInserir.setString(5, senha);
    stmtInserir.setString(6, c.getPerfil());
    stmtInserir.setBoolean(7, c.isSituacao());
    stmtInserir.setBytes(10, salt);
    stmtInserir.setBytes(11, pwd);

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

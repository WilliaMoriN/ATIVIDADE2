package jdbcactivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conector {
    private Connection conexao;
    
    public Connection getConexao(){
        return conexao;
    }
    
    public void conectar() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11","root","root");
            System.out.println("SUCESSO DE CONEXÃO!");
        }catch(ClassNotFoundException e){
            System.out.println("Falha ao carregar a classe de conexão!");
        }catch(SQLException ex){
            System.out.println("Falha ao conectar com o banco. Erro de SQL!");
        }
    }
    
    public void desconectar(){
        try{
            if(conexao != null && !conexao.isClosed())
            {
                conexao.close();
                System.out.println("DESCONECTADO COM SUCESSO");
            }
        }catch(SQLException e){
            System.out.println("Erro ao desconectar");
        }
    }
}
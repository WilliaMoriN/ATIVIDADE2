package jdbcactivity;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ProdutoDAO {
    public static boolean CadastrarProduto(Produto p) throws SQLException{
        try{
            Conector conexao = new Conector();
            conexao.conectar();
            String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, p.getNome());
            query.setDouble(2, p.getValor());
            query.setString(3, p.getStatus());
            query.execute();
            conexao.desconectar();
            return true;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar registro no banco de dados" + se);
            return false;
        }
    }
    
    public static List<Produto> listarTabela(){
        List<Produto> Listar = new ArrayList<Produto>();
        try{
            Conector conexao = new Conector();
            conexao.conectar();
            String sql = "SELECT * FROM Produtos;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();
            while(resposta.next()){
                Produto p = new Produto();
                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("Nome"));
                p.setValor(resposta.getDouble("Valor"));
                p.setStatus(resposta.getString("Status"));
                
                Listar.add(p);
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao mostrar os dados na lista..." + se);
        }
        return Listar;
    }
    
    public static boolean AtualizarProduto(Produto p){
        try{
            Conector conexao = new Conector();
            conexao.conectar();
            String sql = "UPDATE Produtos SET nome=?, valor=?, status=? WHERE id=?;";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, p.getNome());
            query.setDouble(2, p.getValor());
            query.setString(3, p.getStatus());
            query.setInt(4, p.getId());
            query.execute();
            conexao.desconectar();            
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao buscar o registro do banco de dados");
            return false;
        }
    }
    
    public static List<Produto> listarProdutoVendido(){
        List<Produto> ListarPVendido = new ArrayList<Produto>();
        try{
            Conector conexao = new Conector();
            conexao.conectar();
            String sql = "Select * From Produtos where Status = \"Vendido\";";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();
            while(resposta.next()){
                Produto p = new Produto();
                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("Nome"));
                p.setValor(resposta.getDouble("Valor"));
                p.setStatus(resposta.getString("Status"));
                
                ListarPVendido.add(p);
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao mostrar os dados na lista..." + se);
        }
        return ListarPVendido;
    }
}
package jdbcactivity;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
}

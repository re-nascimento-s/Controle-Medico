package controlemedico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void adicionarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nome, cpf, endereco, consulta, id_consulta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getEndereco());
            stmt.setString(4, paciente.getConsulta());
            stmt.setString(5, paciente.getIdConsulta());
            stmt.executeUpdate();
        }
    }
public void atualizarPaciente(Paciente paciente) throws SQLException {
    String sql = "UPDATE pacientes SET nome = ?, cpf = ?, endereco = ?, consulta = ?, id_consulta = ?, status = ? WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, paciente.getNome());
        stmt.setString(2, paciente.getCpf());
        stmt.setString(3, paciente.getEndereco());
        stmt.setString(4, paciente.getConsulta());
        stmt.setString(5, paciente.getIdConsulta());
        stmt.setString(6, paciente.getStatus());
        stmt.setInt(7, paciente.getId()); // Certifique-se de passar o ID corretamente
        stmt.executeUpdate();
    }
}
    public List<Paciente> listarPacientes() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setConsulta(rs.getString("consulta"));
                p.setIdConsulta(rs.getString("id_consulta"));
                p.setStatus(rs.getString("status"));
                pacientes.add(p);
            }
        }
        return pacientes;
    }

    public void atualizarStatus(int id, String novoStatus) throws SQLException {
        String sql = "UPDATE pacientes SET status = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

public void excluirPaciente(int id) throws SQLException {
    String sql = "DELETE FROM pacientes WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id); // O ID do paciente a ser excluído
        stmt.executeUpdate();
    }
}
}

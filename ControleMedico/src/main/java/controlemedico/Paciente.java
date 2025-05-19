package controlemedico;

public class Paciente {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String consulta;
    private String idConsulta;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getConsulta() { return consulta; }
    public void setConsulta(String consulta) { this.consulta = consulta; }

    public String getIdConsulta() { return idConsulta; }
    public void setIdConsulta(String idConsulta) { this.idConsulta = idConsulta; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

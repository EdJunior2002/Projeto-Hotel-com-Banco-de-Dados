package entidades;

public class Reserva {
    
    private String cpf;
    private String nome;
    private String datanascimento;
    private String telefone;
    private String email;
    private String datainicio;
    private String datafim;
    private String tipoquarto;
    private String tipagamento;
    
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }
    public String getDatafim() {
        return datafim;
    }
    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }
    public String getTipoquarto() {
        return tipoquarto;
    }
    public void setTipoquarto(String tipoquarto) {
        this.tipoquarto = tipoquarto;
    }
    public String getTipagamento() {
        return tipagamento;
    }
    public void setTipagamento(String tipagamento) {
        this.tipagamento = tipagamento;
    }

}

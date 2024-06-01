package entidades;

import java.math.BigDecimal;

public class Quarto {
    
    private int idQuartos;
    private String tipoquarto;
    private BigDecimal valorquarto;
    private int quantidade;

    public int getIdQuartos() {
        return idQuartos;
    }

    public void setIdQuartos(int idQuartos) {
        this.idQuartos = idQuartos;
    }

    public String getTipoquarto() {
        return tipoquarto;
    }

    public void setTipoquarto(String tipoquarto) {
        this.tipoquarto = tipoquarto;
    }

    public BigDecimal getValorquarto() {
        return valorquarto;
    }

    public void setValorquarto(BigDecimal valorquarto) {
        this.valorquarto = valorquarto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
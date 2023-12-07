import java.util.Date;

class Fatura {
    private Date data;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valor;
    private boolean quitada;

    public Fatura(Imovel imovelAssociadoFatura) {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(double ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setPenultimaLeitura(double penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }

    public double getValor() {
        return valor;
    }

    public boolean isQuitada() {
        return quitada;
    }

    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }

    public void setValor(double valorFatura) {
    }

    public Object getImovelAssociado() {
        return null;
    }

    public void adicionarPagamento(Pagamento novoPagamento) {
    }
}

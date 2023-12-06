import java.util.Date;
class Reparo {
    private String descricaoAtividade;
    private Date previsao;
    private Date dataInicio;
    private Date dataFim;
    private boolean resolvido;
    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }
    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }
    public Date getPrevisao() {
        return previsao;
    }
    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public boolean isResolvido() {
        return resolvido;
    }
    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
}


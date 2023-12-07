import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void criarReparo() throws ParseException {
        System.out.print("Informe a descrição da falha:");
        this.descricaoAtividade = Main.ler().nextLine();

        System.out.print("Digite a data prevista:");
        String dprevista = Main.ler().nextLine();
        this.previsao = new SimpleDateFormat("dd/MM/yyyy").parse(dprevista);

        System.out.print("Digite a data de inicio:");
        String dinicio = Main.ler().nextLine();
        this.dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dinicio);

        System.out.print("Digite a data de fim:");
        String dfim = Main.ler().nextLine();
        this.dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(dfim);

        System.out.print("Reparo resolvido? (s/n):");
        boolean resolvido = Main.ler().nextBoolean();
    }
}


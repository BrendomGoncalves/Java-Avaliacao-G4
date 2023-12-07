import java.util.ArrayList;

class Imovel {
    private String matricula;
    private String endereco;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private ArrayList<Fatura> faturas;
    private ArrayList<Pagamento> pagamentos;

    Imovel() {
        this.faturas = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    public void realizarLeitura() {
        this.penultimaLeitura = this.ultimaLeitura;
        System.out.println("Digite a leitura atual: ");
        this.ultimaLeitura = Main.ler().nextDouble();
    }
    public void adicionarFatura(Fatura fatura) {
        this.faturas.add(fatura);
    }
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
    public void toString(){
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Ultima leitura: " + this.ultimaLeitura);
        System.out.println("Penultima leitura: " + this.penultimaLeitura);
    }
    public void imprimeFaturas(){
        for(Fatura fatura : this.faturas){
            System.out.println(fatura.toString());
        }
    }
    public void imprimePagamentos()
    {
        for(Pagamento pagamento : this.pagamentos){
            System.out.println(pagamento.toString());
        }
    }
    public boolean realizarPagamento(){
        Pagamento novoP = new Pagamento();
        System.out.print("Digite o valor do pagamento: ");
        double valorPagamento = Main.ler().nextDouble();
        novoP.setValor(valorPagamento);
        novoP.setData(new java.util.Date());
        this.pagamentos.add(novoP);
        for(Fatura fatura : this.faturas) {
            if (!fatura.isQuitada()) {
                if (valorPagamento >= fatura.getValor()) {
                    fatura.setQuitada(true);
                    valorPagamento -= fatura.getValor();
                    if (valorPagamento == 0) {
                        return true;
                    }
                } else {
                    System.out.println("Valor do pagamento insuficiente.");
                    return false;
                }
            }
        }
    }
}

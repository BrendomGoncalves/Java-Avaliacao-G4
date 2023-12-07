import java.util.ArrayList;
import java.util.List;

class CoelhoEnergia {
    private ArrayList<Cliente> clientes;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Fatura> faturas;
    private ArrayList<Pagamento> pagamentos;
    private ArrayList<Falha> falhas;

    public CoelhoEnergia() {
        clientes = new ArrayList<>();
        imoveis = new ArrayList<>();
        faturas = new ArrayList<>();
        pagamentos = new ArrayList<>();
        falhas = new ArrayList<>();
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public List<Imovel> getImoveis(){
        return imoveis;
    }
    public void visualizarFalhas() {
        for (Falha falha : falhas) {
            System.out.println(falha);
        }
    }
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }
    public Imovel buscarImovelPorMatricula(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                return imovel;
            }
        }
        return null;
    }
    public void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
    }
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
    public void visualizarPagamentosPorImovel(String matriculaImovel) {
        Imovel imovelAssociado = buscarImovelPorMatricula(matriculaImovel);

        if (imovelAssociado != null) {
            System.out.println("Pagamentos associados ao imóvel (Matrícula: " + imovelAssociado.getMatricula() + "):");
            for (Pagamento pagamento : pagamentos) {

                System.out.println("Data: " + pagamento.getData() + ", Valor: " + pagamento.getValor());
            }
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }
    public void adicionarFalha(Falha falha) {
        falhas.add(falha);
    }
    public void removerImovel(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                imoveis.remove(imovel);
                return;
            }
        }
    }
}

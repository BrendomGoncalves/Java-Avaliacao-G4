import java.util.ArrayList;

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
      System.out.println(
        "Pagamentos associados ao imóvel (Matrícula: " +
        imovelAssociado.getMatricula() +
        "):"
      );
      for (Pagamento pagamento : pagamentos) {
        if (
          pagamento.getImovelAssociado() != null &&
          pagamento.getImovelAssociado().equals(imovelAssociado)
        ) {
          System.out.println(
            "Data: " + pagamento.getData() + ", Valor: " + pagamento.getValor()
          );
        }
      }
    } else {
      System.out.println("Imóvel não encontrado.");
    }
  }

  public void adicionarFalha(Falha falha) {
    falhas.add(falha);
  }

  public Fatura[] getFaturas() {
    return null;
  }

  public Pagamento[] getPagamentos() {
    return null;
  }
}

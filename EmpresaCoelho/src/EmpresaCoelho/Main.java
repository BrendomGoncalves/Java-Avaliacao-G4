import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CoelhoEnergia coelhoEnergia = new CoelhoEnergia();

    while (true) {
      System.out.println("Menu Principal:");
      System.out.println("1. Gestão de Clientes");
      System.out.println("2. Gestão de Imóveis");
      System.out.println("3. Gestão de Faturas");
      System.out.println("4. Gestão de Pagamentos");
      System.out.println("5. Visualizar Pagamentos por Imóvel");
      System.out.println("0. Sair");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Menu de Gestão de Clientes:");
          System.out.println("1. Adicionar Cliente");
          System.out.println("2. Buscar Cliente por CPF");
          System.out.println("3. Voltar ao Menu Principal");

          int clienteChoice = scanner.nextInt();
          scanner.nextLine();

          switch (clienteChoice) {
            case 1:
              System.out.println("Informe o CPF do cliente:");
              String cpf = scanner.nextLine();

              if (coelhoEnergia.buscarClientePorCPF(cpf) != null) {
                System.out.println("Cliente com esse CPF já existe.");
              } else {
                System.out.println("Informe o nome do cliente:");
                String nome = scanner.nextLine();

                Cliente novoCliente = new Cliente();
                novoCliente.setCpf(cpf);
                novoCliente.setNome(nome);

                coelhoEnergia.adicionarCliente(novoCliente);
                System.out.println("Cliente adicionado com sucesso!");
              }
              break;
            case 2:
              System.out.println("Informe o CPF do cliente:");
              String cpfBusca = scanner.nextLine();

              Cliente clienteEncontrado = coelhoEnergia.buscarClientePorCPF(
                cpfBusca
              );

              if (clienteEncontrado != null) {
                System.out.println("Cliente encontrado:");
                System.out.println("CPF: " + clienteEncontrado.getCpf());
                System.out.println("Nome: " + clienteEncontrado.getNome());
              } else {
                System.out.println("Cliente não encontrado.");
              }
              break;
            case 3:
              break;
            default:
              System.out.println("Opção inválida. Tente novamente.");
              break;
          }
          break;
        case 2:
          System.out.println("Menu de Gestão de Imóveis:");
          System.out.println("1. Adicionar Imóvel");
          System.out.println("2. Buscar Imóvel por Matrícula");
          System.out.println("3. Voltar ao Menu Principal");

          int imovelChoice = scanner.nextInt();
          scanner.nextLine();

          switch (imovelChoice) {
            case 1:
              System.out.println("Informe a matrícula do imóvel:");
              String matricula = scanner.nextLine();

              if (coelhoEnergia.buscarImovelPorMatricula(matricula) != null) {
                System.out.println("Imóvel com essa matrícula já existe.");
              } else {
                System.out.println("Informe o endereço do imóvel:");
                String endereco = scanner.nextLine();

                Imovel novoImovel = new Imovel();
                novoImovel.setMatricula(matricula);
                novoImovel.setEndereco(endereco);

                coelhoEnergia.adicionarImovel(novoImovel);
                System.out.println("Imóvel adicionado com sucesso!");
              }
              break;
            case 2:
              System.out.println("Informe a matrícula do imóvel:");
              String matriculaBusca = scanner.nextLine();

              Imovel imovelEncontrado = coelhoEnergia.buscarImovelPorMatricula(
                matriculaBusca
              );

              if (imovelEncontrado != null) {
                System.out.println("Imóvel encontrado:");
                System.out.println(
                  "Matrícula: " + imovelEncontrado.getMatricula()
                );
                System.out.println(
                  "Endereço: " + imovelEncontrado.getEndereco()
                );
              } else {
                System.out.println("Imóvel não encontrado.");
              }
              break;
            case 3:
              break;
            default:
              System.out.println("Opção inválida. Tente novamente.");
              break;
          }
          break;
        case 3:
          System.out.println("Menu de Gestão de Faturas:");
          System.out.println("1. Adicionar Fatura");
          System.out.println("2. Pagar Fatura");
          System.out.println("3. Visualizar Faturas");
          System.out.println("4. Voltar ao Menu Principal");

          int faturaChoice = scanner.nextInt();
          scanner.nextLine();

          switch (faturaChoice) {
            case 1:
              System.out.println(
                "Informe a matrícula do imóvel associado à fatura:"
              );
              String matriculaImovelFatura = scanner.nextLine();
              Imovel imovelAssociadoFatura = coelhoEnergia.buscarImovelPorMatricula(
                matriculaImovelFatura
              );

              if (imovelAssociadoFatura != null) {
                System.out.println("Informe a data da fatura (dd/mm/yyyy):");
                String dataString = scanner.nextLine();

                System.out.println("Informe o valor da fatura:");
                double valorFatura = scanner.nextDouble();

                Fatura novaFatura = new Fatura(imovelAssociadoFatura);

                try {
                  novaFatura.setData(
                    new java.sql.Date(
                      new SimpleDateFormat("dd/MM/yyyy")
                        .parse(dataString)
                        .getTime()
                    )
                  );
                } catch (ParseException e) {
                  System.out.println(
                    "Formato de data inválido. Certifique-se de inserir a data no formato dd/MM/yyyy."
                  );
                  break;
                }

                novaFatura.setValor(valorFatura);

                imovelAssociadoFatura.adicionarFatura(novaFatura);

                coelhoEnergia.adicionarFatura(novaFatura);

                System.out.println("Fatura adicionada com sucesso!");
              } else {
                System.out.println("Imóvel não encontrado.");
              }
              break;
            case 2:
              System.out.println(
                "Informe a matrícula do imóvel associado à fatura:"
              );
              String matriculaPagamento = scanner.nextLine();
              Imovel imovelPagamento = coelhoEnergia.buscarImovelPorMatricula(
                matriculaPagamento
              );

              if (imovelPagamento != null) {
                System.out.println("Informe o valor do pagamento:");
                double valorPagamento = scanner.nextDouble();

                Pagamento novoPagamento = new Pagamento();
                novoPagamento.setImovelAssociado(imovelPagamento);
                novoPagamento.setValor(valorPagamento);

                coelhoEnergia.adicionarPagamento(novoPagamento);

                System.out.println("Pagamento realizado com sucesso!");
              } else {
                System.out.println("Imóvel não encontrado.");
              }
              break;
            case 3:
              System.out.println(
                "Informe a matrícula do imóvel para visualizar as faturas:"
              );
              String matriculaVisualizar = scanner.nextLine();
              Imovel imovelVisualizar = coelhoEnergia.buscarImovelPorMatricula(
                matriculaVisualizar
              );

              if (imovelVisualizar != null) {
                System.out.println(
                  "Faturas associadas ao imóvel (Matrícula: " +
                  imovelVisualizar.getMatricula() +
                  "):"
                );
                for (Fatura fatura : imovelVisualizar.getFaturas()) {
                  System.out.println(
                    "Data: " +
                    fatura.getData() +
                    ", Valor: " +
                    fatura.getValor()
                  );
                }
              } else {
                System.out.println("Imóvel não encontrado.");
              }
              break;
            case 4:
              break;
            default:
              System.out.println("Opção inválida. Tente novamente.");
              break;
          }
          break;
        case 4:
          System.out.println("Menu de Gestão de Pagamentos:");
          System.out.println("1. Visualizar Pagamentos por Imóvel");
          System.out.println("2. Voltar ao Menu Principal");

          int pagamentoChoice = scanner.nextInt();
          scanner.nextLine();

          switch (pagamentoChoice) {
            case 1:
              System.out.println(
                "Informe a matrícula do imóvel associado à fatura:"
              );
              String matriculaImovelFatura = scanner.nextLine();
              Imovel imovelAssociadoFatura = coelhoEnergia.buscarImovelPorMatricula(
                matriculaImovelFatura
              );

              if (imovelAssociadoFatura != null) {
                System.out.println("Informe a data da fatura (dd/mm/yyyy):");
                String dataString = scanner.nextLine();

                System.out.println("Informe o valor da fatura:");
                double valorFatura = scanner.nextDouble();

                Fatura novaFatura = new Fatura(imovelAssociadoFatura);

                try {
                  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                  java.util.Date dataFatura = dateFormat.parse(dataString);
                  novaFatura.setData(new java.sql.Date(dataFatura.getTime()));
                } catch (ParseException e) {
                  System.out.println("Formato de data inválido.");
                  break;
                }

                novaFatura.setValor(valorFatura);

                imovelAssociadoFatura.adicionarFatura(novaFatura);

                coelhoEnergia.adicionarFatura(novaFatura);

                System.out.println("Fatura adicionada com sucesso!");
              } else {
                System.out.println("Imóvel não encontrado.");
              }
              break;
            case 2:
              break;
            default:
              System.out.println("Opção inválida. Tente novamente.");
              break;
          }
          break;
        case 5:
          System.out.println(
            "Informe a matrícula do imóvel para visualizar os pagamentos:"
          );
          String matriculaPagamentoVisualizar = scanner.nextLine();
          coelhoEnergia.visualizarPagamentosPorImovel(
            matriculaPagamentoVisualizar
          );
          break;
        case 0:
          System.out.println("Saindo do sistema. Até logo!");
          System.exit(0);
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }
}

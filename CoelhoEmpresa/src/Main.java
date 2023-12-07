import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoelhoEnergia coelhoEnergia = new CoelhoEnergia();

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");
            System.out.print("> ");
            int choice = ler().nextInt();
            ler().nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Menu de Gestão de Clientes:");
                    System.out.println("1. Adicionar Cliente");
                    System.out.println("2. Buscar Cliente por CPF");
                    System.out.println("3. Listar Todos os Clientes");
                    System.out.println("4. Remover Cliente por CPF");
                    System.out.println("5. Alterar Cliente");
                    System.out.println("6. Voltar ao Menu Principal");
                    System.out.print("> ");
                    int clienteChoice = ler().nextInt();

                    switch (clienteChoice) {
                        case 1:
                            System.out.print("Informe o CPF do cliente: ");
                            String cpf = ler().nextLine();

                            if (coelhoEnergia.buscarClientePorCPF(cpf) != null) {
                                System.out.println("Cliente com esse CPF já existe.");
                            } else {
                                System.out.print("Informe o nome do cliente: ");
                                String nome = ler().nextLine();

                                Cliente novoCliente = new Cliente();
                                novoCliente.setCpf(cpf);
                                novoCliente.setNome(nome);

                                coelhoEnergia.adicionarCliente(novoCliente);
                                System.out.println("Cliente adicionado com sucesso!");
                            }
                            break;
                        case 2:
                            System.out.print("Informe o CPF do cliente: ");
                            String cpfBusca = ler().nextLine();

                            Cliente clienteEncontrado = coelhoEnergia.buscarClientePorCPF(cpfBusca);

                            if (clienteEncontrado != null) {
                                System.out.println("Cliente encontrado:");
                                System.out.println("CPF: " + clienteEncontrado.getCpf());
                                System.out.println("Nome: " + clienteEncontrado.getNome());
                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                            break;
                        case 3:
                            System.out.println("Listar Clientes:");
                            if (coelhoEnergia.getClientes().isEmpty()) {
                                System.out.println("Nenhum cliente cadastrado!");
                                break;
                            }
                            for (Cliente cliente : coelhoEnergia.getClientes()) {
                                System.out.println("CPF: " + cliente.getCpf());
                                System.out.println("Nome: " + cliente.getNome());
                            }
                        case 4:
                            System.out.println("Remover Cliente:");
                            if (coelhoEnergia.getClientes().isEmpty()) {
                                System.out.println("Nenhum cliente cadastrado!");
                                break;
                            }
                            System.out.println("Informe o CPF do cliente: ");
                            String cpfRemover = ler().nextLine();

                            for (Cliente c : coelhoEnergia.getClientes()) {
                                if (cpfRemover.equals(c.getCpf())) {
                                    coelhoEnergia.removerCliente(cpfRemover);
                                    System.out.println("Cliente removido com sucesso!");
                                    break;
                                }
                            }
                            System.out.println("Cliente não encontrado!");
                            break;
                        case 5:
                            System.out.println("Alterar Cliente:");
                            System.out.println("Informe o CPF do cliente:");
                            String cpfEditar = ler().nextLine();

                            for (Cliente c : coelhoEnergia.getClientes()) {
                                if (cpfEditar.equals(c.getCpf())) {
                                    System.out.println("Nome atual: " + c.getNome());
                                    System.out.println("Novo nome:");
                                    String novoNome = ler().nextLine();
                                    c.setNome(novoNome);
                                    System.out.println("Nome alterado com sucesso!");
                                    break;
                                }
                            }
                            System.out.println("Cliente não encontrado!");
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Menu de Gestão de Imóveis:");
                    System.out.println("1. Adicionar Imovel");
                    System.out.println("2. Buscar Imóvel por Matrícula");
                    System.out.println("3. Listar Todos os Imoveis");
                    System.out.println("4. Remover Imovel por Matrícula");
                    System.out.println("5. Alterar Imovel");
                    System.out.println("6. Realizar Leitura do Imovel");
                    System.out.println("7. Voltar ao Menu Principal");

                    int imovelChoice = ler().nextInt();

                    switch (imovelChoice) {
                        case 1:
                            System.out.println("Informe a matrícula do imóvel:");
                            String matricula = ler().nextLine();

                            if (coelhoEnergia.buscarImovelPorMatricula(matricula) != null) {
                                System.out.println("Imóvel com essa matrícula já existe.");
                            } else {
                                System.out.println("Informe o endereço do imóvel:");
                                String endereco = ler().nextLine();

                                Imovel novoImovel = new Imovel();
                                novoImovel.setMatricula(matricula);
                                novoImovel.setEndereco(endereco);

                                coelhoEnergia.adicionarImovel(novoImovel);
                                System.out.println("Imóvel adicionado com sucesso!");
                            }
                            break;

                        case 2:
                            System.out.println("Informe a matrícula do imóvel:");
                            String matriculaBusca = ler().nextLine();

                            Imovel imovelEncontrado = coelhoEnergia.buscarImovelPorMatricula(matriculaBusca);

                            if (imovelEncontrado != null) {
                                System.out.println("Imóvel encontrado:");
                                System.out.println("Matrícula: " + imovelEncontrado.getMatricula());
                                System.out.println("Endereço: " + imovelEncontrado.getEndereco());
                            } else {
                                System.out.println("Imóvel não encontrado.");
                            }
                            break;

                        case 3:
                            System.out.println("Listar Imóveis:");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhum imóvel cadastrado!");
                                break;
                            }
                            for (Imovel imovel : coelhoEnergia.getImoveis()) {
                                System.out.println("Matrícula: " + imovel.getMatricula());
                                System.out.println("Endereço: " + imovel.getEndereco());
                            }
                            break;
                        case 4:
                            System.out.println("Remover Imóvel:");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhum imóvel cadastrado!");
                                break;
                            }
                            System.out.println("Informe a matrícula do imóvel:");
                            String matriculaRemover = ler().nextLine();

                            for (Imovel imovel : coelhoEnergia.getImoveis()) {
                                if (matriculaRemover.equals(imovel.getMatricula())) {
                                    coelhoEnergia.removerImovel(matriculaRemover);
                                    System.out.println("Imóvel removido com sucesso!");
                                    break;
                                }
                            }
                            System.out.println("Imóvel não encontrado!");
                            break;
                        case 5:
                            System.out.println("Alterar Imovel:");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhum imóvel cadastrado!");
                                break;
                            }
                            System.out.println("Informe a matrícula do imóvel:");
                            String matriculaAlterar = ler().nextLine();
                            Imovel imovelAlterar = coelhoEnergia.buscarImovelPorMatricula(matriculaAlterar);
                            if (imovelAlterar != null) {
                                System.out.println("Novo endereço:");
                                String novoEndereco = ler().nextLine();
                                imovelAlterar.setEndereco(novoEndereco);
                                System.out.println("Imóvel alterado com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado!");
                            }
                            break;
                        case 6:
                            System.out.println("Realizar Leitura do Imovel:");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhum imóvel cadastrado!");
                                break;
                            }
                            System.out.println("Informe a matrícula do imóvel:");
                            String matriculaLeitura = ler().nextLine();
                            Imovel imovelLeitura = coelhoEnergia.buscarImovelPorMatricula(matriculaLeitura);
                            if (imovelLeitura != null) {
                                imovelLeitura.realizarLeitura();
                                Fatura novaF = new Fatura();
                                novaF.criarFatura(imovelLeitura);
                                coelhoEnergia.adicionarFatura(novaF);
                                System.out.println("Leitura concluída com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado!");
                            }
                            break;
                        case 7:
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

                    int faturaChoice = ler().nextInt();
                    ler().nextLine();

                    switch (faturaChoice) {
                        case 1:
                            System.out.println("Informe a matrícula do imóvel associado à fatura:");
                            String matriculaImovel = ler().nextLine();
                            Imovel imovelAssociado = coelhoEnergia.buscarImovelPorMatricula(matriculaImovel);
                            if (imovelAssociado != null) {
                                System.out.println("Imóvel encontrado:");
                                System.out.println("Matrícula: " + imovelAssociado.getMatricula());
                                System.out.println("Endereço: " + imovelAssociado.getEndereco());
                                Fatura novaFatura = new Fatura();
                                novaFatura.criarFatura(imovelAssociado);
                                coelhoEnergia.adicionarFatura(novaFatura);
                                System.out.println("Fatura adicionada com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado.");
                            }
                            break;
                        case 2:
                            System.out.println("Informe a matrícula do imóvel associado à fatura:");
                            String matriculaPagamento = ler().nextLine();
                            Imovel imovelPagamento = coelhoEnergia.buscarImovelPorMatricula(matriculaPagamento);

                            if (imovelPagamento != null) {
                                System.out.println("Informe o valor do pagamento:");
                                double valorPagamento = ler().nextDouble();
                                Pagamento novoPagamento = new Pagamento();
                                coelhoEnergia.adicionarPagamento(novoPagamento);
                                System.out.println("Pagamento realizado com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado.");
                            }
                            break;

                        case 3:
                            System.out.println("Lista de Faturas: ");
                            if (coelhoEnergia.getFaturas().isEmpty()) {
                                System.out.println("Nenhuma fatura encontrada!");
                                break;
                            }
                            for (Fatura f : coelhoEnergia.getFaturas()) {
                                System.out.println(f.toString());
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

                    int pagamentoChoice = ler().nextInt();
                    ler().nextLine();

                    switch (pagamentoChoice) {
                        case 1:
                            System.out.println("Informe a matrícula do imóvel para visualizar os pagamentos:");
                            String matriculaPagamentoVisualizar = ler().nextLine();
                            coelhoEnergia.visualizarPagamentosPorImovel(matriculaPagamentoVisualizar);
                            break;

                        case 2:
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Menu de Gestão de Falhas:");
                    System.out.println("1. Adicionar Falha");
                    System.out.println("2. Visualizar Falhas");
                    System.out.println("3. Voltar ao Menu Principal");

                    int falhaChoice = ler().nextInt();
                    ler().nextLine();

                    switch (falhaChoice) {
                        case 1:

                            System.out.println("Informe a descrição da falha:");
                            String descricaoFalha = ler().nextLine();

                            Falha novaFalha = new Falha();
                            novaFalha.setDescricao(descricaoFalha);

                            coelhoEnergia.adicionarFalha(novaFalha);
                            System.out.println("Falha adicionada com sucesso!");
                            break;

                        case 2:

                            coelhoEnergia.visualizarFalhas();
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
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

    public static Scanner ler() {
        return new Scanner(System.in);
    }
}
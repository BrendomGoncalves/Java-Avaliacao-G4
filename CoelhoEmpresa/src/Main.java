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
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Menu de Gestão de Clientes:");
                    System.out.println("1. Adicionar Cliente");
                    System.out.println("2. Buscar Cliente por CPF");
                    System.out.println("3. Listar Todos os Clientes");
                    System.out.println("4. Excluir Cliente por CPF");
                    System.out.println("5. Alterar Cliente");
                    System.out.println("6. Voltar ao Menu Principal");

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
                            System.out.println("listar  Clientes:");
                            for (Cliente cliente : coelhoEnergia.getClientes()) {
                                System.out.println("CPF: " + cliente.getCpf());
                                System.out.println("Nome: " + cliente.getNome());
                            }
                        case 4:
                            System.out.println("Exclusão de Clientes:");
                            System.out.println("informe o CPF do cliente:");
                            String cpfExclusão = scanner.nextLine();
                            (coelhoEnergia.buscarClientePorCPF(scanner.nextLine()) != ) {
                                System.out.println("Cliente excluído com sucesso!");

                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                            break;

                        case 5:
                            System.out.println("Alterar de Clientes:");
                            System.out.println("informe o CPF do cliente:");

                            if (coelhoEnergia.buscarClientePorCPF(scanner.nextLine()) != null) {
                                System.out.println("Cliente alterado com sucesso!");

                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
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
                            System.out.println("Informe a matrícula do imóvel associado à fatura:");
                            String matriculaImovel = scanner.nextLine();
                            Imovel imovelAssociado = coelhoEnergia.buscarImovelPorMatricula(matriculaImovel);

                            if (imovelAssociado != null) {
                                // Crie a lógica para obter as informações necessárias e adicionar a fatura


                                Fatura novaFatura = new Fatura();
                                // Preencha os detalhes da fatura
                                // ...

                                coelhoEnergia.adicionarFatura(novaFatura);
                                System.out.println("Fatura adicionada com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado.");
                            }
                            break;

                        case 2:
                            System.out.println("Informe a matrícula do imóvel associado à fatura:");
                            String matriculaPagamento = scanner.nextLine();
                            Imovel imovelPagamento = coelhoEnergia.buscarImovelPorMatricula(matriculaPagamento);

                            if (imovelPagamento != null) {
                                System.out.println("Informe o valor do pagamento:");
                                double valorPagamento = scanner.nextDouble();

                                Pagamento novoPagamento = new Pagamento();

                                coelhoEnergia.adicionarPagamento(novoPagamento);
                                System.out.println("Pagamento realizado com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado.");
                            }
                            break;

                        case 3:
                            System.out.println("Informe a matrícula do imóvel para visualizar as faturas:");
                            String matriculaVisualizar = scanner.nextLine();
                            Imovel imovelVisualizar = coelhoEnergia.buscarImovelPorMatricula(matriculaVisualizar);

                            if (imovelVisualizar != null) {

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
                            System.out.println("Informe a matrícula do imóvel para visualizar os pagamentos:");
                            String matriculaPagamentoVisualizar = scanner.nextLine();
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

                    int falhaChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (falhaChoice) {
                        case 1:

                            System.out.println("Informe a descrição da falha:");
                            String descricaoFalha = scanner.nextLine();

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
}


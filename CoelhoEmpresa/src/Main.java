import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        CoelhoEnergia coelhoEnergia = new CoelhoEnergia();

        while (true) {
            System.out.println("Menu Principal Coelho Energia:");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("0. Sair");
            System.out.print("> ");
            int choice = ler().nextInt();

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
                            break;
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
                    System.out.println("0. Voltar ao Menu Principal");

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
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Menu de Gestão de Faturas:");
                    System.out.println("1. Registro de Consumo");
                    System.out.println("2. Listar Faturas");
                    System.out.println("0. Voltar ao Menu Principal");

                    int faturaChoice = ler().nextInt();
                    ler().nextLine();

                    switch (faturaChoice) {
                        case 1:
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
                                imovelLeitura.adicionarFatura(novaF);
                                System.out.println("Leitura concluída com sucesso!");
                            } else {
                                System.out.println("Imóvel não encontrado!");
                            }
                            break;
                        case 2:
                            System.out.println("Lista de Faturas: ");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhuma Imovel encontrado!");
                                break;
                            }
                            for (Imovel i : coelhoEnergia.getImoveis()) {
                                i.imprimeFaturas();
                                System.out.println();
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Menu de Gestão de Pagamentos:");
                    System.out.println("1. Inclusão de Pagamentos");
                    System.out.println("2. Listar Pagamentos");
                    System.out.println("3. Listar Reembolsos");
                    System.out.println("0. Voltar ao Menu Principal");

                    int pagamentoChoice = ler().nextInt();
                    ler().nextLine();

                    switch (pagamentoChoice) {
                        case 1:
                            System.out.println("Inclusão de Pagamento:");
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhuma imovel encontrado!");
                                break;
                            }
                            System.out.println("Informe a matrícula do imóvel:");
                            String matriculaPagamento = ler().nextLine();
                            Imovel imovelPagamento = coelhoEnergia.buscarImovelPorMatricula(matriculaPagamento);
                            if (imovelPagamento != null) {
                                if (imovelPagamento.realizarPagamento())
                                    System.out.println("Pagamento concluído com sucesso!");
                                else System.out.println("Pagamento não concluido!");
                            } else {
                                System.out.println("Imóvel não encontrado!");
                            }
                            break;
                        case 2:
                            System.out.println("Informe a matrícula do imóvel para visualizar os pagamentos:");
                            String matricula = ler().nextLine();
                            coelhoEnergia.buscarImovelPorMatricula(matricula).imprimePagamentos();
                            break;
                        case 3:
                            if (coelhoEnergia.getImoveis().isEmpty()) {
                                System.out.println("Nenhuma imovel encontrado!");
                                break;
                            }
                            for (Imovel i : coelhoEnergia.getImoveis()) {
                                i.imprimePagamentos();
                                System.out.println();
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Menu de Gestão de Falhas:");
                    System.out.println("1. Adicionar Falha");
                    System.out.println("2. Gestão de Reparos");
                    System.out.println("0. Voltar ao Menu Principal");

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
                            System.out.println("Menu de Gestão de Reparos:");
                            System.out.println("1. Adicionar Reparo");
                            System.out.println("2. Visualizar Reparos");
                            System.out.println("3. Resolver Reparo");
                            System.out.println("0. Voltar ao Menu Principal");

                            int reparoChoice = ler().nextInt();
                            switch (reparoChoice) {
                                case 1:
                                    System.out.println("Adicionar Reparo:");
                                    Reparo novoR = new Reparo();
                                    novoR.criarReparo();
                                    coelhoEnergia.adiconarReparo(novoR);
                                    System.out.println("Reparo adicionado com sucesso!");
                                    break;
                                case 2:
                                    System.out.println("Visualizar Reparos:");
                                    break;
                                case 3:
                                    System.out.println("Resolver Reparo:");
                                    for(int i = 0; i < coelhoEnergia.getReparos().size() - 1; i++){
                                        System.out.print("id: " + i + " - ");
                                        coelhoEnergia.getReparos().get(i).getDescricaoAtividade();
                                    }
                                    System.out.println("\nIndique o ID do Reparo:");
                                    int id = ler().nextInt();
                                    if(id > 0 && id < coelhoEnergia.getReparos().size() - 1){
                                        coelhoEnergia.getReparos().get(id).setResolvido(true);
                                        System.out.println("Reparo resolvido com sucesso!");
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                            break;
                        case 0:
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
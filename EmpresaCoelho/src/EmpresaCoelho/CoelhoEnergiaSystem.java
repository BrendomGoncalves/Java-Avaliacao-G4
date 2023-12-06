package EmpresaCoelho;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CoelhoEnergiaSystem {
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
                                // ...

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

            public void visualizarFalhas() {
            System.out.println("Falhas registradas:");
            for (Falha falha : falhas) {
                System.out.println("Descrição: " + falha.getDescricao());
               
            }
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
    
    
}


class Cliente {
    private String cpf;
    private String nome;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

 }

class Imovel {
    private String matricula;
    private String endereco;
    private double ultimaLeitura;
    private double penultimaLeitura;
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
}

class Fatura {
    private Date data;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valor;
    private boolean quitada;
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
}

class Pagamento {
    private Date data;
    private double valor;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}    
}

class Falha {
    private String descricao;
    private Date previsao;
    private Date dataInicio;
    private Date dataFim;
    private boolean resolvido;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

class FalhaGeracao extends Falha {
    private String atributoEspecificoGeracao;

    public String getAtributoEspecificoGeracao() {
        return atributoEspecificoGeracao;
    }

    public void setAtributoEspecificoGeracao(String atributoEspecificoGeracao) {
        this.atributoEspecificoGeracao = atributoEspecificoGeracao;
    }
}

class FalhaDistribuicao extends Falha {
    private String atributoEspecificoDistribuicao;

    public String getAtributoEspecificoDistribuicao() {
        return atributoEspecificoDistribuicao;
    }

    public void setAtributoEspecificoDistribuicao(String atributoEspecificoDistribuicao) {
        this.atributoEspecificoDistribuicao = atributoEspecificoDistribuicao;
    }
}


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

class Reembolso {
    private Date data;
    private double valor;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}    
}


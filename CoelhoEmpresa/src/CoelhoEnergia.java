import java.util.ArrayList;

class CoelhoEnergia {
    private ArrayList<Cliente> clientes;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Falha> falhas;
    private ArrayList<Reparo> reparos;

    public CoelhoEnergia() {
        clientes = new ArrayList<>();
        imoveis = new ArrayList<>();
        falhas = new ArrayList<>();
        reparos = new ArrayList<>();
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Imovel> getImoveis(){
        return imoveis;
    }
    public ArrayList<Falha> getFalhas(){
        return falhas;
    }
    public ArrayList<Reparo> getReparos(){
        return reparos;
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
    public void adicionarFalha(Falha falha) {
        falhas.add(falha);
    }
    public void adiconarReparo(Reparo reparo) {
        reparos.add(reparo);
    }
    public void removerImovel(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                imoveis.remove(imovel);
                return;
            }
        }
    }

    public void removerCliente(String cpfRemover) {
        for (Cliente c : clientes) {
            if (cpfRemover.equals(c.getCpf())) {
                clientes.remove(c);
                return;
            }
        }
    }
}

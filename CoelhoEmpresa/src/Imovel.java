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
    public void realizarLeitura() {
        this.penultimaLeitura = this.ultimaLeitura;
        System.out.println("Digite a leitura atual: ");
        this.ultimaLeitura = Main.ler().nextDouble();
    }
}

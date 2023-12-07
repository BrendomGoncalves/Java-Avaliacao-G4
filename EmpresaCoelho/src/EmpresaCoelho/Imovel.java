import java.util.ArrayList;
import java.util.List;

public class Imovel {

  private String matricula;
  private String endereco;
  private double ultimaLeitura;
  private double penultimaLeitura;
  private List<Fatura> faturas;

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

  public List<Fatura> getFaturas() {
    return faturas;
  }

  public void adicionarFatura(Fatura fatura) {
    if (this.faturas == null) {
      this.faturas = new ArrayList<>();
    }
    this.faturas.add(fatura);
  }
}

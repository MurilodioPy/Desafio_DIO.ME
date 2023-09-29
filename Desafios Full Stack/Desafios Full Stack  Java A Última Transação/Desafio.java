import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Desafio {
    
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try{
        String entrada = scanner.nextLine();
        // String entrada = "11/0F5/2023,11:15f:00,Transferencia,2F.00";
        String[] partes = entrada.split(",");

        // SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // TODO: Solicitar ao usuário que forneça os valores necessários para criar uma Transacao.
        // Date data = df.parse(partes[0]);
        var date = partes[0];
        var hora = partes[1];
        var descricao = partes[2];
        var valor = Double.parseDouble(partes[3]);
        //NumberFormatException
        //ParseException
        Transacao t = new Transacao(date, hora, descricao, valor);
        t.imprimir();
    }catch(NumberFormatException e){
        System.out.println("Número invalido");
    }
  }
}

class Transacao {
  private String data;
  private String hora;
  private String descricao;
  private double valor;

  public Transacao(String data, String hora, String descricao, double valor) {
    this.data = data;
    this.hora = hora;
    this.descricao = descricao;
    this.valor = valor;
  }
  
  public void imprimir() {
    System.out.println(this.descricao);
    System.out.println(this.data);
    System.out.println(this.hora);
    System.out.printf("%.2f", this.valor);
  }
}
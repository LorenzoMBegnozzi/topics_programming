package exer1_12_02_2025.model;
import jakarta.persistence.*;

@Entity

public class Funcionario {
    @Id //cada usuario tem o seu unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o id automaticamente
        
    private Integer id;
    private String nome;
    private double salario;

    // Construtor vazio (necessário para o JPA)
    public Funcionario(){}

    // Construtor com parâmetros (para criar objetos mais facilmente)
    public Funcionario (String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    //Os Getters e Setters permitem acessar e modificar os atributos do funcionário:
    //Getters (getX()) → Retornam o valor do atributo.
    //Setters (setX()) → Alteram o valor do atributo.
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

}

package exer1_12_02_2025.service;

import exer1_12_02_2025.model.Funcionario;
import exer1_12_02_2025.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    //FuncionarioService precisa do FuncionarioRepository para interagir com o banco de dados.
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    // Adicionar funcionário
    public Funcionario adicionar (Funcionario funcionario){
        return repository.save(funcionario);
    }

    //Listar todos os funcionarios
    public List <Funcionario> listar (){
        return repository.findAll();
    }

    //Atualizar salario
    //✅ Esse metodo procura um funcionário pelo ID, e se encontrar, atualiza o salário.
    //✅ findById(id) → Busca o funcionário no banco.
    //✅ map(funcionario -> { ... }) → Se o funcionário for encontrado, ele entra nessa função.
    //✅ setSalario(novoSalario) → Atualiza o salário.
    //✅ save(funcionario) → Salva as alterações no banco.
    public Optional<Funcionario> atualizar (Integer id, double novoSalario){
        return repository.findById(id).map(funcionario -> {
            funcionario.setSalario(novoSalario);
            return repository.save(funcionario);
        });
    }

    //✅ Esse metodo remove um funcionário com base no seu ID.
    //✅ deleteById(id) → O Spring Boot já sabe como deletar direto no banco.
    public void remover (Integer id){
        repository.deleteById(id);
    }
}

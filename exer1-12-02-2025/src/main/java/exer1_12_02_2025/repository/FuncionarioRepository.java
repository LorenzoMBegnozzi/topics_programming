package exer1_12_02_2025.repository;

import exer1_12_02_2025.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<Funcionario, Integer> → Permite salvar, buscar, atualizar e deletar funcionários sem precisar escrever SQL.
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}

package exer1_12_02_2025.controller;

import exer1_12_02_2025.model.Funcionario;
import exer1_12_02_2025.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public Funcionario adicionar (@RequestBody Funcionario funcionario){
        return service.adicionar(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar(){
        return service.listar();
    }

    @PutMapping("/{id}/salario")
    public Optional<Funcionario> atualzar (@PathVariable Integer id, @RequestParam double novoSalario){
        return service.atualizar(id, novoSalario);
    }

    @DeleteMapping("/{id}")
    public void remover (@PathVariable Integer id) {
        service.remover(id);
    }

}

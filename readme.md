# Spring Boot - Padrão MVC

Este projeto segue o padrão **MVC (Model-View-Controller)** para organizar o código em diferentes camadas.

## Tecnologias Usadas
- **Spring Data JPA** (para interagir com o banco de dados)
- **Spring Web** (para criação de APIs REST)
- **Lombok** (para reduzir boilerplate code)
- **H2 Database** (banco de dados em memória)

## Estrutura do Projeto

```
📂 src/main/java/com/example/demo
│
├── 📂 model        # Representa os dados do sistema (Entidades)
├── 📂 repository   # Gerencia o acesso ao banco de dados
├── 📂 service      # Contém a lógica de negócio
└── 📂 controller   # Exposição dos endpoints da API
```

## 1. Model (Modelo) → Representa os dados
A pasta `model` contém as classes que representam os dados da aplicação, geralmente mapeadas para tabelas no banco de dados usando **JPA** e **Hibernate**.

### Exemplo: `Funcionario.java`
```java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double salario;
}
```
✅ Essa classe `Funcionario` vira uma tabela no banco de dados.

## 2. Repository (Repositório) → Acesso ao banco de dados
A pasta `repository` contém interfaces que comunicam com o banco de dados usando **Spring Data JPA**, eliminando a necessidade de escrever SQL manualmente.

### Exemplo: `FuncionarioRepository.java`
```java
package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
```
✅ Herda `JpaRepository<Funcionario, Integer>` e fornece métodos como:
- `save(funcionario)`: Salva ou atualiza no banco
- `findAll()`: Lista todos os registros
- `findById(id)`: Busca um registro pelo ID
- `deleteById(id)`: Remove um registro pelo ID

## 3. Service (Serviço) → Lógica de negócio
A pasta `service` contém as regras do sistema, funcionando como uma camada intermediária entre `controller` e `repository`.

### Exemplo: `FuncionarioService.java`
```java
package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return repository.findAll();
    }

    public Optional<Funcionario> atualizarSalario(Integer id, double novoSalario) {
        return repository.findById(id).map(funcionario -> {
            funcionario.setSalario(novoSalario);
            return repository.save(funcionario);
        });
    }

    public void removerFuncionario(Integer id) {
        repository.deleteById(id);
    }
}
```
✅ O `FuncionarioService` usa `FuncionarioRepository` para acessar o banco.

## 4. Controller (Controlador) → Exposição de endpoints
A pasta `controller` define os endpoints REST para interação com o sistema.

### Exemplo: `FuncionarioController.java`
```java
package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
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
    public Funcionario adicionar(@RequestBody Funcionario funcionario) {
        return service.adicionarFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listarFuncionarios();
    }

    @PutMapping("/{id}/salario")
    public Optional<Funcionario> atualizarSalario(@PathVariable Integer id, @RequestParam double novoSalario) {
        return service.atualizarSalario(id, novoSalario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        service.removerFuncionario(id);
    }
}
```
✅ Define endpoints para interagir com os funcionários.
✅ Chama `FuncionarioService` para acessar a lógica de negócio.

## Endpoints da API

| Método HTTP | Endpoint | Ação |
|-------------|-----------|--------------------------------|
| **POST** | `/funcionarios` | Adiciona um novo funcionário |
| **GET** | `/funcionarios` | Lista todos os funcionários |
| **PUT** | `/funcionarios/{id}/salario?novoSalario=4000` | Atualiza o salário |
| **DELETE** | `/funcionarios/{id}` | Remove um funcionário |

## Resumo da Estrutura do Projeto

| Pasta | Função |
|--------|------------------------------------------------|
| 📂 `model` | Define as classes que representam os dados do sistema. |
| 📂 `repository` | Gerencia o acesso ao banco de dados com `JpaRepository`. |
| 📂 `service` | Contém a lógica de negócio e processa os dados antes de salvar no banco. |
| 📂 `controller` | Define os endpoints da API para interagir com os usuários. |

🚀 **Com essa estrutura, seu projeto está organizado e segue as boas práticas do Spring Boot!**


# sistemaAutomotivo-java-spring-restFull
Sistema automotivo usando java, spring, e o recurso restFull em desenvolvimento

O projeto é basicamente um sistema automotivo para gerenciamento de vendas, funcionarios, veículos, estoque e etc. (ainda em desenvolvimento)

<hr>

# Como rodar o projeto:

O projeto já vem com carga inicial de dados, então vc já vai ter alguns registros no banco para poder manipular.

1. Tenha o JDK17 instalado na sua maquina!
2. Tenha o Mysql instalado na sua maquina!
3. Dentro do MysqlServer, crie um banco de dados chamado system.
4. Clone o projeto para um diretorio local.
5. Abra o projeto em sua IDE de preferência e baixe as dependências.
6. configure corretamente as variáveis de ambiente.
7. Inicie o projeto!
8. a configuração a seguir que fica dentro do arquivo `application.properties`, setando o perfil `local` fara a carga inicial de dados para o banco de dados, se precisar reiniciar o projeto, remova o perfil, para evitar o erro de duplicidade dos dados.
```
spring.profiles.active=local
```

# EndPoints

# Clientes (clients)

(endpoint com problemas)
* #### // GET /clients - status: 200
// Resgata todos os registros do banco de dados.

====================================

* #### GET /clients/:id - status: 200
* Busca client por id.

====================================

* #### GET /clients/:cpf - status: 200
* Busca client por cpf.

====================================

* #### POST /clients - status: 201
* cria novo cliente.
```
{
    "name": "Davi",
    "cpf": "00200009000",
    "address": "Rua b, n: 56",
    "phoneNumber": "00926881111",
    "email": "con2ate@gmail.com",
    "nationality": "BR",
    "isActive": true,
    "creditCompany": 10.0,
    "monthlySalary": 1236.0,
    "approvedFinancing": false
}
```

====================================

* #### PUT /clients/:id - status: 200
* Atualiza registro no banco de dados.
```
{
    "address": "Rua b, n: 56",
    "cpf": "11111111111",
    "email": "contyte@gmail.com",
    "isActive": true,
    "name": "Davi",
    "nationality": "BR",
    "phoneNumber": "00986881111",
    "approvedFinancing": false,
    "creditCompany": 10.00,
    "monthlySalary": 1236.00
}
```

====================================

* #### DELETE /clients/:id - status: 204
* Deleta pessoas do banco de dados.

# Funcionários (employee)

(endpoint com problemas)
* #### // GET /employees - status: 200
// Resgata todos os registros do banco de dados.

====================================

* #### GET /employees/:id - status: 200
* Busca funcionário por id.

====================================

* #### POST /employees - status: 201
* cria novo funcionário.
```
{
    "name": "Gabriel",
    "cpf": "00200009000",
    "address": "Rua b, n: 56",
    "phoneNumber": "00926881111",
    "email": "con2ate@gmail.com",
    "nationality": "BR",
    "isActive": true,
    "creditCompany": 10.0,
    "monthlySalary": 1236.0,
    "approvedFinancing": false,
    "area": "Engenheiro de Software",
    "pcd": false,
    "salary": 2000,
    "sector": "Desenvolvimento Backend",
    "workSchedule": "8:00 - 17:00"
}
```

====================================

* #### PUT /employees/:id - status: 200
* Atualiza registro do funcionário no banco de dados.
```
    {
        "id": 5,
        "name": "Gabriel",
        "cpf": "0020069000",
        "address": "Rua b, n: 56",
        "phoneNumber": "60926881111",
        "email": "con2a6e@gmail.com",
        "nationality": "BR",
        "isActive": true,
        "sector": "Desenvolvimento Backend",
        "workSchedule": "8:00 - 17:00",
        "salary": 2000.0,
        "pcd": false,
        "area": "Engenheiro Java"
    }
```

====================================

* #### DELETE /employees/:id - status: 204
* Deleta funcionário do banco de dados.

(documentação em desenvolvimento)


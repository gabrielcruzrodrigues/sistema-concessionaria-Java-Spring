# sistemaAutomotivo-java-spring-restFull
Sistema automotivo usando java, spring, e o recurso restFull em desenvolvimento

O projeto é basicamente um sistema automotivo para gerenciamento de vendas, funcionarios, veículos, estoque e etc. (ainda em desenvolvimento)

<br>


<br>

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
9. Olhe como funciona a autenticação, para conseguir acessar os endpoints.

<br>

# Authenticação
O projeto contem atualmente 3 níveis de permissão: 
- ADMIN
- SELLER
- USER

Por padrão, a carga inicial de dados vai gerar um usuario com a role `ADMIN` no banco de dados para que vc possa registrar novos usuários e fazer as modificações que quiser.

O sistema foi construido usando o JWT para gerar tokens de segurança que são gerados após o usuário logar com sucesso. eles devem ser passados no cabeçalho da requisição para que as rotas sejam liberadas!
```
"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzeXN..." 
```
login:
* #### POST /login - status: 200
*  apos logado, vc recebera um token para acessar as outras rotas.<br>
OBS: esse é o login padrão para o usuário que é criado na carga inicial de dados.
```
{
    "login": "user",
    "password": "123456789"
}
```
register:
* #### POST /register - status: 200
* endPoint para registrar um novo usuário no banco de dados, disponível apenas para ADMINs
* OBS: para criar um novo usuário, é necessário passar o token de authenticação.
```
{
    "login": "bb",
    "password": "123456789",
    "role": "USER"
}
```
### Lista de permissões para cada role: 
- `ADMIN`<br>
acesso total ao sistema.

- `SELLER`<br>
GET /clients <br>
GET /clients/{id} <br>
GET /clients/search/{cpf} <br>
POST /clients <br>
PUT /clients/{id} <br>
GET /cars <br>
GET /cars/{id} <br>
POST /sales <br>
GET /sales/client/{id} <br>
GET /sales/car/{id} <br>
GET /sales <br>

- `USER`<br>
atualmente nenhuma permissão.

<br>

# EndPoints

<br>

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
* Deleta cliente do banco de dados.

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

# Vendedores (Seller)

(endpoint com problemas)
* #### // GET /sellers - status: 200
// Resgata todos os registros do banco de dados.

====================================

* #### GET /sellers/:id - status: 200
* Busca vendedor por id.

====================================

* #### POST /sellers - status: 201
* cria novo vendedor.
```
{
    "name": "Gabriel",
    "cpf": "00207009000",
    "address": "Rua b, n: 56",
    "phoneNumber": "00927781111",
    "email": "con277e@gmail.com",
    "nationality": "BR",
    "isActive": true,
    "creditCompany": 10.0,
    "monthlySalary": 1236.0,
    "approvedFinancing": false,
    "area": "Engenheiro de Software",
    "pcd": false,
    "salary": 2000,
    "sector": "Desenvolvimento Backend",
    "workSchedule": "8:00 - 17:00",
    "quantitySales": 70,
    "quantitySalesMonth": 5,
    "valueTotalSalesMonth": 55000,
    "cityWork": "Jequie"
}
```

====================================

* #### PUT /sellers/:id - status: 200
* Atualiza registro do vendedor no banco de dados.
```
{
    "name": "Gabriel",
    "dateOfBirth":"2002-02-13",
    "cpf": "75722172065",
    "address": "Rua b, n: 56",
    "phoneNumber": "00927781111",
    "email": "con277e@gmail.com",
    "nationality": "BR",
    "isActive": true,
    "creditCompany": 10.0,
    "monthlySalary": 1236.0,
    "approvedFinancing": false,
    "area": "Engenheiro de Software",
    "pcd": false,
    "salary": 2000,
    "sector": "Desenvolvimento Backend",
    "workSchedule": "8:00 - 17:00",
    "quantitySales": 70,
    "quantitySalesMonth": 5,
    "valueTotalSalesMonth": 55000,
    "cityWork": "Jitauna"
}   
```

====================================

* #### DELETE /sellers/:id - status: 204
* Deleta vendedor do banco de dados.

# Carros (cars)

* #### // GET /cars - status: 200
// Resgata todos os registros do banco de dados.

====================================

* #### GET /cars/:id - status: 200
* Busca carro por id.

====================================

* #### POST /cars - status: 201
* cria novo carro.
```
{
    "name": "Corsa",
    "chassi": "12345671901234567",
    "color": "Black",
    "fuelConsumptionPerLiter": 6,
    "isAvailable": true,
    "isActive": true,
    "mileage": 100.56,
    "model": "25365asdf",
    "motor": "gasolina",
    "plate": "GHP1234",
    "power": 230,
    "stage": "NOVO",
    "torque": 60,
    "weight": 1.00000,
    "automaticTransmission": true,
    "cameraMonitoring": true,
    "electricWindows": true,
    "gps": true,
    "hydraulicSteering": true,
    "sensorsAndCameras": true,
    "sunroof": true,
    "traction": true,
    "manufactureYear": "2002"
}
```

====================================

* #### PUT /cars/:id - status: 200
* Atualiza registro do carro no banco de dados.
```
{
    "name": "Celta",
    "manufactureYear":"2000",
    "chassi": "12245671901234567",
    "color": "Black",
    "fuelConsumptionPerLiter": 6,
    "isActive": true,
    "isAvailable": true,
    "mileage": 100.56,
    "model": "25365asdf",
    "motor": "gasolina",
    "plate": "GHP2234",
    "power": 230,
    "stage": "NOVO",
    "torque": 60,
    "weight": 1.00000,
    "automaticTransmission": true,
    "cameraMonitoring": true,
    "electricWindows": true,
    "gps": true,
    "hydraulicSteering": true,
    "sensorsAndCameras": true,
    "sunroof": true,
    "traction": true
}
```

====================================

* #### DELETE /cars/:id - status: 204
* Deleta carro do banco de dados.

# Vendas (sales)

* #### POST /sales - status: 201
* cria nova venda.
```
{
    "seller": {
        "id": 1
    },
    "client": {
        "id": 2
    },
    "carId": {
        "id": 1
    },
    "paymentMethod": "PIX" (ou) "CARTAO" (OU) "BOLETO" (OU) "DINHEIRO"
}
```

====================================

* #### GET /sales - status: 200
* Busca todas as vendas do banco de dados.

====================================

* #### GET /sales/seller/:id - status: 200
* Busca todas as vendas relacionadas ao vendedor (seller) pelo id.

====================================

* #### GET /sales/client/:id - status: 200
* Busca todas as vendas relacionadas ao cliente (client) pelo id.

====================================

* #### GET /sales/car/:id - status: 200
* Busca todas as vendas relacionadas ao carro (client) pelo id.


  
(documentação em desenvolvimento)


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
(documentação em desenvolvimento)

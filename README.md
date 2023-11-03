# Controle de Contatos

VERSIONAMENTO :

-SPRING BOOT - 3.0.12

-JAVA - 17

------------ // ---------------------

Banco de dados Utilizado : MySQL

------------ // --------------------

Modo de Excecução 


No arquivo "src/main/resources/application.properties" troque as configurações
do banco de dados como url, user e password para o do seu mySQL na sua máquina.

----------------------------------//---------------------------

Funcionalidades

 CONTATO-CONTROLLER
 
  -Encontrar contato por id ("/contatos/id", GET)
  
  -Atualizar contato por id ("/contatos/id, PUT)
  
  -Deletar um contato por id ("/contatos/id", DELETE)

 PESSOA-CONTROLLER

  -Encontrar lista pessoas ("/pessoas", GET)
  
  -Encontrar pessoa por id ("/pessoas/id", GET)
  
  -Encontrar pessoa por id de mala direta ("/pessoas/maladireta/id", GET)
  
  -Encontrar lista de contatos por pessoa id ("/pessoas/id/contatos", GET)
  
  -Salvar uma pessoa ("/pessoas", POST)
  
  -Atualizar uma pessoa por id ("/pessoas/id", PUT)
  
  -Deletar uma pessoa por id ("/pessoas/id", DELETE)
  
  -Adicionar um contato em uma pessoa ("/pessoas/id/contatos", POST)

------------------------------//------------------------------


Documentação swagger: /api/swagger-ui/index.html

Caso esteja utilizando na máquina local e porta 8080, a forma correta de acessar seria: http://localhost:8080/api/swagger-ui/index.html

 
-------------------------//-------------------

Observações

 Por questão de preferência, eu teria utilizado a abordagem de DTO no projeto inteiro,
 mas como foi solicitado para colocar apenas no MalaDireta, fiz dessa maneira. Não quis fugir
 do escopo das especificações em nenhuma parte do projeto!

 -------------------------//-------------------

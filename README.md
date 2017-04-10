# ZICODE PROJECT

4 módulos constituem o projeto:

- zipCodeModel
- zipCodeBDMock
- zipCodeFinder
- AddressAdmin

Os serviços disponíveis utilizam arquitetura REST e SPRING BOOT.

## Build

Após baixar os projetos, acessá-los na ordem abaixo e executar 

<code>  mvn clean package isntall </code>

- zipCodeModel
- zipCodeBDMock
- zipCodeFinder
- AddressAdmin

Na pasta dos TARGET dos projetos zipCodeFinder e addressAdmin serão gerados os respectivos executáveis (JAR)

Executar o comando para o start:

<code>
java -jar nome_do_jar.jar
</code>

  ## zipCodeFinder
  
  zipCodeFinder oferece um serviço REST para procura de um endereço na base de dado através do CEP.
  Antes da pesquisa, é feita uma validação no CEP informado. Tal validação consiste em verificar se o CEP não é vazio e se seu tamanho é diferente de 8.
 
 Caso o CEP informado não seja encontrado, 8 novas tentativas de busca são feitas, substituindo por 0 cada caracter do CEP enviado do último ao primeiro.
 Se, após todas as substituições e tentativas nenhum cep for encontrado, uma mensagem é retornada com status 400.
  
  Caso o CEP informado sejá inválido, uma mensagem é retornada com status 400.
  
  obs. originalmente rodando na porta 8080

 
- HTTP: POST

- Header: Content-Type:application/json

- Body: { "zipcode":"algum_cep" }
 
 
Exemplo URL:
<code> http://localhost:8080/v1/cep  </code>
 
 
 Respostas:
 
 - CEP Encontrado
 
 status: 200 OK
 
 <code> {
  "id": 1,
  "zipcode": "12345678"
}

</code>

- CEP não encontrado

status: 400 Bad Request

<code> 
{
  "status": "BAD_REQUEST",
  "zipCodeRequest": "",
  "statusMessage": "ZipCode not found",
  "zipcodeResponse": null
}

</code>

- CEP inválido

status: 400 Bad Request

<code>
{
  "status": "BAD_REQUEST",
  "zipCodeRequest": "",
  "statusMessage": "CEP inválido",
  "zipcodeResponse": null
}

</code>


# AddressAdmin

AddressAdmin oferece serviços REST para atualizar e deletar um endereço.
obs. configurado para rodar originalmente na porta 9999

### Atualizar

- HTTP POST
-  Headers: Accept:application/json, Content-Type:application/json
- Body:


{
	
	"zipcode":"12345678",
	"street":"rua",
	"number":"1",
	"city":"sp",
	"state":"estado",
	"neighbourhood":"bairro",
	"complement":"comp"
}

- Atualizado com sucesso
<code>
{
  "status": "OK",
  "statusMessage": "",
  "address": {
    "id": 1,
    "zipcode": {
      "id": 0,
      "zipcode": "12345678"
    },
    "street": "rua",
    "number": "1",
    "city": "sp",
    "state": "estado",
    "neighbourhood": "bairro",
    "complement": "comp"
  }
}

</code>

- CEP inválido

<code>

{
  "status": "BAD_REQUEST",
  "statusMessage": "{\"status\":\"BAD_REQUEST\",\"zipCodeRequest\":\"\",\"statusMessage\":\"CEP inválido\",\"zipcodeResponse\":null}",
  "address": null
}

</code>

- CEP não encontrado

<code>

{
  "status": "BAD_REQUEST",
  "statusMessage": "{\"status\":\"BAD_REQUEST\",\"zipCodeRequest\":\"\",\"statusMessage\":\"ZipCode not found\",\"zipcodeResponse\":null}",
  "address": null
}

</code>

### Deletar

Deleta um endereço utilizando o ID enviado na URL.
Exemplo:

<code> http://localhost:9999/address/1  </code>

- HTTP DELETE

- Encontrado e deletado com sucesso

status 200 OK

- CEP não encontrado

<code>

{
  "status": "BAD_REQUEST",
  "statusMessage": "ADDRESS NOT FOUND",
  "address": null
}

</code>


# Próximos passos:

- Disponibilizar serviço de Busca de endereço no projeto AddressAdmin
- Externalizar a configuraçao da porta de cada Main dos projetos
- Externalizar mensagens 
- Fazer módulo para Banco de Dados  (Hibernate)
- Testes com JUnit
- Completar JavaDoc

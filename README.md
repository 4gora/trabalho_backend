# FilmesAPI

## Objetivo

A API permite catalogar filmes, consultar informações detalhadas e obter estatísticas para análises. É ideal para quem deseja organizar uma coleção de filmes, realizar buscas por ano de lançamento, e obter dados para dashboards ou recomendações baseadas gênero, avaliação IMDb etc.

## Como rodar a API

1. **Pré-requisitos**:
   - Java 21+
   - Maven

2. **Instalação**:
   ```bash
   mvn clean install
   ```

3. **Execução**:
   ```bash
   mvn spring-boot:run
   ```
   A API estará disponível em `http://localhost:8080`.

## Rotas disponíveis

### Adicionar filme
- **POST /filmes**
- **Body (JSON):**
  ```json
  {
    "titulo": "Os Incríveis",
    "genero": "Animação/Ação",
    "duracao": 115,
    "diretor": "Brad Bird",
    "anoLancamento": "2004",
    "pais": "EUA",
    "imdb": 8 
  }
  ```
- **ID:** O ID é criado e incrementado automaticamente.
- **Resposta:** 201 Created, retorna o filme cadastrado.

### Listar todos os filmes
- **GET /filmes**
- **Resposta:** 200 OK, retorna lista de filmes.

### Buscar filme por ID
- **GET /filmes/{id}**
- **Resposta:** 200 OK (filme encontrado) ou 404 Not Found.

### Atualizar filme
- **PUT /filmes/{id}**
- **Body (JSON):** igual ao POST
- **Resposta:** 200 OK (filme atualizado) ou 404 Not Found.

### Remover filme
- **DELETE /filmes/{id}**
- **Resposta:** 200 OK (removido) ou 404 Not Found.

### Listar filmes por ano
- **GET /filmes/ano/{anoLancamento}**
- **Resposta:** 200 OK, retorna lista de filmes daquele ano.

### Total de filmes cadastrados
- **GET /filmes/total**
- **Resposta:** 200 OK, retorna número total.

## Validação de dados

- Campos obrigatórios: `titulo` (não pode ser vazio).
- `imdb`: Deve ser um valor decimal entre 0 e 10.
- Erros de validação retornam status 400 e mensagem personalizada.

## Exemplo de resposta de erro

```json
{
  "erro": "Erro de validação: O campo titulo é obrigatório."
}
```
## API de Atividades

##### Esta API permite a criação, atualização, listagem e exclusão de atividades.
##### Alunos:
##### * RM 97373 - Raquel Calmon
##### * RM 96542 - Gustavo Ballogh
##### * RM 96553 - Felipe Seiji


---

### Exemplo de URL Base

```plaintext
http://localhost:8080
```

---

### Endpoints Disponíveis

---

### 1. Criar Atividade

Cria uma nova atividade.

- **URL**
  ```plaintext
  POST /api/atividades
  ```

- **Corpo da Requisição (JSON)**
  ```json
  {
    "atividade": "Nome da Atividade",
    "descricao": "Descrição da Atividade",
    "localizacao": "Localização da Atividade",
    "max_participantes": 10
  }
  ```

- **Resposta de Sucesso**
    - Código: `200 OK`
    - Corpo da Resposta (String): "Atividade criada com sucesso!"

---

### 2. Atualizar Atividade

Atualiza uma atividade existente pelo seu ID.

- **URL**
  ```plaintext
  PATCH /api/atividades/{id}
  ```

- **Parâmetros da URL**
    - `id` (Long): ID da atividade a ser atualizada

- **Corpo da Requisição (JSON)**
  ```json
  {
    "atividade": "Novo Nome da Atividade",
    "descricao": "Nova Descrição da Atividade",
    "localizacao": "Nova Localização da Atividade",
    "max_participantes": 20
  }
  ```

- **Resposta de Sucesso**
    - Código: `200 OK`
    - Corpo da Resposta (String): "Atividade atualizada com sucesso!"

---

### 3. Obter Atividade por ID

Retorna os detalhes de uma atividade pelo seu ID.

- **URL**
  ```plaintext
  GET /api/atividades/{id}
  ```

- **Parâmetros da URL**
    - `id` (Long): ID da atividade desejada

- **Resposta de Sucesso**
    - Código: `200 OK`
    - Corpo da Resposta (JSON): Objeto AtividadesDTO contendo os detalhes da atividade

---

### 4. Listar Atividades

Lista todas as atividades disponíveis, paginadas.

- **URL**
  ```plaintext
  GET /api/atividades
  ```

- **Parâmetros da Query**
    - `page` (Integer): Número da página (começando em 0)
    - `size` (Integer): Tamanho da página

- **Resposta de Sucesso**
    - Código: `200 OK`
    - Corpo da Resposta (JSON): Página de atividades

---

### 5. Deletar Atividade

Remove uma atividade existente pelo seu ID.

- **URL**
  ```plaintext
  DELETE /api/atividades/{id}
  ```

- **Parâmetros da URL**
    - `id` (Long): ID da atividade a ser deletada

- **Resposta de Sucesso**
    - Código: `200 OK`
    - Corpo da Resposta (String): "Atividade deletada com sucesso!"

--- 

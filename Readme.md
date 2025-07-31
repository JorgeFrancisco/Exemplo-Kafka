# Spring Boot com Apache Kafka

Este projeto demonstra como integrar **Spring Boot** com **Apache Kafka**, focando em tópicos, partições, chave da mensagem e estratégias para escalabilidade.

---

## 🧩 Conceitos Essenciais

### 🔹 Tópico (`Topic`)
Um canal lógico onde as mensagens são publicadas. Exemplo: `usuarios`.

### 🔹 Partições (`Partitions`)
Cada tópico pode ser dividido em partições, permitindo **paralelismo**. Mensagens com a mesma chave vão para a mesma partição, garantindo ordenação local.

### 🔹 Chave da Mensagem (`Key`)
A chave determina a **partição de destino**. É crucial para garantir **ordenamento** ou para distribuir dados entre partições.

---

## ✅ Benefícios de usar Partições

- Processamento paralelo com múltiplos consumidores.
- Balanceamento de carga automático entre instâncias.
- Escalabilidade horizontal fácil.

---

## 🛠️ Envio de Mensagens com KafkaTemplate

```java
@Autowired
private KafkaTemplate<String, UsuarioDTO> kafkaTemplate;

public void enviarMensagem(UsuarioDTO usuario) {
    kafkaTemplate.send("usuarios", usuario.getCpf(), usuario);
}
```

## 🛠️ Há na pasta resources o docker compose, para executar o Kafka e o RedPanda localmente. RedPanda é uma interface gráfica para manipulçao dos tópicos. Há também outro arquivo, de operações dentro do container para manipular os tópicos.

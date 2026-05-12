# POO---Noturno-Atividade-Relacionais
# Sistema de Gestão de Frota Logística

Atividade Prática — POO | Relacionamentos entre Classes

## Integrantes
- Douglas Henrique Alves

## Descrição
Sistema desenvolvido em Java para gerenciar **Veículos**, **Motoristas** e **Viagens**, aplicando encapsulamento rigoroso e relacionamentos entre classes.

## Estrutura de Classes
- `Motorista` — nome, CPF, CNH e validade com validação nos setters
- `Veiculo` — placa, modelo, tanque, combustível com métodos `abastecer()` e `viajar()`
- `Viagem` — composição de Motorista + Veículo, com `iniciarViagem()` e `gerarRelatorio()`
- `Main` — testes de instanciação, validação de CNH, abastecimento e execução de viagem

## Como Executar
```bash
javac *.java
java Main
```

## Regras de Negócio Implementadas
- Nenhum atributo é público
- Combustível não pode ser negativo
- Motorista com CNH vencida (< 2024) não pode iniciar viagem
- Viagem só inicia com motorista e veículo vinculados

# Lista de Exercícios Java 2025 (Out-Dez)

Projeto Gradle contendo o enunciado e a resolução de diversos exercícios em Java organizados por pacotes.

## Estrutura do Projeto

O projeto utiliza a estrutura padrão do Gradle:

```
src/
├── main/
│   └── java/
│       └── org/
│           └── desviante/
│               └── exercicios/
│                   ├── anobissexto/
│                   ├── numbergenerators/
│                   ├── etc..
└── test/
    └── java/
        └── org/
            └── desviante/
                └── exercicios/
                    ├── RecursionProgrammingExerciseLargest/
                    ├── x01_sortasum/
                    └── etc..

```

## Lista de Exercícios

> Cada exercício possui seu próprio README com detalhes de implementação.

### Exercícios Básicos
- Ano Bissexto - `anobissexto`
- Number Generators - `numbergenerators` (Hierarquia de classes)
- Publication - `publication` (Hierarquia de publicações)

### Exercícios de Recursão
- Largest (Recursão) - `RecursionProgrammingExerciseLargest`

### Exercícios Programmazione OOP
- Dice - `programmazione.dice` (Jogo de dados com apostas)
- Student - `programmazione.student` (Sistema de estudantes e exames)

### Hyperskill
- Exception Handling - Tratando exceções
- Fright Night Coding Challenges

### Code Workout
- X01 - Sorta Sum
- X02 - In1To10**
- X03 - Less By Ten**
- x04 - Tea Party
- x05 - Answer Cell
- x06 - Hello Name
- x07 - Ends Ly
- x08 - See Color
- x09 - Make Tags
- x10 - Combo String
- x11 - Teen Sum
- x12 - Squirrel Play
- x13 - Caught Speeding
- x14 - Near Ten
- x15 - In Order
- x16 - Two As One
- x17 - Red Ticket
- x18 - Blue Ticket
- x19 - Make Bricks
- x20 - Lone Sum
- x21 - Lucky Sum
- x22 - No Teen Sum
- x23 - Close Far
- x24 - Blackjack
- x25 - Evenly Spaced
- x26 - At First
- x28 - The End
- x29 - Factorial
- x30 - Repeat End
- x31 - Plus Out
- x32 - Mix String
- x33 - Zip Zap
- x34 - Word Ends
- x35 - Count Code
- X36 - End Other
- X37 - Xyz There
- X38 - Xy Balance
- x39 - Get Sandwich
- x40 - Sum 3 integers in Array
- x41 - Plus Two

## Como Executar

### Listar todos os exercícios disponíveis:
```bash
./gradlew listarExercicios
```

### Compilar o projeto:
```bash
./gradlew build
```

### Executar testes:
```bash
./gradlew test
```

### Executar exercícios específicos:

(Obs.: Válido apenas para exercícios que possuem método main).

```bash
# Exercícios Básicos
./gradlew runAnoBissexto
./gradlew runNumberGenerators
./gradlew runPublication

# Recursão
./gradlew runLargest

# Programmazione OOP
./gradlew runDice

# Exercícios X-Series
./gradlew runSortaSum
./gradlew runHelloName
./gradlew runEndsLy
```

> **Windows:** Use `.\gradlew` em vez de `./gradlew`

## Requisitos

- Java 17 ou superior
- Gradle 8.x (wrapper incluído)

## Testes

Os testes utilizam **JUnit 5** e estão em `src/test/java`.

**Executar todos os testes:**
```bash
./gradlew test
```

**Exemplos de como executar um teste específico:**
```bash
./gradlew test --tests "*x01_sortasum*"
./gradlew test --tests "*HelloName*"
./gradlew test --tests "*caughtSpeeding*"
```

**Relatório:** `build/reports/tests/test/index.html`

## Estrutura de Pacotes

**Pacote base:** `org.desviante.exercicios`

Cada exercício possui seu próprio subpacote para melhor organização e evitar conflitos de nomes.

---

## Referências:

### 📚 Projeto educacional com exercícios de diversas fontes.

- [Jett Brains Academy](https://www.jetbrains.com/pt-br/academy/)
- [Code Workout](https://codeworkout.cs.vt.edu/)
- [Hyperskill](https://hyperskill.org/join/aeba947b2)

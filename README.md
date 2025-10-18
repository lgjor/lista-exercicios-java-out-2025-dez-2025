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
1. **Ano Bissexto** - `anobissexto`
2. **Number Generators** - `numbergenerators` (Hierarquia de classes)
3. **Publication** - `publication` (Hierarquia de publicações)

### Exercícios de Recursão
4. **Largest (Recursão)** - `RecursionProgrammingExerciseLargest`

### Exercícios Programmazione OOP
5. **Dice** - `programmazione.dice` (Jogo de dados com apostas)
6. **Student** - `programmazione.student` (Sistema de estudantes e exames)

### Exercícios Numerados (X-Series)
7. **X01 - Sorta Sum** - `x01_sortasum`
8. **X02 - In1To10** - `x02_in1To10`
9. **X03 - Less By Ten** - `x03_lessbyten`
10. **X05 - Answer Cell** - `x05_answerCell`
11. **X06 - Hello Name** - `x06_HelloName`
12. **X07 - Ends Ly** - `X7_endsLy`

## Como Executar

### Listar todos os exercícios disponíveis:
```bash
./gradlew listExercicios
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
./gradlew runIn1To10
./gradlew runLessByTen
./gradlew runAnswerCell
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

**Executar teste específico:**
```bash
./gradlew test --tests "*x01_sortasum*"
./gradlew test --tests "*HelloName*"
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





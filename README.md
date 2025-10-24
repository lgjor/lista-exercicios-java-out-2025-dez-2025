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
- **Ano Bissexto** - `anobissexto`
- **Number Generators** - `numbergenerators` (Hierarquia de classes)
- **Publication** - `publication` (Hierarquia de publicações)

### Exercícios de Recursão
- **Largest (Recursão)** - `RecursionProgrammingExerciseLargest`

### Exercícios Programmazione OOP
- **Dice** - `programmazione.dice` (Jogo de dados com apostas)
- **Student** - `programmazione.student` (Sistema de estudantes e exames)

### Hyperskill
- **Exception Handling** - Tratando exceções
- **Fright Night Coding Challenges**

### Code Workout
1. **X01 - Sorta Sum**
2. **X02 - In1To10**
3. **X03 - Less By Ten**
4. **X04 - Tea Party**
5. **X05 - Answer Cell**
6. **X06 - Hello Name**
7. **X07 - Ends Ly**
8. **X08 - See Color**
9. **X09 - Make Tags**
10. **X10 - Combo String**
11. **X11 - Teen Sum**
12. **X12 - Squirrel Play**
13. **X13 - Caught Speeding**
14. **X14 - Near Ten**
15. **X15 - In Order**
16. **X16 - Two As One**
17. **X17 - Red Ticket**
18. **X18 - Blue Ticket**
19. **X19 - Make Bricks**
20. **X20 - Lone Sum**
21. **X21 - Lucky Sum**
22. **X22 - No Teen Sum**
23. **X23 - Close Far**
24. **X24 - Blackjack**
25. **X25 - Evenly Spaced**
26. **X26 - At First**
28. **X28 - The End**
29. **X29 - Factorial**
30. **X30 - Repeat End**
31. **X31 - Plus Out**
32. **X32 - Mix String**
33. **X33 - Zip Zap**
34. **X34 - Word Ends**
35. **X35 - Count Code**
36. **X36 - End Other**
37. **X37 - Xyz There**
38. **X38 - Xy Balance**
39. **x39 - Get Sandwich**
40. **x40 - Sum 3 integers in Array**
41. **x41 - Plus Two**

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

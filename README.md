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
1. **X01 - Sorta Sum** - `x01_sortasum`
2. **X02 - In1To10** - `x02_in1To10`
3. **X03 - Less By Ten** - `x03_lessbyten`
4. **X04 - Tea Party** - `x04_teaParty`
5. **X05 - Answer Cell** - `x05_answerCell`
6. **X06 - Hello Name** - `x06_HelloName`
7. **X07 - Ends Ly** - `X7_endsLy`
8. **X08 - See Color** - `x08_seeColor`
9. **X09 - Make Tags** - `x09_makeTags`
10. **X10 - Combo String** - `x10_comboString`
11. **X11 - Teen Sum** - `X11_teenSum`
12. **X12 - Squirrel Play** - `X12_squirrelPlay`
13. **X13 - Caught Speeding** - `x13_caughtSpeeding`
14. **X14 - Near Ten** - `x14_nearTen`
15. **X15 - In Order** - `X15_inOrder`
16. **X16 - Two As One** - `X16_twoAsOne`
17. **X17 - Red Ticket** - `X17_redTicket`
18. **X18 - Blue Ticket** - `x18_blueTicket`
19. **X19 - Make Bricks** - `x19_makeBricks`
20. **X20 - Lone Sum** - `x20_loneSum`
21. **X21 - Lucky Sum** - `x21_luckySum`
22. **X22 - No Teen Sum** - `x22_noTeenSum`
23. **X23 - Close Far** - `x23_closeFar`
24. **X24 - Blackjack** - `x24_blackjack`
25. **X25 - Evenly Spaced** - `x25_evenlySpaced`
26. **X26 - At First** - `x26_atFirst`
28. **X28 - The End** - `x28_theEnd`
29. **X29 - Factorial** - `x29_factorial`
30. **X30 - Repeat End** - `x30_repeatEnd`
31. **X31 - Plus Out** - `x31_plusOut`
32. **X32 - Mix String** - `x32_mixString`
33. **X33 - Zip Zap** - `x33_zipZap`
34. **X34 - Word Ends** - `x34_wordEnds`
35. **X35 - Count Code** - `x35_countCode`
36. **X36 - End Other** - `x36_endOther`
37. **X37 - Xyz There** - `x37_xyzThere`
38. **X38 - Xy Balance** - `x38_xyBalance`

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

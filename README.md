# Lista de Exercícios Java 2025 (Out-Dez)

Projeto Gradle contendo diversos exercícios de Java organizados em pacotes.

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
│                   ├── publication/
│                   ├── x01_sortasum/
│                   ├── x02_in1To10/
│                   ├── x03_lessbyten/
│                   ├── RecursionProgrammingExerciseLargest/
│                   └── programmazione/
│                       ├── dice/
│                       └── student/
└── test/
    └── java/
        └── org/
            └── desviante/
                └── exercicios/
                    ├── RecursionProgrammingExerciseLargest/
                    ├── x01_sortasum/
                    ├── x02_in1To10/
                    └── x03_lessbyten/
```

## Exercícios Organizados

### 1. Ano Bissexto (`org.desviante.exercicios.anobissexto`)
Verifica se um ano é bissexto ou não.

**Arquivo principal:** `AnoBissexto.java`

### 2. Number Generators (`org.desviante.exercicios.numbergenerators`)
Hierarquia de classes que geram números com diferentes regras.

**Arquivos:**
- `BaseNumberGenerator.java` - Classe base
- `NumberGenerator.java` - Gerador padrão
- `MagicNumberGenerator.java` - Gerador mágico
- `Main.java` - Classe de teste

### 3. Publication (`org.desviante.exercicios.publication`)
Hierarquia de publicações (artigos, anúncios, jornais).

**Arquivos:**
- `Publication.java` - Classe base
- `Article.java` - Artigo
- `Announcement.java` - Anúncio
- `Newspaper.java` - Jornal
- `Main.java` - Classe de teste

### 4. Less By Ten (`org.desviante.exercicios.x03_lessbyten`)
Verifica se a diferença entre quaisquer dois dos três números é >= 10.

**Arquivos:**
- `LessByTen.java` - Classe principal
- `LessByTenTest.java` - Testes unitários (JUnit 5)

### 5. Sorta Sum (`org.desviante.exercicios.x01_sortasum`)
Soma dois números, mas retorna 20 se a soma estiver entre 10 e 19.

**Arquivos:**
- `SortaSum.java` - Classe principal
- `SortaSumTest.java` - Testes unitários (JUnit 5)

### 6. Programmazione OOP - Exercícios do Curso

#### 6.1 Dice (`org.desviante.exercicios.programmazione.dice`)
Jogo de dados com apostas usando contas bancárias.

**Arquivos:**
- `BankAccount.java` - Conta bancária
- `Dice.java` - Jogo principal

#### 6.2 Student (`org.desviante.exercicios.programmazione.student`)
Sistema de estudantes com exames e notas.

**Arquivos:**
- `Student.java` - Estudante (implementa Comparable)
- `Exam.java` - Exame

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

#### Windows:
```powershell
.\gradlew runAnoBissexto
.\gradlew runNumberGenerators
.\gradlew runPublication
.\gradlew runLessByTen
.\gradlew runSortaSum
.\gradlew runDice
```

#### Linux/Mac:
```bash
./gradlew runAnoBissexto
./gradlew runNumberGenerators
./gradlew runPublication
./gradlew runLessByTen
./gradlew runSortaSum
./gradlew runDice
```

### Executar usando Java diretamente (após compilar):
```bash
java -cp build/classes/java/main org.desviante.exercicios.anobissexto.AnoBissexto
```

## Requisitos

- Java 17 ou superior
- Gradle 8.x (wrapper incluído)

## Testes

Os testes estão localizados em `src/test/java` e utilizam JUnit 5. Para executar os testes:

```bash
./gradlew test
```

Os resultados dos testes estarão disponíveis em `build/reports/tests/test/index.html`.

## Estrutura de Pacotes

Todos os exercícios seguem a convenção de pacotes Java:
- **Pacote base:** `org.desviante.exercicios`
- **Subpacotes:** Cada exercício tem seu próprio subpacote

Isso facilita:
- Organização do código
- Evitar conflitos de nomes
- Importação de classes entre exercícios
- Manutenção do projeto

## Licença

Este projeto contém exercícios educacionais de diversas fontes.


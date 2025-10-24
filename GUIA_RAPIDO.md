# Guia Rápido - Lista de Exercícios Java

## 🚀 Início Rápido

### Ver todos os exercícios disponíveis:
```bash
.\gradlew listExercicios
```

### Compilar e testar:
```bash
.\gradlew build
```

## 📚 Executar Exercícios

### 1. Ano Bissexto
```bash
.\gradlew runAnoBissexto
```

### 2. Number Generators
```bash
.\gradlew runNumberGenerators
```

### 3. Publication
```bash
.\gradlew runPublication
```

### 4. Less By Ten
```bash
.\gradlew runLessByTen
```

### 5. Sorta Sum
```bash
.\gradlew runSortaSum
```

### 6. Dice (Jogo de Dados)
```bash
.\gradlew runDice
```

## 🧪 Executar Testes

```bash
.\gradlew test
```

Ver relatório de testes:
```
build/reports/tests/test/index.html
```

## 📦 Estrutura de Pacotes

```
org.desviante.exercicios
├── anobissexto                          # Verificador de ano bissexto
├── numbergenerators                     # Hierarquia de geradores de números
├── publication                          # Sistema de publicações
├── RecursionProgrammingExerciseLargest  # Maior elemento (recursão)
├── x01_sortasum                         # Somador especial
├── x02_in1To10                          # Verificador de intervalo 1-10
├── x03_lessbyten                        # Verificador de diferenças
└── programmazione                       # Exercícios do curso Programmazione OOP
    ├── dice                             # Jogo de dados
    └── student                          # Sistema de estudantes
```

## 📝 Adicionando Novos Exercícios

1. Crie um novo pacote em `src/main/java/org/desviante/exercicios/[nome]`
2. Adicione suas classes com a declaração de pacote:
   ```java
   package org.desviante.exercicios.[nome];
   ```
3. Se tiver testes, crie em `src/test/java/org/desviante/exercicios/[nome]`
4. Adicione uma tarefa de execução no `build.gradle.kts`:
   ```kotlin
   tasks.register("run[Nome]", JavaExec::class) {
       group = "exercicios"
       description = "Executa o exercício [Nome]"
       mainClass.set("org.desviante.exercicios.[nome].Main")
       classpath = sourceSets["main"].runtimeClasspath
   }
   ```

## 🔧 Comandos Úteis do Gradle

| Comando | Descrição |
|---------|-----------|
| `.\gradlew tasks` | Lista todas as tarefas disponíveis |
| `.\gradlew clean` | Limpa arquivos compilados |
| `.\gradlew build` | Compila e testa o projeto |
| `.\gradlew test` | Executa apenas os testes |
| `.\gradlew tasks --group exercicios` | Lista apenas tarefas de exercícios |

## 📖 Documentação Completa

Consulte o arquivo [README.md](README.md) para documentação completa.

## ⚙️ Requisitos

- Java 17 ou superior
- Gradle 8.x (wrapper incluído no projeto)

## 🐛 Solução de Problemas

### Erro de compilação
```bash
.\gradlew clean build
```

### Daemon do Gradle travado
```bash
.\gradlew --stop
```

### Ver informações detalhadas
```bash
.\gradlew build --info
```


# Testes Unitários - Recursion: Largest

## 📊 Resumo dos Testes

- **Total de testes:** 19
- **Testes passando:** 19 ✅
- **Testes falhando:** 0
- **Taxa de sucesso:** 100%

## 🧪 Casos de Teste Implementados

### 1. Casos Básicos

#### ✅ Exemplo Fornecido
- **Teste:** `testExemploFornecido()`
- **Entrada:** `{2, 4, 8}`, index = 2
- **Esperado:** 8
- **Descrição:** Testa o exemplo fornecido no enunciado

#### ✅ Array de Um Elemento
- **Teste:** `testArrayUmElemento()`
- **Entrada:** `{5}`, index = 0
- **Esperado:** 5
- **Descrição:** Testa o caso base com apenas um elemento

#### ✅ Array de Dois Elementos
- **Teste:** `testArrayDoisElementos()`
- **Entrada:** `{3, 9}`, index = 1
- **Esperado:** 9
- **Descrição:** Testa array com dois elementos

### 2. Posicionamento do Maior Elemento

#### ✅ Maior no Início
- **Teste:** `testMaiorNoInicio()`
- **Entrada:** `{10, 5, 3, 1}`, index = 3
- **Esperado:** 10
- **Descrição:** Maior elemento está na primeira posição

#### ✅ Maior no Meio
- **Teste:** `testMaiorNoMeio()`
- **Entrada:** `{5, 15, 3, 7}`, index = 3
- **Esperado:** 15
- **Descrição:** Maior elemento está no meio do array

#### ✅ Maior no Final
- **Teste:** `testMaiorNoFinal()`
- **Entrada:** `{1, 3, 5, 20}`, index = 3
- **Esperado:** 20
- **Descrição:** Maior elemento está na última posição

### 3. Números Especiais

#### ✅ Números Negativos
- **Teste:** `testNumerosNegativos()`
- **Entrada:** `{-10, -5, -20, -3}`, index = 3
- **Esperado:** -3
- **Descrição:** Todos os números são negativos

#### ✅ Números Misturados
- **Teste:** `testNumerosMisturados()`
- **Entrada:** `{-5, 10, -20, 3, 0}`, index = 4
- **Esperado:** 10
- **Descrição:** Array com positivos, negativos e zero

#### ✅ Array com Zero
- **Teste:** `testComZero()`
- **Entrada:** `{0, -5, -10}`, index = 2
- **Esperado:** 0
- **Descrição:** Zero é o maior elemento

#### ✅ Números Grandes
- **Teste:** `testNumerosGrandes()`
- **Entrada:** `{1000000, 999999, 1000001, 500000}`, index = 3
- **Esperado:** 1000001
- **Descrição:** Testa com números muito grandes

#### ✅ Integer.MAX_VALUE
- **Teste:** `testIntegerMaxValue()`
- **Entrada:** `{100, Integer.MAX_VALUE, 50}`, index = 2
- **Esperado:** Integer.MAX_VALUE
- **Descrição:** Testa o limite superior de int

#### ✅ Integer.MIN_VALUE
- **Teste:** `testIntegerMinValue()`
- **Entrada:** `{Integer.MIN_VALUE, -1000, -500}`, index = 2
- **Esperado:** -500
- **Descrição:** Testa o limite inferior de int

### 4. Casos Especiais

#### ✅ Elementos Iguais
- **Teste:** `testElementosIguais()`
- **Entrada:** `{7, 7, 7, 7}`, index = 3
- **Esperado:** 7
- **Descrição:** Todos elementos com o mesmo valor

#### ✅ Valores Duplicados
- **Teste:** `testValoresDuplicados()`
- **Entrada:** `{3, 8, 5, 8, 2}`, index = 4
- **Esperado:** 8
- **Descrição:** Maior valor aparece mais de uma vez

### 5. Arrays Ordenados

#### ✅ Ordenado Crescente
- **Teste:** `testArrayOrdenadoCrescente()`
- **Entrada:** `{1, 2, 3, 4, 5}`, index = 4
- **Esperado:** 5
- **Descrição:** Array em ordem crescente

#### ✅ Ordenado Decrescente
- **Teste:** `testArrayOrdenadoDecrescente()`
- **Entrada:** `{10, 8, 6, 4, 2}`, index = 4
- **Esperado:** 10
- **Descrição:** Array em ordem decrescente

### 6. Testes de Recursão

#### ✅ Índice Intermediário
- **Teste:** `testComIndiceIntermediario()`
- **Entrada:** `{1, 5, 3, 10, 2}`, index = 2
- **Esperado:** 5
- **Descrição:** Busca apenas nos primeiros 3 elementos

#### ✅ Índice Zero
- **Teste:** `testIndexZero()`
- **Entrada:** `{42, 10, 5}`, index = 0
- **Esperado:** 42
- **Descrição:** Caso base quando index é 0

#### ✅ Array Grande
- **Teste:** `testArrayGrande()`
- **Entrada:** Array de 100 elementos com maior = 200 no meio
- **Esperado:** 200
- **Descrição:** Testa recursão profunda

## 🔍 Cobertura de Testes

### Categorias Testadas:
- ✅ Casos base da recursão
- ✅ Casos recursivos normais
- ✅ Limites de valores (Integer.MAX_VALUE, Integer.MIN_VALUE)
- ✅ Arrays de diferentes tamanhos (1 a 100 elementos)
- ✅ Diferentes posições do maior elemento
- ✅ Números positivos, negativos e zero
- ✅ Arrays ordenados e desordenados
- ✅ Valores duplicados
- ✅ Índices intermediários

## 🚀 Como Executar os Testes

### Executar todos os testes:
```bash
.\gradlew test
```

### Executar apenas os testes do exercício Largest:
```bash
.\gradlew test --tests "*RecursionProgrammingExerciseLargest*"
```

### Ver relatório HTML:
```
build/reports/tests/test/index.html
```

### Ver resultados XML:
```
build/test-results/test/TEST-org.desviante.exercicios.RecursionProgrammingExerciseLargest.MainTest.xml
```

## 📈 Resultado dos Testes

```
Tests run: 19
Failures: 0
Errors: 0
Skipped: 0
Success rate: 100%
```

## ✅ Conclusão

Todos os 19 testes unitários foram implementados com sucesso e estão passando. A suíte de testes cobre:
- Casos básicos e extremos
- Validação da recursão
- Limites de valores
- Diferentes configurações de arrays
- Casos especiais (duplicatas, valores iguais, etc.)

A implementação do método `largest` está correta e passa em todos os cenários testados! 🎉


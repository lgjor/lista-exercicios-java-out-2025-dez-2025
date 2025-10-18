# 🧪 Testes Unitários - In1To10

## ✅ Implementação Concluída com Sucesso!

Foram implementados **26 testes unitários** completos para o método `in1To10()` que verifica se um número está no intervalo 1-10 com dois modos de operação.

## 📊 Estatísticas

| Métrica | Valor |
|---------|-------|
| **Testes Implementados** | 26 |
| **Testes Passando** | 26 ✅ |
| **Testes Falhando** | 0 |
| **Taxa de Sucesso** | 100% |
| **Tempo de Execução** | ~0.064s |

## 🎯 Sobre o Exercício

### Modo Normal (outsideMode = false)
Retorna `true` se o número está entre 1 e 10 (inclusive).

### Modo Outside (outsideMode = true)
Retorna `true` se o número é menor ou igual a 1, OU maior ou igual a 10.

## 📋 Categorias de Testes

### 1. **Testes Modo Normal** (10 testes)
- ✅ Exemplo fornecido (11 → false)
- ✅ Meio do intervalo (5 → true)
- ✅ Limite inferior (1 → true)
- ✅ Limite superior (10 → true)
- ✅ Zero (0 → false)
- ✅ Números negativos (false)
- ✅ Fora do limite superior (12 → false)
- ✅ Intervalo completo 2-9 (true)
- ✅ Números muito grandes (false)
- ✅ Números muito pequenos (false)

### 2. **Testes Modo Outside** (10 testes)
- ✅ Exemplo fornecido (11 → true)
- ✅ Meio do intervalo (5 → false)
- ✅ Limite inferior (1 → true)
- ✅ Limite superior (10 → true)
- ✅ Zero (0 → true)
- ✅ Números negativos (true)
- ✅ Fora do limite superior (12 → true)
- ✅ Intervalo 2-9 (false)
- ✅ Números muito grandes (true)
- ✅ Números muito pequenos (true)

### 3. **Testes de Limites** (2 testes)
- ✅ Valor 2 em ambos os modos
- ✅ Valor 9 em ambos os modos

### 4. **Casos Especiais** (2 testes)
- ✅ Integer.MAX_VALUE
- ✅ Integer.MIN_VALUE

### 5. **Comportamento e Tabela de Verdade** (2 testes)
- ✅ Mesmo número, resultados opostos nos diferentes modos
- ✅ Tabela de verdade completa com 9 valores-chave

## 🔍 Tabela de Verdade Testada

| Valor | Modo Normal | Modo Outside | Descrição |
|-------|-------------|--------------|-----------|
| -10   | false       | true         | Muito pequeno |
| 0     | false       | true         | Abaixo do intervalo |
| 1     | true        | true         | Limite inferior (inclusivo ambos) |
| 2     | true        | false        | Dentro do intervalo |
| 5     | true        | false        | Meio do intervalo |
| 9     | true        | false        | Dentro do intervalo |
| 10    | true        | true         | Limite superior (inclusivo ambos) |
| 11    | false       | true         | Acima do intervalo |
| 50    | false       | true         | Muito grande |

## 🧪 Exemplos de Testes

### Teste 1: Exemplo do Enunciado (Modo Normal)
```java
@Test
void testModoNormal_11_RetornaFalse() {
    assertFalse(in1To10.in1To10(11, false));
}
```

### Teste 2: Exemplo do Enunciado (Modo Outside)
```java
@Test
void testModoOutside_11_RetornaTrue() {
    assertTrue(in1To10.in1To10(11, true));
}
```

### Teste 3: Intervalo Completo (Modo Normal)
```java
@Test
void testModoNormal_IntervaloCompleto_RetornaTrue() {
    for (int i = 2; i <= 9; i++) {
        assertTrue(in1To10.in1To10(i, false));
    }
}
```

### Teste 4: Tabela de Verdade
```java
@Test
void testTabelaVerdade() {
    Object[][] casos = {
        {1, true, true},
        {5, true, false},
        {10, true, true},
        {11, false, true}
    };
    
    for (Object[] caso : casos) {
        int valor = (int) caso[0];
        boolean esperadoNormal = (boolean) caso[1];
        boolean esperadoOutside = (boolean) caso[2];
        
        assertEquals(esperadoNormal, in1To10.in1To10(valor, false));
        assertEquals(esperadoOutside, in1To10.in1To10(valor, true));
    }
}
```

## 🚀 Como Executar

### Executar apenas os testes do In1To10:
```bash
.\gradlew test --tests "*in1To10*"
```

### Executar todos os testes do projeto:
```bash
.\gradlew test
```

### Ver relatório HTML:
```bash
start build/reports/tests/test/index.html
```

## 📈 Cobertura de Testes

### Categorias Testadas:
- ✅ Modo normal (outsideMode = false)
- ✅ Modo outside (outsideMode = true)
- ✅ Limites do intervalo (1 e 10)
- ✅ Valores dentro do intervalo (2-9)
- ✅ Valores fora do intervalo (< 1 e > 10)
- ✅ Números negativos
- ✅ Zero
- ✅ Números muito grandes e muito pequenos
- ✅ Integer.MAX_VALUE e MIN_VALUE
- ✅ Comportamento dual dos modos

## 📊 Resultados dos Testes

```
Tests run: 26
Failures: 0
Errors: 0
Skipped: 0
Success rate: 100%
Time: ~0.064s
```

## 🎓 Conceitos Testados

- ✅ Lógica booleana (condições AND/OR)
- ✅ Intervalos inclusivos
- ✅ Modos de operação (normal vs outside)
- ✅ Limites de valores
- ✅ Casos extremos (edge cases)
- ✅ Tabela de verdade
- ✅ Testes parametrizados
- ✅ Dualidade de comportamento

## 📝 Observações Importantes

1. **Limites Inclusivos**: Os valores 1 e 10 são **inclusivos** em ambos os modos
2. **Modo Normal**: Intervalo fechado [1, 10]
3. **Modo Outside**: União de dois intervalos (-∞, 1] ∪ [10, +∞)
4. **Comportamento Dual**: Valores entre 2-9 têm comportamentos opostos nos dois modos

## 📁 Arquivos do Projeto

```
in1To10/
├── In1To10.java              # Implementação do método
├── readme.md                  # Descrição do exercício
└── test/
    ├── In1To10Test.java      # 26 testes unitários
    └── README_TESTES.md      # Este arquivo
```

## 📈 Resumo do Projeto Total

O projeto agora possui **60 testes unitários** no total:

| Exercício | Testes | Status |
|-----------|--------|--------|
| LessByTen | 11 | ✅ 100% |
| SortaSum | 4 | ✅ 100% |
| Largest (Recursão) | 19 | ✅ 100% |
| **In1To10** | **26** | ✅ **100%** |
| **TOTAL** | **60** | ✅ **100%** |

## ✨ Destaques

- ✅ **26 testes abrangentes** cobrindo todos os cenários
- ✅ **Dois modos de operação** testados completamente
- ✅ **Tabela de verdade** implementada como teste
- ✅ **Mensagens descritivas** facilitando debugging
- ✅ **Casos extremos** (MIN_VALUE, MAX_VALUE)
- ✅ **Testes parametrizados** usando loops
- ✅ **100% de sucesso** em todos os testes

## 🏆 Conclusão

A implementação do método `in1To10()` está **100% testada e validada**!

Todos os testes passam com sucesso, garantindo que o algoritmo funciona corretamente para:
- ✅ Ambos os modos de operação (normal e outside)
- ✅ Todos os limites do intervalo (1 e 10)
- ✅ Valores dentro e fora do intervalo
- ✅ Números negativos, zero e positivos
- ✅ Valores extremos (MIN_VALUE, MAX_VALUE)
- ✅ Comportamento dual correto

---

**Desenvolvido com JUnit 5** | **100% de Cobertura** | **60 Testes no Projeto Total** 🎉


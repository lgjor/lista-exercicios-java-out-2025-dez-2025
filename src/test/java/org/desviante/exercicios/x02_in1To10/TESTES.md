# Testes Unitários - In1To10

## 📊 Resumo dos Testes

- **Total de testes:** 26
- **Testes passando:** 26 ✅
- **Testes falhando:** 0
- **Taxa de sucesso:** 100%

## 🧪 Casos de Teste Implementados

### 1. Testes Modo Normal (outsideMode = false) - 10 testes

#### ✅ Exemplo do Enunciado
- **Teste:** `testModoNormal_11_RetornaFalse()`
- **Entrada:** n=11, outsideMode=false
- **Esperado:** false
- **Descrição:** 11 não está no intervalo 1-10

#### ✅ Meio do Intervalo
- **Teste:** `testModoNormal_5_RetornaTrue()`
- **Entrada:** n=5, outsideMode=false
- **Esperado:** true
- **Descrição:** 5 está no intervalo 1-10

#### ✅ Limite Inferior (Inclusivo)
- **Teste:** `testModoNormal_1_RetornaTrue()`
- **Entrada:** n=1, outsideMode=false
- **Esperado:** true
- **Descrição:** 1 é o limite inferior inclusivo

#### ✅ Limite Superior (Inclusivo)
- **Teste:** `testModoNormal_10_RetornaTrue()`
- **Entrada:** n=10, outsideMode=false
- **Esperado:** true
- **Descrição:** 10 é o limite superior inclusivo

#### ✅ Valor Zero
- **Teste:** `testModoNormal_0_RetornaFalse()`
- **Entrada:** n=0, outsideMode=false
- **Esperado:** false
- **Descrição:** 0 está fora do intervalo

#### ✅ Números Negativos
- **Teste:** `testModoNormal_Negativo_RetornaFalse()`
- **Entradas:** n=-5, n=-1, outsideMode=false
- **Esperado:** false
- **Descrição:** Números negativos estão fora do intervalo

#### ✅ Acima do Limite
- **Teste:** `testModoNormal_12_RetornaFalse()`
- **Entrada:** n=12, outsideMode=false
- **Esperado:** false
- **Descrição:** 12 está acima do limite superior

#### ✅ Intervalo Completo 2-9
- **Teste:** `testModoNormal_IntervaloCompleto_RetornaTrue()`
- **Entradas:** n=2,3,4,5,6,7,8,9, outsideMode=false
- **Esperado:** true para todos
- **Descrição:** Todos os valores dentro do intervalo

#### ✅ Números Muito Grandes
- **Teste:** `testModoNormal_NumeroGrande_RetornaFalse()`
- **Entradas:** n=100, n=1000, outsideMode=false
- **Esperado:** false
- **Descrição:** Números muito maiores que 10

#### ✅ Números Muito Pequenos
- **Teste:** `testModoNormal_NumeroPequeno_RetornaFalse()`
- **Entradas:** n=-100, n=-1000, outsideMode=false
- **Esperado:** false
- **Descrição:** Números muito menores que 1

### 2. Testes Modo Outside (outsideMode = true) - 10 testes

#### ✅ Exemplo do Enunciado
- **Teste:** `testModoOutside_11_RetornaTrue()`
- **Entrada:** n=11, outsideMode=true
- **Esperado:** true
- **Descrição:** 11 >= 10, satisfaz a condição outside

#### ✅ Meio do Intervalo
- **Teste:** `testModoOutside_5_RetornaFalse()`
- **Entrada:** n=5, outsideMode=true
- **Esperado:** false
- **Descrição:** 5 está entre 2-9, não satisfaz a condição outside

#### ✅ Limite Inferior
- **Teste:** `testModoOutside_1_RetornaTrue()`
- **Entrada:** n=1, outsideMode=true
- **Esperado:** true
- **Descrição:** 1 <= 1, satisfaz a condição outside

#### ✅ Limite Superior
- **Teste:** `testModoOutside_10_RetornaTrue()`
- **Entrada:** n=10, outsideMode=true
- **Esperado:** true
- **Descrição:** 10 >= 10, satisfaz a condição outside

#### ✅ Valor Zero
- **Teste:** `testModoOutside_0_RetornaTrue()`
- **Entrada:** n=0, outsideMode=true
- **Esperado:** true
- **Descrição:** 0 <= 1, satisfaz a condição outside

#### ✅ Números Negativos
- **Teste:** `testModoOutside_Negativo_RetornaTrue()`
- **Entradas:** n=-5, n=-1, outsideMode=true
- **Esperado:** true
- **Descrição:** Números negativos <= 1

#### ✅ Acima do Limite
- **Teste:** `testModoOutside_12_RetornaTrue()`
- **Entrada:** n=12, outsideMode=true
- **Esperado:** true
- **Descrição:** 12 >= 10, satisfaz a condição outside

#### ✅ Intervalo 2-9
- **Teste:** `testModoOutside_IntervaloInterno_RetornaFalse()`
- **Entradas:** n=2,3,4,5,6,7,8,9, outsideMode=true
- **Esperado:** false para todos
- **Descrição:** Valores entre 2-9 não satisfazem a condição outside

#### ✅ Números Muito Grandes
- **Teste:** `testModoOutside_NumeroGrande_RetornaTrue()`
- **Entradas:** n=100, n=1000, outsideMode=true
- **Esperado:** true
- **Descrição:** Números >= 10 satisfazem a condição

#### ✅ Números Muito Pequenos
- **Teste:** `testModoOutside_NumeroPequeno_RetornaTrue()`
- **Entradas:** n=-100, n=-1000, outsideMode=true
- **Esperado:** true
- **Descrição:** Números <= 1 satisfazem a condição

### 3. Testes de Limites - 2 testes

#### ✅ Valor 2 em Ambos os Modos
- **Teste:** `testLimites_Valor2()`
- **Entradas:** n=2 com ambos os modos
- **Esperado:** true (normal), false (outside)
- **Descrição:** 2 está no intervalo mas não satisfaz outside

#### ✅ Valor 9 em Ambos os Modos
- **Teste:** `testLimites_Valor9()`
- **Entradas:** n=9 com ambos os modos
- **Esperado:** true (normal), false (outside)
- **Descrição:** 9 está no intervalo mas não satisfaz outside

### 4. Casos Especiais - 2 testes

#### ✅ Integer.MAX_VALUE
- **Teste:** `testCasosEspeciais_IntegerMaxValue()`
- **Entradas:** Integer.MAX_VALUE com ambos os modos
- **Esperado:** false (normal), true (outside)
- **Descrição:** Maior valor possível de int

#### ✅ Integer.MIN_VALUE
- **Teste:** `testCasosEspeciais_IntegerMinValue()`
- **Entradas:** Integer.MIN_VALUE com ambos os modos
- **Esperado:** false (normal), true (outside)
- **Descrição:** Menor valor possível de int

### 5. Comportamento e Tabela de Verdade - 2 testes

#### ✅ Modos Diferentes, Resultados Opostos
- **Teste:** `testComportamento_ModosDiferentes()`
- **Entradas:** n=5 e n=15 com ambos os modos
- **Esperado:** Comportamentos opostos
- **Descrição:** Verifica a dualidade dos modos

#### ✅ Tabela de Verdade Completa
- **Teste:** `testTabelaVerdade()`
- **Entradas:** -10, 0, 1, 2, 5, 9, 10, 11, 50
- **Esperado:** Matriz de verdade completa
- **Descrição:** Testa 9 valores-chave com ambos os modos

## 📈 Tabela de Verdade

| Valor | Modo Normal | Modo Outside | Lógica |
|-------|-------------|--------------|--------|
| -10   | ❌ false    | ✅ true      | -10 <= 1 |
| 0     | ❌ false    | ✅ true      | 0 <= 1 |
| **1** | ✅ true     | ✅ true      | **Limite (inclusivo ambos)** |
| 2     | ✅ true     | ❌ false     | 1 < 2 < 10 |
| 5     | ✅ true     | ❌ false     | 1 < 5 < 10 |
| 9     | ✅ true     | ❌ false     | 1 < 9 < 10 |
| **10**| ✅ true     | ✅ true      | **Limite (inclusivo ambos)** |
| 11    | ❌ false    | ✅ true      | 11 >= 10 |
| 50    | ❌ false    | ✅ true      | 50 >= 10 |

## 🔍 Cobertura de Testes

### Categorias Testadas:
- ✅ Modo normal completo (10 testes)
- ✅ Modo outside completo (10 testes)
- ✅ Limites do intervalo (2 testes)
- ✅ Casos especiais (2 testes)
- ✅ Comportamento dual (2 testes)
- ✅ Valores negativos
- ✅ Zero
- ✅ Números grandes e pequenos
- ✅ Integer.MAX_VALUE e MIN_VALUE
- ✅ Intervalo completo 1-10
- ✅ Tabela de verdade

## 🚀 Como Executar os Testes

### Executar apenas os testes do In1To10:
```bash
.\gradlew test --tests "*in1To10*"
```

### Ver relatório HTML:
```
build/reports/tests/test/index.html
```

### Ver resultados XML:
```
build/test-results/test/TEST-org.desviante.exercicios.x02_in1To10.In1To10Test.xml
```

## 📈 Resultado dos Testes

```
Tests run: 26
Failures: 0
Errors: 0
Skipped: 0
Success rate: 100%
Time: ~0.064s
```

## ✅ Conclusão

Todos os 26 testes unitários foram implementados com sucesso e estão passando. A suíte de testes cobre:
- Ambos os modos de operação (normal e outside)
- Todos os limites e valores do intervalo
- Casos extremos (MIN_VALUE, MAX_VALUE)
- Comportamento dual dos dois modos
- Tabela de verdade completa

A implementação do método `in1To10` está correta e passa em todos os cenários testados! 🎉


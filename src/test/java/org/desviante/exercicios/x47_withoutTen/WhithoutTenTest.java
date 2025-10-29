package org.desviante.exercicios.x47_withoutTen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para o método withoutTen
 * Testa a função que remove todos os 10s do array e move os elementos restantes para a esquerda,
 * preenchendo o final do array com 0s
 */
@DisplayName("Testes para o método withoutTen")
class WhithoutTenTest {
    
    private WithoutTen withoutTen;
    
    @BeforeEach
    void setUp() {
        withoutTen = new WithoutTen();
    }
    
    // ==================== TESTES CASOS BÁSICOS ====================
    
    @Test
    @DisplayName("Caso básico: Deve remover 10s do exemplo fornecido")
    void testCasoBasico_ExemploFornecido() {
        int[] entrada = {1, 10, 10, 2};
        int[] esperado = {1, 2, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "{1, 10, 10, 2} deve resultar em {1, 2, 0, 0}");
    }
    
    @Test
    @DisplayName("Array sem 10s: Deve retornar o array original")
    void testArraySemDez_RetornaOriginal() {
        int[] entrada = {1, 2, 3, 4};
        int[] esperado = {1, 2, 3, 4};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array sem 10s deve permanecer inalterado");
    }
    
    @Test
    @DisplayName("Array apenas com 10s: Deve retornar array de zeros")
    void testArrayApenasDez_RetornaZeros() {
        int[] entrada = {10, 10, 10};
        int[] esperado = {0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array apenas com 10s deve resultar em array de zeros");
    }
    
    @Test
    @DisplayName("Array vazio: Deve retornar array vazio")
    void testArrayVazio_RetornaVazio() {
        int[] entrada = {};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(entrada, resultado, 
            "Array vazio deve retornar array vazio");
        assertEquals(0, resultado.length, 
            "Array vazio deve ter tamanho 0");
    }
    
    @Test
    @DisplayName("Array null: Deve retornar null")
    void testArrayNull_RetornaNull() {
        int[] entrada = null;
        int[] resultado = withoutTen.withoutTen(entrada);
        assertNull(resultado, 
            "Array null deve retornar null");
    }
    
    // ==================== TESTES COM UM ELEMENTO ====================
    
    @Test
    @DisplayName("Array com um elemento 10: Deve retornar [0]")
    void testUmElemento_10_RetornaZero() {
        int[] entrada = {10};
        int[] esperado = {0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array [10] deve resultar em [0]");
    }
    
    @Test
    @DisplayName("Array com um elemento diferente de 10: Deve retornar o elemento")
    void testUmElemento_NaoDez_RetornaElemento() {
        int[] entrada = {5};
        int[] esperado = {5};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array [5] deve permanecer [5]");
    }
    
    // ==================== TESTES COM 10s NO INÍCIO ====================
    
    @Test
    @DisplayName("10s no início: Deve mover elementos para frente")
    void testDezNoInicio_MoveElementos() {
        int[] entrada = {10, 1, 2, 3};
        int[] esperado = {1, 2, 3, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s no início devem ser removidos e elementos movidos para frente");
    }
    
    @Test
    @DisplayName("10s no início: Deve preencher com zeros no final")
    void testDezNoInicio_PreencheZeros() {
        int[] entrada = {10, 10, 1};
        int[] esperado = {1, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s no início devem ser removidos e final preenchido com zeros");
    }
    
    // ==================== TESTES COM 10s NO MEIO ====================
    
    @Test
    @DisplayName("10s no meio: Deve mover elementos para esquerda")
    void testDezNoMeio_MoveElementos() {
        int[] entrada = {1, 10, 2, 10, 3};
        int[] esperado = {1, 2, 3, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s no meio devem ser removidos e elementos movidos para esquerda");
    }
    
    @Test
    @DisplayName("10s consecutivos no meio: Deve remover todos")
    void testDezConsecutivosNoMeio_RemoveTodos() {
        int[] entrada = {1, 10, 10, 10, 2};
        int[] esperado = {1, 2, 0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s consecutivos no meio devem ser todos removidos");
    }
    
    // ==================== TESTES COM 10s NO FINAL ====================
    
    @Test
    @DisplayName("10s no final: Deve substituir por zeros")
    void testDezNoFinal_SubstituiPorZeros() {
        int[] entrada = {1, 2, 3, 10};
        int[] esperado = {1, 2, 3, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10 no final deve ser substituído por 0");
    }
    
    @Test
    @DisplayName("10s consecutivos no final: Deve substituir todos por zeros")
    void testDezConsecutivosNoFinal_SubstituiTodosPorZeros() {
        int[] entrada = {1, 2, 10, 10, 10};
        int[] esperado = {1, 2, 0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s consecutivos no final devem ser substituídos por zeros");
    }
    
    // ==================== TESTES COM NÚMEROS NEGATIVOS ====================
    
    @Test
    @DisplayName("Array com números negativos: Não deve remover -10")
    void testNumerosNegativos_NaoRemoveMenosDez() {
        int[] entrada = {-10, -1, -5};
        int[] esperado = {-10, -1, -5};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "-10 não deve ser removido, apenas 10");
    }
    
    @Test
    @DisplayName("Array misto: Deve remover apenas 10 positivo")
    void testArrayMisto_RemoveApenasDezPositivo() {
        int[] entrada = {-10, 10, 0, 10};
        int[] esperado = {-10, 0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Apenas 10 positivo deve ser removido, -10 e 0 devem permanecer");
    }
    
    // ==================== TESTES COM ZEROS ====================
    
    @Test
    @DisplayName("Array com zeros: Zeros existentes devem permanecer")
    void testArrayComZeros_ZerosPermanem() {
        int[] entrada = {0, 1, 10, 2, 0};
        int[] esperado = {0, 1, 2, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Zeros existentes devem permanecer, apenas 10s são removidos");
    }
    
    @Test
    @DisplayName("Array apenas com zeros: Deve retornar zeros")
    void testArrayApenasZeros_RetornaZeros() {
        int[] entrada = {0, 0, 0};
        int[] esperado = {0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array apenas com zeros deve permanecer inalterado");
    }
    
    // ==================== TESTES COM NÚMEROS GRANDES ====================
    
    @Test
    @DisplayName("Array com números grandes: Deve funcionar corretamente")
    void testNumerosGrandes_FuncionaCorretamente() {
        int[] entrada = {100, 10, 1000, 10, 200};
        int[] esperado = {100, 1000, 200, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Deve funcionar com números grandes");
    }
    
    // ==================== TESTES CASOS ESPECIAIS ====================
    
    @Test
    @DisplayName("Todos os elementos diferentes de 10: Nenhuma alteração")
    void testTodosElementosDiferentesDez_NenhumaAlteracao() {
        int[] entrada = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] esperado = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Array sem 10s deve permanecer inalterado");
    }
    
    @Test
    @DisplayName("10s intercalados: Deve remover todos")
    void testDezIntercalados_RemoveTodos() {
        int[] entrada = {1, 10, 2, 10, 3, 10, 4};
        int[] esperado = {1, 2, 3, 4, 0, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "10s intercalados devem ser todos removidos");
    }
    
    @Test
    @DisplayName("Array com duplicatas de outros números: Deve preservar duplicatas")
    void testDuplicatas_DevePreservar() {
        int[] entrada = {1, 1, 10, 2, 2, 10};
        int[] esperado = {1, 1, 2, 2, 0, 0};
        int[] resultado = withoutTen.withoutTen(entrada);
        assertArrayEquals(esperado, resultado, 
            "Duplicatas de outros números devem ser preservadas");
    }
}

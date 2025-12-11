package org.desviante.exercicios.x20_loneSum;

import org.desviante.exercicios.CodeWorkout.x20_loneSum.LoneSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para LoneSum")
public class LoneSumTest {

	private final LoneSum loneSum = new LoneSum();

	@Test
	@DisplayName("deve retornar a soma quando todos os valores são diferentes")
	void testTodosDiferentes() {
		assertEquals(6, loneSum.loneSum(1, 2, 3));   // 1 + 2 + 3 = 6
		assertEquals(9, loneSum.loneSum(2, 3, 4));   // 2 + 3 + 4 = 9
		assertEquals(15, loneSum.loneSum(4, 5, 6));  // 4 + 5 + 6 = 15
		assertEquals(0, loneSum.loneSum(-1, 0, 1));  // -1 + 0 + 1 = 0
	}

	@Test
	@DisplayName("deve retornar 0 quando todos os valores são iguais")
	void testTodosIguais() {
		assertEquals(0, loneSum.loneSum(3, 3, 3));   // todos iguais
		assertEquals(0, loneSum.loneSum(1, 1, 1));   // todos iguais
		assertEquals(0, loneSum.loneSum(0, 0, 0));   // todos iguais
		assertEquals(0, loneSum.loneSum(-5, -5, -5)); // todos iguais (negativo)
	}

	@Test
	@DisplayName("deve retornar c quando a e b são iguais")
	void testAeBIguais() {
		assertEquals(5, loneSum.loneSum(2, 2, 5));   // a = b, retorna c
		assertEquals(10, loneSum.loneSum(3, 3, 10)); // a = b, retorna c
		assertEquals(0, loneSum.loneSum(1, 1, 0));   // a = b, retorna c = 0
		assertEquals(-3, loneSum.loneSum(4, 4, -3)); // a = b, retorna c negativo
	}

	@Test
	@DisplayName("deve retornar b quando a e c são iguais")
	void testAeCIguais() {
		assertEquals(2, loneSum.loneSum(3, 2, 3));   // a = c, retorna b
		assertEquals(7, loneSum.loneSum(5, 7, 5));   // a = c, retorna b
		assertEquals(0, loneSum.loneSum(2, 0, 2));   // a = c, retorna b = 0
		assertEquals(-1, loneSum.loneSum(3, -1, 3)); // a = c, retorna b negativo
	}

	@Test
	@DisplayName("deve retornar a quando b e c são iguais")
	void testBeCIguais() {
		assertEquals(3, loneSum.loneSum(3, 2, 2));   // b = c, retorna a
		assertEquals(8, loneSum.loneSum(8, 5, 5));   // b = c, retorna a
		assertEquals(0, loneSum.loneSum(0, 4, 4));   // b = c, retorna a = 0
		assertEquals(-2, loneSum.loneSum(-2, 6, 6)); // b = c, retorna a negativo
	}

	@Test
	@DisplayName("deve funcionar com valores zero")
	void testComZero() {
		assertEquals(3, loneSum.loneSum(0, 1, 2));   // um zero, todos diferentes
		assertEquals(5, loneSum.loneSum(0, 0, 5));   // dois zeros (a = b), retorna c
		assertEquals(5, loneSum.loneSum(0, 5, 0));   // dois zeros (a = c), retorna b
		assertEquals(5, loneSum.loneSum(5, 0, 0));   // dois zeros (b = c), retorna a
	}

	@Test
	@DisplayName("deve funcionar com valores negativos")
	void testComNegativos() {
		assertEquals(-6, loneSum.loneSum(-1, -2, -3)); // todos diferentes e negativos
		assertEquals(-5, loneSum.loneSum(-5, 2, 2));   // b = c, retorna a negativo
		assertEquals(3, loneSum.loneSum(-2, 3, -2));   // a = c negativo, retorna b
		assertEquals(8, loneSum.loneSum(-4, -4, 8));   // a = b negativo, retorna c
	}

	@Test
	@DisplayName("deve funcionar com números grandes")
	void testComGrandes() {
		assertEquals(0, loneSum.loneSum(1000, 1000, 1000));    // todos iguais retorna 0
		assertEquals(1000, loneSum.loneSum(1000, 2000, 2000)); // b = c, retorna a
		assertEquals(6000, loneSum.loneSum(1000, 2000, 3000)); // todos diferentes
		assertEquals(999, loneSum.loneSum(999, 500, 500));     // b = c, retorna a
	}

	@Test
	@DisplayName("deve funcionar com casos mistos positivos e negativos")
	void testMistos() {
		assertEquals(0, loneSum.loneSum(-3, 3, 0));  // todos diferentes, soma = 0
		assertEquals(5, loneSum.loneSum(-2, 5, -2)); // a = c, retorna b
		assertEquals(-10, loneSum.loneSum(-10, 4, 4)); // b = c, retorna a negativo
	}
}

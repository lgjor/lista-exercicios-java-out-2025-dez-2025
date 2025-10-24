package org.desviante.exercicios.x21_luckySum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para LuckySum")
public class LuckySumTest {

	private final LuckySum luckySum = new LuckySum();

	@Test
	@DisplayName("Deve retornar a soma dos 3 números quando não há 13")
	void testSemTreze() {
		assertEquals(6, luckySum.luckySum(1, 2, 3));    // 1 + 2 + 3 = 6
		assertEquals(12, luckySum.luckySum(4, 5, 3));   // 4 + 5 + 3 = 12
		assertEquals(15, luckySum.luckySum(5, 5, 5));   // 5 + 5 + 5 = 15
		assertEquals(0, luckySum.luckySum(0, 0, 0));    // 0 + 0 + 0 = 0
	}

	@Test
	@DisplayName("Deve retornar 0 quando a é 13")
	void testAIgualATreze() {
		assertEquals(0, luckySum.luckySum(13, 2, 3));   // a = 13, ignora tudo
		assertEquals(0, luckySum.luckySum(13, 5, 7));   // a = 13, ignora tudo
		assertEquals(0, luckySum.luckySum(13, 0, 0));   // a = 13, ignora tudo
		assertEquals(0, luckySum.luckySum(13, 13, 13)); // a = 13, ignora tudo
	}

	@Test
	@DisplayName("Deve retornar A quando B é 13")
	void testBIgualATreze() {
		assertEquals(1, luckySum.luckySum(1, 13, 3));   // b = 13, retorna apenas a
		assertEquals(5, luckySum.luckySum(5, 13, 7));   // b = 13, retorna apenas a
		assertEquals(0, luckySum.luckySum(0, 13, 5));   // b = 13, retorna apenas a = 0
		assertEquals(10, luckySum.luckySum(10, 13, 13)); // b = 13, retorna apenas a
	}

	@Test
	@DisplayName("Deve retornar A + B quando C é 13")
	void testCIgualATreze() {
		assertEquals(3, luckySum.luckySum(1, 2, 13));   // c = 13, retorna a + b
		assertEquals(12, luckySum.luckySum(5, 7, 13));  // c = 13, retorna a + b
		assertEquals(0, luckySum.luckySum(0, 0, 13));   // c = 13, retorna a + b = 0
		assertEquals(15, luckySum.luckySum(8, 7, 13));  // c = 13, retorna a + b
	}

	@Test
	@DisplayName("Deve funcionar com valores negativos")
	void testComNegativos() {
		assertEquals(-6, luckySum.luckySum(-1, -2, -3)); // sem 13, soma normal
		assertEquals(0, luckySum.luckySum(13, -5, -7));  // a = 13, retorna 0
		assertEquals(-5, luckySum.luckySum(-5, 13, 10)); // b = 13, retorna a
		assertEquals(-3, luckySum.luckySum(-1, -2, 13)); // c = 13, retorna a + b
	}

	@Test
	@DisplayName("Deve funcionar com números próximos de 13")
	void testProximoDeTreze() {
		assertEquals(23, luckySum.luckySum(12, 11, 13)); // c = 13, retorna 12 + 11 = 23
		assertEquals(12, luckySum.luckySum(12, 13, 14)); // b = 13, retorna 12
		assertEquals(26, luckySum.luckySum(12, 14, 13)); // c = 13, retorna 12 + 14 = 26
		assertEquals(42, luckySum.luckySum(14, 14, 14)); // sem 13, soma normal = 42
	}

	@Test
	@DisplayName("Deve funcionar com zeros")
	void testComZeros() {
		assertEquals(0, luckySum.luckySum(0, 0, 0));    // todos zero, sem 13
		assertEquals(0, luckySum.luckySum(13, 0, 0));   // a = 13, retorna 0
		assertEquals(0, luckySum.luckySum(0, 13, 0));   // b = 13, retorna a = 0
		assertEquals(0, luckySum.luckySum(0, 0, 13));   // c = 13, retorna a + b = 0
	}

	@Test
	@DisplayName("Deve funcionar com números grandes")
	void testComGrandes() {
		assertEquals(3000, luckySum.luckySum(1000, 1000, 1000)); // sem 13, soma normal
		assertEquals(0, luckySum.luckySum(13, 1000, 1000));      // a = 13, retorna 0
		assertEquals(1000, luckySum.luckySum(1000, 13, 1000));   // b = 13, retorna a
		assertEquals(2000, luckySum.luckySum(1000, 1000, 13));   // c = 13, retorna a + b
	}

	@Test
	@DisplayName("Deve funcionar com exemplo do readme")
	void testExemploReadme() {
		// Se b for 13, então ambos b e c não contam
		assertEquals(5, luckySum.luckySum(5, 13, 10));  // retorna apenas 5
		assertEquals(8, luckySum.luckySum(8, 13, 20));  // retorna apenas 8
	}

	@Test
	@DisplayName("Deve funcionar com múltiplos 13")
	void testMultiplosTreze() {
		assertEquals(0, luckySum.luckySum(13, 13, 5));   // a = 13, ignora tudo
		assertEquals(0, luckySum.luckySum(13, 5, 13));   // a = 13, ignora tudo
		assertEquals(5, luckySum.luckySum(5, 13, 13));   // b = 13, retorna a
		assertEquals(0, luckySum.luckySum(13, 13, 13));  // todos 13, retorna 0
	}
}

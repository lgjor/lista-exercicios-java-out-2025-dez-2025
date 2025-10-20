package org.desviante.exercicios.x25_evenlySpaced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para EvenlySpaced")
public class EvenlySpacedTest {

	private final EvenlySpaced evenlySpaced = new EvenlySpaced();

	// Interface funcional para testar diferentes implementações
	@FunctionalInterface
	interface EvenlySpacedFunction {
		boolean test(int a, int b, int c);
	}

	// Método auxiliar que executa todos os testes para uma implementação específica
	private void testarImplementacao(EvenlySpacedFunction funcao, String nomeMetodo) {
		// Casos onde os valores estão igualmente espaçados - deve retornar true
		assertTrue(funcao.test(2, 4, 6), nomeMetodo + ": (2, 4, 6) deve ser igualmente espaçado");
		assertTrue(funcao.test(4, 6, 2), nomeMetodo + ": (4, 6, 2) deve ser igualmente espaçado");
		assertTrue(funcao.test(6, 2, 4), nomeMetodo + ": (6, 2, 4) deve ser igualmente espaçado");
		assertTrue(funcao.test(10, 15, 20), nomeMetodo + ": (10, 15, 20) deve ser igualmente espaçado");
		assertTrue(funcao.test(5, 10, 15), nomeMetodo + ": (5, 10, 15) deve ser igualmente espaçado");

		// Casos onde os valores NÃO estão igualmente espaçados - deve retornar false
		assertFalse(funcao.test(2, 4, 7), nomeMetodo + ": (2, 4, 7) não deve ser igualmente espaçado");
		assertFalse(funcao.test(6, 5, 9), nomeMetodo + ": (6, 5, 9) não deve ser igualmente espaçado");
		assertFalse(funcao.test(1, 2, 10), nomeMetodo + ": (1, 2, 10) não deve ser igualmente espaçado");

		// Todos os valores iguais - deve retornar true (espaçamento 0)
		assertTrue(funcao.test(5, 5, 5), nomeMetodo + ": (5, 5, 5) valores iguais devem ser igualmente espaçados");
		assertTrue(funcao.test(0, 0, 0), nomeMetodo + ": (0, 0, 0) valores iguais devem ser igualmente espaçados");

		// Valores com negativos
		assertTrue(funcao.test(-2, 0, 2), nomeMetodo + ": (-2, 0, 2) deve ser igualmente espaçado");
		assertTrue(funcao.test(0, 2, -2), nomeMetodo + ": (0, 2, -2) deve ser igualmente espaçado");
		assertTrue(funcao.test(-10, -5, 0), nomeMetodo + ": (-10, -5, 0) deve ser igualmente espaçado");
		assertFalse(funcao.test(-10, -5, 5), nomeMetodo + ": (-10, -5, 5) não deve ser igualmente espaçado");

		// Espaçamento de 1
		assertTrue(funcao.test(1, 2, 3), nomeMetodo + ": (1, 2, 3) deve ser igualmente espaçado");
		assertTrue(funcao.test(3, 1, 2), nomeMetodo + ": (3, 1, 2) deve ser igualmente espaçado");
		assertTrue(funcao.test(10, 11, 12), nomeMetodo + ": (10, 11, 12) deve ser igualmente espaçado");

		// Espaçamento grande
		assertTrue(funcao.test(0, 50, 100), nomeMetodo + ": (0, 50, 100) deve ser igualmente espaçado");
		assertTrue(funcao.test(100, 50, 0), nomeMetodo + ": (100, 50, 0) deve ser igualmente espaçado");

		// Casos onde dois valores são iguais mas o terceiro é diferente
		assertFalse(funcao.test(5, 5, 10), nomeMetodo + ": (5, 5, 10) não deve ser igualmente espaçado");
		assertFalse(funcao.test(10, 5, 5), nomeMetodo + ": (10, 5, 5) não deve ser igualmente espaçado");
		assertFalse(funcao.test(5, 10, 5), nomeMetodo + ": (5, 10, 5) não deve ser igualmente espaçado");
	}

	@Nested
	@DisplayName("Testes para evenlySpacedFirstTry")
	class TestarFirstTry {
		@Test
		@DisplayName("Deve validar todos os casos para evenlySpacedFirstTry")
		void deveValidarTodosOsCasos() {
			testarImplementacao(evenlySpaced::evenlySpacedFirstTry, "evenlySpacedFirstTry");
		}
	}

	@Nested
	@DisplayName("Testes para evenlySpaced")
	class TestarEvenlySpaced {
		@Test
		@DisplayName("Deve validar todos os casos para evenlySpaced")
		void deveValidarTodosOsCasos() {
			testarImplementacao(evenlySpaced::evenlySpaced, "evenlySpaced");
		}
	}

	@Nested
	@DisplayName("Testes para evenlySpacedThirdTry")
	class TestarThirdTry {
		@Test
		@DisplayName("Deve validar todos os casos para evenlySpacedThirdTry")
		void deveValidarTodosOsCasos() {
			testarImplementacao(evenlySpaced::evenlySpacedThirdTry, "evenlySpacedThirdTry");
		}
	}

	@Test
	@DisplayName("Deve testar casos específicos do problema")
	void deveTestarCasosEspecificos() {
		// Testa todos os métodos com os mesmos casos específicos
		
		// (2, 4, 6) está igualmente espaçado (diferença de 2)
		assertTrue(evenlySpaced.evenlySpacedFirstTry(2, 4, 6));
		assertTrue(evenlySpaced.evenlySpaced(2, 4, 6));
		assertTrue(evenlySpaced.evenlySpacedThirdTry(2, 4, 6));

		// (4, 6, 2) também está igualmente espaçado (ordenado: 2, 4, 6)
		assertTrue(evenlySpaced.evenlySpacedFirstTry(4, 6, 2));
		assertTrue(evenlySpaced.evenlySpaced(4, 6, 2));
		assertTrue(evenlySpaced.evenlySpacedThirdTry(4, 6, 2));

		// (4, 6, 3) NÃO está igualmente espaçado (ordenado: 3, 4, 6 -> diff: 1 e 2)
		assertFalse(evenlySpaced.evenlySpacedFirstTry(4, 6, 3));
		assertFalse(evenlySpaced.evenlySpaced(4, 6, 3));
		assertFalse(evenlySpaced.evenlySpacedThirdTry(4, 6, 3));
	}

	@Test
	@DisplayName("Deve garantir que todas as implementações produzem o mesmo resultado")
	void deveGarantirConsistenciaEntreImplementacoes() {
		// Array de casos de teste
		int[][] casos = {
			{2, 4, 6}, {4, 6, 2}, {6, 2, 4},
			{2, 4, 7}, {6, 5, 9},
			{5, 5, 5}, {0, 0, 0},
			{-2, 0, 2}, {0, 2, -2},
			{1, 2, 3}, {3, 1, 2},
			{0, 50, 100}, {100, 50, 0},
			{5, 5, 10}, {10, 5, 5}
		};

		for (int[] caso : casos) {
			int a = caso[0], b = caso[1], c = caso[2];
			boolean resultado1 = evenlySpaced.evenlySpacedFirstTry(a, b, c);
			boolean resultado2 = evenlySpaced.evenlySpaced(a, b, c);
			boolean resultado3 = evenlySpaced.evenlySpacedThirdTry(a, b, c);

			assertEquals(resultado1, resultado2, 
				String.format("Inconsistência entre FirstTry e EvenlySpaced para (%d, %d, %d)", a, b, c));
			assertEquals(resultado2, resultado3, 
				String.format("Inconsistência entre EvenlySpaced e ThirdTry para (%d, %d, %d)", a, b, c));
		}
	}
}

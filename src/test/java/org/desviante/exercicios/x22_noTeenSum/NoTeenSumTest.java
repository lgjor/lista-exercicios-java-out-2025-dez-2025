package org.desviante.exercicios.x22_noTeenSum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para NoTeenSum")
public class NoTeenSumTest {

	private final NoTeenSum noTeenSum = new NoTeenSum();

	@Test
	@DisplayName("Deve somar valores sem adolescentes")
	void deveSomarValoresSemAdolescentes() {
		assertEquals(6, noTeenSum.noTeenSum(1, 2, 3));
		assertEquals(12, noTeenSum.noTeenSum(5, 5, 2));
		assertEquals(30, noTeenSum.noTeenSum(10, 10, 10));
	}

	@Test
	@DisplayName("Deve ignorar valores adolescentes (13, 14, 17, 18, 19)")
	void deveIgnorarValoresAdolescentes() {
		assertEquals(3, noTeenSum.noTeenSum(1, 2, 13));
		assertEquals(3, noTeenSum.noTeenSum(1, 14, 2));
		assertEquals(3, noTeenSum.noTeenSum(17, 1, 2));
		assertEquals(0, noTeenSum.noTeenSum(13, 14, 17));
		assertEquals(0, noTeenSum.noTeenSum(18, 19, 13));
	}

	@Test
	@DisplayName("Deve contar 15 e 16 normalmente (não são adolescentes)")
	void deveContarQuinzeEDezesseis() {
		assertEquals(18, noTeenSum.noTeenSum(1, 2, 15));
		assertEquals(19, noTeenSum.noTeenSum(1, 16, 2));
		assertEquals(31, noTeenSum.noTeenSum(15, 16, 0));
		assertEquals(33, noTeenSum.noTeenSum(15, 16, 2));
	}

	@Test
	@DisplayName("Deve lidar com combinações de valores adolescentes e não adolescentes")
	void deveLidarComCombinacoes() {
		assertEquals(18, noTeenSum.noTeenSum(2, 13, 16));
		assertEquals(16, noTeenSum.noTeenSum(15, 1, 14));
		assertEquals(20, noTeenSum.noTeenSum(20, 0, 0));
		assertEquals(6, noTeenSum.noTeenSum(2, 18, 4));
	}

	@Test
	@DisplayName("Deve lidar com valores zero e negativos")
	void deveLidarComZeroENegativos() {
		assertEquals(0, noTeenSum.noTeenSum(0, 0, 0));
		assertEquals(-6, noTeenSum.noTeenSum(-1, -2, -3));
		assertEquals(-3, noTeenSum.noTeenSum(-1, -2, 13));
		assertEquals(14, noTeenSum.noTeenSum(15, -1, 0));
	}

	@Test
	@DisplayName("Deve lidar com valores acima de 19")
	void deveLidarComValoresAcimaDeDezenove() {
		assertEquals(60, noTeenSum.noTeenSum(20, 20, 20));
		assertEquals(50, noTeenSum.noTeenSum(20, 13, 30));
		assertEquals(100, noTeenSum.noTeenSum(100, 0, 0));
	}

	@Test
	@DisplayName("Deve testar fixTeenSum diretamente")
	void deveTestarFixTeenSum() {
		// Valores não adolescentes devem retornar o mesmo valor
		assertEquals(1, noTeenSum.fixTeenSum(1));
		assertEquals(10, noTeenSum.fixTeenSum(10));
		assertEquals(12, noTeenSum.fixTeenSum(12));
		assertEquals(20, noTeenSum.fixTeenSum(20));
		assertEquals(100, noTeenSum.fixTeenSum(100));
		
		// Valores adolescentes (exceto 15 e 16) devem retornar 0
		assertEquals(0, noTeenSum.fixTeenSum(13));
		assertEquals(0, noTeenSum.fixTeenSum(14));
		assertEquals(0, noTeenSum.fixTeenSum(17));
		assertEquals(0, noTeenSum.fixTeenSum(18));
		assertEquals(0, noTeenSum.fixTeenSum(19));
		
		// 15 e 16 devem retornar o mesmo valor
		assertEquals(15, noTeenSum.fixTeenSum(15));
		assertEquals(16, noTeenSum.fixTeenSum(16));
	}

	@Test
	@DisplayName("Deve testar casos específicos do problema")
	void deveTestarCasosEspecificos() {
		assertEquals(6, noTeenSum.noTeenSum(1, 2, 3));
		assertEquals(3, noTeenSum.noTeenSum(2, 13, 1));
		assertEquals(3, noTeenSum.noTeenSum(2, 1, 14));
	}
}

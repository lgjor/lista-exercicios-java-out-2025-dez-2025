package org.desviante.exercicios.x19_makeBricks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para MakeBricks")
public class MakeBricksTest {

	private final MakeBricks makeBricks = new MakeBricks();

	@Test
	@DisplayName("deve retornar true quando usa apenas tijolos pequenos")
	void testApenasSmallBricks() {
		assertTrue(makeBricks.makeBricks(3, 0, 3));
		assertTrue(makeBricks.makeBricks(5, 0, 4));
	}

	@Test
	@DisplayName("deve retornar true quando usa apenas tijolos grandes")
	void testApenasBigBricks() {
		assertTrue(makeBricks.makeBricks(0, 2, 10));
		assertTrue(makeBricks.makeBricks(0, 3, 15));
	}

	@Test
	@DisplayName("deve retornar true quando usa combinação de tijolos")
	void testCombinacaoDeTijolos() {
		assertTrue(makeBricks.makeBricks(3, 1, 8));  // 5 + 3 = 8
		assertTrue(makeBricks.makeBricks(3, 2, 10)); // 5 + 5 = 10
		assertTrue(makeBricks.makeBricks(1, 2, 11)); // 5 + 5 + 1 = 11
	}

	@Test
	@DisplayName("deve retornar false quando não tem tijolos suficientes")
	void testTijolosInsuficientes() {
		assertFalse(makeBricks.makeBricks(2, 1, 8));  // 5 + 2 = 7 < 8
		assertFalse(makeBricks.makeBricks(1, 1, 7));  // 5 + 1 = 6 < 7
		assertFalse(makeBricks.makeBricks(0, 0, 1));  // sem tijolos
	}

	@Test
	@DisplayName("deve retornar false para o exemplo do readme")
	void testExemploReadme() {
		// 2 tijolos de 5 pol e 3 de 1 pol, objetivo 9 pol
		assertFalse(makeBricks.makeBricks(3, 2, 9));
	}

	@Test
	@DisplayName("deve retornar true quando tem tijolos grandes em excesso")
	void testExcessoDeTijolosGrandes() {
		assertTrue(makeBricks.makeBricks(3, 10, 13)); // usa 2 big (10) + 3 small (3) = 13
		assertTrue(makeBricks.makeBricks(2, 5, 7));   // usa 1 big (5) + 2 small (2) = 7
	}

	@Test
	@DisplayName("deve retornar true quando goal é zero")
	void testGoalZero() {
		assertTrue(makeBricks.makeBricks(0, 0, 0));
		assertTrue(makeBricks.makeBricks(5, 3, 0));
	}

	@Test
	@DisplayName("deve retornar false quando goal é maior que total disponível")
	void testGoalMaiorQueTotal() {
		assertFalse(makeBricks.makeBricks(2, 1, 10)); // 5 + 2 = 7 < 10
		assertFalse(makeBricks.makeBricks(0, 2, 11)); // 10 < 11
	}

	@Test
	@DisplayName("deve retornar true quando tem exatamente os tijolos necessários")
	void testExatamenteNecessario() {
		assertTrue(makeBricks.makeBricks(4, 1, 9));  // 5 + 4 = 9
		assertTrue(makeBricks.makeBricks(0, 4, 20)); // 20 = 20
	}

	@Test
	@DisplayName("deve retornar false quando tijolos grandes excedem e não há pequenos suficientes")
	void testBigBricksExcedemSemSmallSuficiente() {
		assertFalse(makeBricks.makeBricks(1, 3, 9)); // não pode usar 1 big (5) + 1 small, nem 2 big (10)
	}

	@Test
	@DisplayName("deve retornar true para casos especiais")
	void testCasosEspeciais() {
		assertTrue(makeBricks.makeBricks(6, 1, 11));  // 5 + 6 = 11
		assertTrue(makeBricks.makeBricks(6, 0, 6));   // 6 = 6
		assertTrue(makeBricks.makeBricks(3, 2, 12));  // 10 + 2 = 12 (2 big + 2 small)
	}

	@Test
	@DisplayName("deve retornar true quando small tem mais do que precisa")
	void testSmallEmExcesso() {
		assertTrue(makeBricks.makeBricks(100, 2, 14)); // usa 2 big (10) + 4 small (4) = 14
	}
}

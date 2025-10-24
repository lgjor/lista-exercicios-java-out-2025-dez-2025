package org.desviante.exercicios.x24_blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para Blackjack")
public class BlackjackTest {

	private final Blackjack blackjack = new Blackjack();

	@Test
	@DisplayName("Deve retornar o maior valor quando ambos estão abaixo de 21")
	void deveRetornarMaiorValorQuandoAmbosAbaixoDe21() {
		assertEquals(19, blackjack.blackjack(19, 18));
		assertEquals(18, blackjack.blackjack(17, 18));
		assertEquals(20, blackjack.blackjack(15, 20));
		assertEquals(10, blackjack.blackjack(5, 10));
		assertEquals(15, blackjack.blackjack(10, 15));
	}

	@Test
	@DisplayName("Deve retornar 21 quando um ou ambos valores são 21")
	void deveRetornar21QuandoValorE21() {
		assertEquals(21, blackjack.blackjack(21, 19));
		assertEquals(21, blackjack.blackjack(19, 21));
		assertEquals(21, blackjack.blackjack(21, 21));
		assertEquals(21, blackjack.blackjack(21, 20));
		assertEquals(21, blackjack.blackjack(10, 21));
	}

	@Test
	@DisplayName("Deve retornar o valor válido quando um ultrapassa 21")
	void deveRetornarValorValidoQuandoUmUltrapassa() {
		assertEquals(19, blackjack.blackjack(19, 22));
		assertEquals(18, blackjack.blackjack(25, 18));
		assertEquals(20, blackjack.blackjack(20, 30));
		assertEquals(21, blackjack.blackjack(21, 22));
		assertEquals(21, blackjack.blackjack(30, 21));
	}

	@Test
	@DisplayName("Deve retornar 0 quando ambos ultrapassam 21")
	void deveRetornar0QuandoAmbosUltrapassam() {
		assertEquals(0, blackjack.blackjack(22, 22));
		assertEquals(0, blackjack.blackjack(25, 30));
		assertEquals(0, blackjack.blackjack(22, 23));
		assertEquals(0, blackjack.blackjack(100, 50));
		assertEquals(0, blackjack.blackjack(23, 25));
	}

	@Test
	@DisplayName("Deve lidar com valores iguais")
	void deveLidarComValoresIguais() {
		assertEquals(20, blackjack.blackjack(20, 20));
		assertEquals(15, blackjack.blackjack(15, 15));
		assertEquals(21, blackjack.blackjack(21, 21));
		assertEquals(0, blackjack.blackjack(22, 22));
		assertEquals(0, blackjack.blackjack(25, 25));
	}

	@Test
	@DisplayName("Deve lidar com casos limites próximos a 21")
	void deveLidarComCasosLimitesProximos21() {
		// Exatamente 21 vs valores menores
		assertEquals(21, blackjack.blackjack(21, 20));
		assertEquals(21, blackjack.blackjack(20, 21));
		
		// Exatamente 22 (primeiro valor acima do limite)
		assertEquals(21, blackjack.blackjack(21, 22));
		assertEquals(21, blackjack.blackjack(22, 21));
		assertEquals(20, blackjack.blackjack(22, 20));
		assertEquals(20, blackjack.blackjack(20, 22));
		
		// Valores muito próximos
		assertEquals(20, blackjack.blackjack(19, 20));
		assertEquals(20, blackjack.blackjack(20, 19));
	}

	@Test
	@DisplayName("Deve lidar com valores pequenos")
	void deveLidarComValoresPequenos() {
		assertEquals(2, blackjack.blackjack(1, 2));
		assertEquals(5, blackjack.blackjack(5, 3));
		assertEquals(10, blackjack.blackjack(10, 1));
		assertEquals(1, blackjack.blackjack(1, 1));
	}

	@Test
	@DisplayName("Deve lidar com valores muito maiores que 21")
	void deveLidarComValoresMuitoMaioresQue21() {
		assertEquals(20, blackjack.blackjack(20, 100));
		assertEquals(15, blackjack.blackjack(50, 15));
		assertEquals(0, blackjack.blackjack(100, 200));
		assertEquals(21, blackjack.blackjack(21, 50));
	}

	@Test
	@DisplayName("Deve testar casos específicos do problema")
	void deveTestarCasosEspecificos() {
		assertEquals(21, blackjack.blackjack(19, 21));
		assertEquals(21, blackjack.blackjack(21, 19));
		assertEquals(0, blackjack.blackjack(22, 22));
		assertEquals(19, blackjack.blackjack(19, 22));
		assertEquals(19, blackjack.blackjack(22, 19));
	}

	@Test
	@DisplayName("Deve retornar o valor mais próximo de 21")
	void deveRetornarValorMaisProximoDe21() {
		// Ambos abaixo de 21, retorna o mais próximo (maior)
		assertEquals(20, blackjack.blackjack(18, 20));
		assertEquals(19, blackjack.blackjack(19, 17));
		assertEquals(21, blackjack.blackjack(15, 21));
		
		// Quando um ultrapassa, retorna o outro mesmo que seja menor
		assertEquals(10, blackjack.blackjack(10, 25));
		assertEquals(5, blackjack.blackjack(30, 5));
	}

	@Test
	@DisplayName("Deve lidar com todas as combinações de valores limites")
	void deveLidarComTodasCombinacoesLimites() {
		// 21 com outros valores
		assertEquals(21, blackjack.blackjack(21, 1));
		assertEquals(21, blackjack.blackjack(1, 21));
		assertEquals(21, blackjack.blackjack(21, 100));
		
		// 22 (primeiro estourado) com outros
		assertEquals(20, blackjack.blackjack(22, 20));
		assertEquals(1, blackjack.blackjack(22, 1));
		assertEquals(0, blackjack.blackjack(22, 23));
		
		// 20 (um abaixo do limite) com outros
		assertEquals(20, blackjack.blackjack(20, 10));
		assertEquals(20, blackjack.blackjack(20, 22));
		assertEquals(21, blackjack.blackjack(20, 21));
	}
}

package org.desviante.exercicios.x23_closeFar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para CloseFar")
public class CloseFarTest {

	private final CloseFar closeFar = new CloseFar();

	@Test
	@DisplayName("Deve retornar true quando b está próximo de a e c está longe")
	void deveRetornarTrueQuandoBProximoECLonge() {
		assertTrue(closeFar.closeFar(1, 2, 10));
		assertTrue(closeFar.closeFar(1, 2, -1));
		assertTrue(closeFar.closeFar(4, 4, 10));
		assertTrue(closeFar.closeFar(10, 10, 6));
		assertTrue(closeFar.closeFar(5, 6, 1));
	}

	@Test
	@DisplayName("Deve retornar true quando c está próximo de a e b está longe")
	void deveRetornarTrueQuandoCProximoEBLonge() {
		assertTrue(closeFar.closeFar(1, 10, 2));
		assertTrue(closeFar.closeFar(1, -1, 2));
		assertTrue(closeFar.closeFar(4, 10, 4));
		assertTrue(closeFar.closeFar(10, 6, 10));
		assertTrue(closeFar.closeFar(5, 1, 6));
	}

	@Test
	@DisplayName("Deve retornar false quando ambos b e c estão próximos de a")
	void deveRetornarFalseQuandoAmbosProximos() {
		assertFalse(closeFar.closeFar(1, 2, 2));
		assertFalse(closeFar.closeFar(5, 5, 6));
		assertFalse(closeFar.closeFar(10, 10, 11));
		assertFalse(closeFar.closeFar(4, 3, 5));
	}

	@Test
	@DisplayName("Deve retornar false quando ambos b e c estão longe de a")
	void deveRetornarFalseQuandoAmbosLonge() {
		assertFalse(closeFar.closeFar(1, 10, 20));
		assertFalse(closeFar.closeFar(5, 10, 15));
		assertFalse(closeFar.closeFar(10, 1, 20));
	}

	@Test
	@DisplayName("Deve lidar com casos limites de distância")
	void deveLidarComCasosLimitesDeDiferenca() {
		// Diferença exatamente 1 é considerado próximo
		assertTrue(closeFar.closeFar(1, 2, 10));
		assertTrue(closeFar.closeFar(1, 0, 10));
		
		// Diferença exatamente 2 é considerado longe
		assertTrue(closeFar.closeFar(1, 2, 4));
		assertTrue(closeFar.closeFar(1, 2, -1));
		
		// Caso onde o valor longe tem diferença exatamente 2 de ambos
		assertTrue(closeFar.closeFar(3, 3, 5));
		assertTrue(closeFar.closeFar(3, 4, 1));
	}

	@Test
	@DisplayName("Deve lidar com valores negativos")
	void deveLidarComValoresNegativos() {
		assertTrue(closeFar.closeFar(-1, -2, 10));
		assertTrue(closeFar.closeFar(-1, 10, -2));
		assertTrue(closeFar.closeFar(-10, -10, -5));
		assertFalse(closeFar.closeFar(-1, -2, -2));
	}

	@Test
	@DisplayName("Deve lidar com valores iguais")
	void deveLidarComValoresIguais() {
		// a e b iguais (diferença 0), c longe
		assertTrue(closeFar.closeFar(5, 5, 10));
		assertTrue(closeFar.closeFar(5, 5, 0));
		
		// a e c iguais (diferença 0), b longe
		assertTrue(closeFar.closeFar(5, 10, 5));
		assertTrue(closeFar.closeFar(5, 0, 5));
		
		// Todos iguais (ambos próximos) - deve retornar false
		assertFalse(closeFar.closeFar(5, 5, 5));
	}

	@Test
	@DisplayName("Deve testar casos específicos do problema")
	void deveTestarCasosEspecificos() {
		assertTrue(closeFar.closeFar(1, 2, 10));
		assertFalse(closeFar.closeFar(1, 2, 3));
		assertTrue(closeFar.closeFar(4, 1, 3));
	}

	@Test
	@DisplayName("Deve validar que o valor longe está longe de AMBOS a e o outro valor")
	void deveValidarQueValorLongeEstaLongeDeAmbos() {
		// c deve estar longe de a E de b
		assertTrue(closeFar.closeFar(1, 2, 10));  // c longe de a(9) e b(8)
		assertFalse(closeFar.closeFar(1, 2, 3));  // c próximo de b(1)
		
		// b deve estar longe de a E de c
		assertTrue(closeFar.closeFar(1, 10, 2));  // b longe de a(9) e c(8)
		assertFalse(closeFar.closeFar(1, 3, 2));  // b próximo de c(1)
	}

	@Test
	@DisplayName("Deve lidar com valores grandes")
	void deveLidarComValoresGrandes() {
		assertTrue(closeFar.closeFar(100, 101, 200));
		assertTrue(closeFar.closeFar(1000, 500, 1001));
		assertFalse(closeFar.closeFar(100, 101, 102));
	}
}

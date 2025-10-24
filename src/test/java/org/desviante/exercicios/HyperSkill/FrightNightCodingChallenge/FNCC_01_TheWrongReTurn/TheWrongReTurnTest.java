package org.desviante.exercicios.HyperSkill.FrightNightCodingChallenge.FNCC_01_TheWrongReTurn;

import org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_01_TheWrongReTurn.TheWrongReTurn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

/**
 * Testes para a classe TheWrongReTurn
 */
@DisplayName("Testes para a classe TheWrongReTurn")
public class TheWrongReTurnTest {

    private String testData;

    @BeforeEach
    public void setUp() throws IOException {
        // Carrega os dados de teste do arquivo
        testData = TheWrongReTurn.readFile(
            "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_01_TheWrongReTurn/hyperskill-dataset-117262104.txt"
        );
    }

    @Test
    @DisplayName("Deve retornar os 4 primeiros dígitos na ordem correta: 5, 1, 7, 2")
    public void testContarEOrdenarRetornaOrdemCorreta() {
        // Executa o método
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(testData);
        
        // Verifica se a lista não está vazia
        assertFalse(resultado.isEmpty(), "A lista de resultados não deve estar vazia");
        
        // Verifica se tem pelo menos 4 elementos
        assertTrue(resultado.size() >= 4, "A lista deve ter pelo menos 4 elementos");
        
        // Verifica os 4 primeiros dígitos na ordem esperada (resultado atual: 5172)
        assertEquals('5', resultado.get(0).getKey(), "O primeiro dígito deve ser '5'");
        assertEquals('1', resultado.get(1).getKey(), "O segundo dígito deve ser '1'");
        assertEquals('7', resultado.get(2).getKey(), "O terceiro dígito deve ser '7'");
        assertEquals('2', resultado.get(3).getKey(), "O quarto dígito deve ser '2'");
    }

    @Test
    @DisplayName("Deve ordenar corretamente por frequência decrescente")
    public void testContarEOrdenarPorFrequenciaDecrescente() {
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(testData);
        
        // Verifica se está ordenado por frequência decrescente
        for (int i = 0; i < resultado.size() - 1; i++) {
            int frequenciaAtual = resultado.get(i).getValue();
            int proximaFrequencia = resultado.get(i + 1).getValue();
            
            assertTrue(frequenciaAtual >= proximaFrequencia, 
                "As frequências devem estar em ordem decrescente. Posição " + i + 
                " tem frequência " + frequenciaAtual + " e posição " + (i+1) + 
                " tem frequência " + proximaFrequencia);
        }
    }

    @Test
    @DisplayName("Em caso de empate na frequência, o dígito maior deve vir primeiro")
    public void testContarEOrdenarEmpatePorDigitoMaior() {
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(testData);
        
        // Verifica se em caso de empate, o dígito maior vem primeiro
        for (int i = 0; i < resultado.size() - 1; i++) {
            int frequenciaAtual = resultado.get(i).getValue();
            int proximaFrequencia = resultado.get(i + 1).getValue();
            
            // Se as frequências são iguais, verifica se o dígito atual é maior
            if (frequenciaAtual == proximaFrequencia) {
                char digitoAtual = resultado.get(i).getKey();
                char proximoDigito = resultado.get(i + 1).getKey();
                
                assertTrue(digitoAtual > proximoDigito, 
                    "Em caso de empate na frequência " + frequenciaAtual + 
                    ", o dígito maior deve vir primeiro. Digito atual: " + digitoAtual + 
                    ", próximo dígito: " + proximoDigito);
            }
        }
    }

    @Test
    @DisplayName("Deve retornar lista vazia para string nula")
    public void testContarEOrdenarComStringNula() {
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(null);
        
        assertTrue(resultado.isEmpty(), "Deve retornar lista vazia para string nula");
    }

    @Test
    @DisplayName("Deve retornar lista vazia para string vazia")
    public void testContarEOrdenarComStringVazia() {
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar("");
        
        assertTrue(resultado.isEmpty(), "Deve retornar lista vazia para string vazia");
    }

    @Test
    @DisplayName("Deve ignorar caracteres não numéricos")
    public void testContarEOrdenarIgnoraCaracteresNaoNumericos() {
        String entradaComLetras = "abc123def456ghi789";
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(entradaComLetras);
        
        // Verifica se apenas dígitos foram contados
        for (Entry<Character, Integer> entry : resultado) {
            char digito = entry.getKey();
            assertTrue(digito >= '0' && digito <= '9', 
                "Apenas dígitos de 0 a 9 devem estar presentes. Encontrado: " + digito);
        }
        
        // Verifica se os dígitos estão presentes
        assertFalse(resultado.isEmpty(), "Deveria haver dígitos na entrada");
    }

    @Test
    @DisplayName("Deve contar corretamente a frequência de cada dígito")
    public void testContarEOrdenarContaFrequenciaCorretamente() {
        String entradaSimples = "112233";
        List<Entry<Character, Integer>> resultado = TheWrongReTurn.contarEOrdenar(entradaSimples);
        
        // Verifica se tem 3 dígitos únicos
        assertEquals(3, resultado.size(), "Deveria ter 3 dígitos únicos");
        
        // Verifica se cada dígito tem frequência 2
        for (Entry<Character, Integer> entry : resultado) {
            assertEquals(2, entry.getValue().intValue(), 
                "Cada dígito deveria ter frequência 2");
        }
    }
}

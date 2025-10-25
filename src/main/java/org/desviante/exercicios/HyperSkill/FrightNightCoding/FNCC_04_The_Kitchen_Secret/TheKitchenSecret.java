package org.desviante.exercicios.HyperSkill.FrightNightCoding.FNCC_04_The_Kitchen_Secret;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheKitchenSecret {

    private char[][] keypad = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
    };

    final int startRow = 0;
    final int startCol = 0;

    private int currentRow; // Índice da linha (0 a 3)
    private int currentCol; // Índice da coluna (0 a 3)

    private String result;

    /**
     * Construtor da classe. Define a posição inicial no keypad.
     * O índice da linha inicial é zero
     * O índice da coluna inicial é zero
     */
    public TheKitchenSecret() {
        // Inicializa a posição atual (por exemplo, em 'A', seria 0, 0)
        this.currentRow = startRow;
        this.currentCol = startCol;
        System.out.println("Keypad inicializado na posição: (" + startRow + ", " + startCol + ") = " + getCurrentPositionChar());
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public int getLastRowIndex(){
        return this.keypad.length - 1;
    }

    public int getLastColIndex(){
        return keypad[0].length - 1;
    }

    public char getCurrentPositionChar(){
        return this.keypad[this.currentRow][this.currentCol];
    }

    /**
     * Reseta a posição atual do keypad para a posição de partida.
     */
    public void resetPosition() {
        this.currentRow = this.startRow;
        this.currentCol = this.startCol;

        //System.out.println("Posição resetada para: (" + this.currentRow + ", " + this.currentCol + ") = " + getCurrentPositionChar());
    }

    public String getResult() {
        return result;
    }

    // Função para ler arquivo
    public static List<List<String>> readFile(String nomeArquivo) throws IOException {
        List<List<String>> todasAsSequencias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    // Linha vazia = cria uma lista com instrução "STAY"
                    List<String> instrucoesDestaLinha = new ArrayList<>();
                    instrucoesDestaLinha.add("STAY");
                    todasAsSequencias.add(instrucoesDestaLinha);
                } else {
                    // 1. Cria uma nova lista para a linha atual
                    List<String> instrucoesDestaLinha = new ArrayList<>();

                    // 2. Divide a linha pela vírgula
                    String[] instrucoesPorLinha = linha.split(",");

                    // 3. Adiciona cada instrução limpa À LISTA DESTA LINHA
                    for (String instrucao : instrucoesPorLinha) {
                        String instrucaoLimpa = instrucao.trim();
                        if (!instrucaoLimpa.isEmpty()) {
                            instrucoesDestaLinha.add(instrucaoLimpa);
                        }
                    }

                    // 4. Adiciona a lista de instruções desta linha à lista principal
                    if (!instrucoesDestaLinha.isEmpty()) {
                        todasAsSequencias.add(instrucoesDestaLinha);
                    }
                }
            }
            return todasAsSequencias;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            // Lançar a exceção ou retornar uma lista vazia/nula dependendo da sua preferência
            throw e; // É melhor relançar a exceção para que o chamador a trate
        }
    }

    // Move da posição atual do keypad segundo a direção
    public void move(String direction) {
        //System.out.println("Tentando mover " + direction);
        switch (direction){
            case "UP" -> {
                // Se estiver na linha zero, não move para cima
                if (this.getCurrentRow()==0){
                    //System.out.println("Não pode mover a direita, linha zero: "+this.getCurrentRow());
                    return;
                }
                //System.out.println("Movido acima com sucesso");
                this.currentRow--;
            }
            case "RIGHT" -> {
                // Se estiver na última coluna, não move para a direita
                if (this.getCurrentCol()==this.getLastColIndex()){
                    //System.out.println("Não pode mover a direita, última coluna: "+this.getCurrentCol());
                    return;
                }
                //System.out.println("Movido a direita com sucesso");
                this.currentCol++;
            }
            case "DOWN" -> {
                // Se esiver na última linha, não move para baixo
                if (this.getCurrentRow()==this.getLastRowIndex()){
                    //System.out.println("Não pode mover abaixo, última Linha: "+this.getCurrentRow());
                    return;
                }
                //System.out.println("Movido abaixo com sucesso");
                this.currentRow++;
            }
            case "LEFT" -> {
                // Se estiver na primeira coluna, não move para a esquerda
                if (this.getCurrentCol()==0){
                    //System.out.println("Não pode mover a esquerda, Coluna zero: "+this.getCurrentCol());
                    return;
                }
                //System.out.println("Movido a esquerda com sucesso");
                this.currentCol--;
            }
            case "STAY" -> {
                // Não faz nada, mantém a posição atual
                //System.out.println("Mantendo posição atual: " + getCurrentPositionChar());
            }
        }
    }

    // Move o keypad seguindo as instruções de cada linha da lista de instruções e concatena a posição final após cada linha no result
    public void resetAndMove(TheKitchenSecret kitchenSecret, List<List<String>> input){

        // Inicializa result como string vazia
        kitchenSecret.result = "";
        
        // Armazena a posição inicial para resetar entre linhas
        int initialRow = kitchenSecret.currentRow;
        int initialCol = kitchenSecret.currentCol;

        try{
            // Itera sobre a lista externa (que contém todas as linhas)
            if (input != null) {
                int numeroLinha = 1;
                for (List<String> line : input) {
                    //System.out.println("--- Processando Linha " + numeroLinha + " ---");

                    // Agora, 'sequencia' contém SOMENTE as instruções daquela linha
                    for (String direction : line) {
                        kitchenSecret.move(direction);
                    }

                    // Concatena o resultado da linha atual
                    kitchenSecret.result += kitchenSecret.getCurrentPositionChar();

                    //System.out.println("Resultado da linha " + numeroLinha + ": " + kitchenSecret.getCurrentPositionChar());
                    //System.out.println("-------------------------------------------------------------------");
                    printKeypadWithPause(400);
                    // Reset para a posição inicial
                    kitchenSecret.resetPosition();
                    numeroLinha++;
                }

                // 3. Adiciona o caractere A ao final do resultado
                if (input != null) {
                    kitchenSecret.move("UP");
                    kitchenSecret.result += "A";
                    printKeypadWithPause(400);
                    kitchenSecret.resetPosition();
                }
            }
        } catch(NullPointerException e){
            System.out.println("Erro: A lista de instruções é nula");
        }
    };



    public void printKeypad() {

        // Códigos de Escape ANSI
        final String ANSI_RESET = "\u001B[0m"; // Resetar formatação
        final String ANSI_BOLD = "\u001B[1m";  // Ativar negrito
        String ANSI_YELLOW = "\u001B[33m"; // Cor amarela

        // ----------------------------------------------------------------
        // Variáveis auxiliares para a borda
        // Largura de uma célula: Caractere + 1 espaço + 2 espaços para as bordas
        final int CELL_CONTENT_WIDTH = 3;
        // Largura total da borda superior/inferior (4 colunas * 3 caracteres + 1 '|' final)
        final String HORIZONTAL_BORDER = "+" + "---".repeat(keypad[0].length) + "---+ ";
        // ----------------------------------------------------------------

        System.out.println(" --- Keypad ---");

        // Imprime a borda superior
        System.out.println(HORIZONTAL_BORDER);

        for (int i = 0; i < keypad.length; i++) {

            // Inicia a linha com a borda vertical
            System.out.print("|");

            for (int j = 0; j < keypad[i].length; j++) {

                char caractere = keypad[i][j];

                // Inicia a célula com um espaço para separar o caractere da borda '|'
                System.out.print(" ");

                // 1. Checa se esta é a posição atual
                if (i == this.currentRow && j == this.currentCol) {
                    // Se for, imprime: <ANSI_BOLD>Caractere<ANSI_RESET>
                    // Adiciona um espaço extra se o negrito for 'absorvido'
                    System.out.print(ANSI_BOLD + ANSI_YELLOW + caractere + ANSI_RESET);
                } else {
                    // Se não for, imprime o caractere normal
                    System.out.print(caractere);
                }

                // Imprime o espaço e a borda vertical, fechando a célula
                System.out.print(" |");
            }

            System.out.println(); // Quebra de linha

            // Imprime a borda horizontal após cada linha
            System.out.println(HORIZONTAL_BORDER);
        }
        System.out.println(this.getResult());

        // Opcional: remover a linha de separação final se a borda já for suficiente
        // System.out.println("--------------");
    }

    public void printKeypadWithPause(long milissegundos) {

        // 1. Limpa a tela antes de imprimir o novo estado
        clearScreen();

        // 2. Imprime o Keypad
        this.printKeypad();

        // 3. Tenta fazer a pausa
        try {
            // Exibe uma mensagem para indicar que o código está pausado (opcional)
            // System.out.println("Aguardando " + milissegundos + "ms...");

            Thread.sleep(milissegundos); // Pausa a execução

        } catch (InterruptedException e) {
            // Isso é tratado se o thread for interrompido enquanto está dormindo
            System.err.println("Pausa interrompida.");
            // Re-interrompe o thread (boa prática)
            Thread.currentThread().interrupt();
        }
    }

    // Método auxiliar para limpar a tela
    private void clearScreen() {
        final String ANSI_CLEAR_SCREEN = "\033[H\033[2J";
        try {
            // Tenta usar o método de limpeza de tela específico do sistema (pode falhar)
            if (System.getProperty("os.name").contains("Windows")) {
                // Para Windows (cmd.exe ou PowerShell)
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux/macOS ou outros terminais compatíveis com ANSI
                System.out.print(ANSI_CLEAR_SCREEN);
                System.out.flush(); // Garante que o comando seja enviado imediatamente
            }
        } catch (Exception e) {
            // Se o comando de limpeza falhar (o que é comum),
            // tentamos apenas imprimir 50 linhas em branco (fallback)
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Considerando que o arquivo está no mesmo pacote do main
        //final String filePath = "src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_04_The_Kitchen_Secret/hyperskill-dataset-117348187.txt";
        final String filePath = "/mnt/d/projetos/lista-exercicios-java-out-2025-dez-2025/src/main/java/org/desviante/exercicios/HyperSkill/FrightNightCoding/FNCC_04_The_Kitchen_Secret/hyperskill-dataset-117348187.txt";
        List<List<String>> input = null;
        // Lê o conteúdo do arquivo
        try {
            input = readFile(filePath);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            return;
        }
        System.out.println(input);

        // Inicializa o jogo na posição zero zero
        TheKitchenSecret kitchenSecret = new TheKitchenSecret();

        kitchenSecret.resetAndMove(kitchenSecret, input);

        System.out.println();

        System.out.println("End of the sequence (Press any key to exit))");

        // 1. Crie um objeto Scanner:
        Scanner scanner = new Scanner(System.in);

        // 2. Leia a linha de entrada (aguarda o usuário digitar e apertar Enter):
        scanner.nextLine();

        // 3. Opcional: Feche o scanner após o uso (boa prática):
        scanner.close();

        // 4. Instrução para sair do programa:
        System.exit(0);

    }
}

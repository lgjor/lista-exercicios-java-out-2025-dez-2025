package org.desviante.exercicios.adventofcode2025.AOC25_10_Factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factory {

    static class Machine {
        List<Integer> targetState;
        List<List<Integer>> buttons;

        public Machine(List<Integer> targetState, List<List<Integer>> buttons) {
            this.targetState = targetState;
            this.buttons = buttons;
        }
    }

    public List<Machine> readMachines(Path filePath) {
        List<Machine> machines = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            Pattern bracketPattern = Pattern.compile("\\[(.*?)\\]");
            Pattern parenPattern = Pattern.compile("\\(([\\d,]+)\\)");

            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Matcher bracketMatcher = bracketPattern.matcher(line);
                if (!bracketMatcher.find()) continue;

                String charPattern = bracketMatcher.group(1);
                List<Integer> targetState = new ArrayList<>();
                for (char c : charPattern.toCharArray()) {
                    targetState.add(c == '#' ? 1 : 0);
                }

                List<List<Integer>> buttons = new ArrayList<>();
                Matcher parenMatcher = parenPattern.matcher(line);
                while (parenMatcher.find()) {
                    String[] indices = parenMatcher.group(1).split(",");
                    List<Integer> button = new ArrayList<>();
                    for (String idx : indices) {
                        button.add(Integer.parseInt(idx.trim()));
                    }
                    buttons.add(button);
                }

                if (!targetState.isEmpty() && !buttons.isEmpty()) {
                    machines.add(new Machine(targetState, buttons));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        return machines;
    }

    public List<Machine> readMachinesPart2(Path filePath) {
        List<Machine> machines = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            Pattern parenPattern = Pattern.compile("\\(([\\d,]+)\\)");
            Pattern bracePattern = Pattern.compile("\\{([\\d,]+)\\}");

            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Matcher braceMatcher = bracePattern.matcher(line);
                if (!braceMatcher.find()) continue;

                String[] voltages = braceMatcher.group(1).split(",");
                List<Integer> targetState = new ArrayList<>();
                for (String v : voltages) {
                    targetState.add(Integer.parseInt(v.trim()));
                }

                List<List<Integer>> buttons = new ArrayList<>();
                Matcher parenMatcher = parenPattern.matcher(line);
                while (parenMatcher.find()) {
                    String[] indices = parenMatcher.group(1).split(",");
                    List<Integer> button = new ArrayList<>();
                    for (String idx : indices) {
                        button.add(Integer.parseInt(idx.trim()));
                    }
                    buttons.add(button);
                }

                if (!targetState.isEmpty() && !buttons.isEmpty()) {
                    machines.add(new Machine(targetState, buttons));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        return machines;
    }

    // ==================== PARTE 1 ====================

    public int solveMachine(Machine machine) {
        int numLights = machine.targetState.size();
        int numButtons = machine.buttons.size();
        int[][] matrix = new int[numLights][numButtons + 1];

        for (int btn = 0; btn < numButtons; btn++) {
            for (int light : machine.buttons.get(btn)) {
                if (light < numLights) {
                    matrix[light][btn] = 1;
                }
            }
        }

        for (int i = 0; i < numLights; i++) {
            matrix[i][numButtons] = machine.targetState.get(i);
        }

        return findMinimumSolution(matrix, numLights, numButtons);
    }

    private int findMinimumSolution(int[][] matrix, int rows, int cols) {
        Integer result = solveBFS(matrix, rows, cols);
        if (result != null) return result;
        return solveBruteForce(matrix, rows, cols);
    }

    private Integer solveBFS(int[][] matrix, int rows, int cols) {
        int[][] m = new int[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, m[i], 0, cols + 1);
        }

        List<Integer> pivotCols = new ArrayList<>();
        int pivot = 0;

        for (int col = 0; col < cols && pivot < rows; col++) {
            int pivotRow = -1;
            for (int row = pivot; row < rows; row++) {
                if (m[row][col] == 1) {
                    pivotRow = row;
                    break;
                }
            }
            if (pivotRow == -1) continue;
            if (pivotRow != pivot) {
                int[] temp = m[pivot];
                m[pivot] = m[pivotRow];
                m[pivotRow] = temp;
            }
            pivotCols.add(col);
            for (int row = 0; row < rows; row++) {
                if (row != pivot && m[row][col] == 1) {
                    for (int c = 0; c <= cols; c++) {
                        m[row][c] ^= m[pivot][c];
                    }
                }
            }
            pivot++;
        }

        for (int row = pivot; row < rows; row++) {
            if (m[row][cols] == 1) return null;
        }

        boolean[] isPivot = new boolean[cols];
        for (int col : pivotCols) isPivot[col] = true;

        List<Integer> freeVars = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            if (!isPivot[i]) freeVars.add(i);
        }

        if (freeVars.size() > 20) return null;

        int minWeight = Integer.MAX_VALUE;
        for (long mask = 0; mask < (1L << freeVars.size()); mask++) {
            int[] solution = new int[cols];
            for (int i = 0; i < freeVars.size(); i++) {
                solution[freeVars.get(i)] = (int)((mask >> i) & 1);
            }
            for (int row = 0; row < pivot; row++) {
                int col = pivotCols.get(row);
                int val = m[row][cols];
                for (int c = 0; c < cols; c++) {
                    if (c != col && m[row][c] == 1) {
                        val ^= solution[c];
                    }
                }
                solution[col] = val;
            }
            int weight = 0;
            for (int i = 0; i < cols; i++) {
                if (solution[i] == 1) weight++;
            }
            minWeight = Math.min(minWeight, weight);
        }
        return minWeight == Integer.MAX_VALUE ? null : minWeight;
    }

    private int solveBruteForce(int[][] matrix, int rows, int cols) {
        int[][] m = new int[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, m[i], 0, cols + 1);
        }

        int pivot = 0;
        for (int col = 0; col < cols && pivot < rows; col++) {
            int pivotRow = -1;
            for (int row = pivot; row < rows; row++) {
                if (m[row][col] == 1) {
                    pivotRow = row;
                    break;
                }
            }
            if (pivotRow == -1) continue;
            if (pivotRow != pivot) {
                int[] temp = m[pivot];
                m[pivot] = m[pivotRow];
                m[pivotRow] = temp;
            }
            for (int row = pivot + 1; row < rows; row++) {
                if (m[row][col] == 1) {
                    for (int c = 0; c <= cols; c++) {
                        m[row][c] ^= m[pivot][c];
                    }
                }
            }
            pivot++;
        }

        int[] solution = new int[cols];
        for (int row = pivot - 1; row >= 0; row--) {
            int leadCol = -1;
            for (int col = 0; col < cols; col++) {
                if (m[row][col] == 1) {
                    leadCol = col;
                    break;
                }
            }
            if (leadCol == -1) continue;
            int val = m[row][cols];
            for (int col = leadCol + 1; col < cols; col++) {
                if (m[row][col] == 1) {
                    val ^= solution[col];
                }
            }
            solution[leadCol] = val;
        }

        int count = 0;
        for (int i = 0; i < cols; i++) {
            if (solution[i] == 1) count++;
        }
        return count;
    }

    public int solvePart1(Path filePath) {
        List<Machine> machines = readMachines(filePath);
        int totalPresses = 0;
        for (int i = 0; i < machines.size(); i++) {
            Machine m = machines.get(i);
            int presses = solveMachine(m);
            if (presses == -1) {
                System.err.println("Máquina " + (i + 1) + " não tem solução!");
                return -1;
            }
            System.out.println("Máquina " + (i + 1) + ": " + presses + " pressionamentos");
            totalPresses += presses;
        }
        return totalPresses;
    }

    // ==================== PARTE 2 ====================

    public int solveMachinePart2(Machine machine) {
        int numCounters = machine.targetState.size();
        int numButtons = machine.buttons.size();
        int[][] A = new int[numCounters][numButtons];

        for (int btn = 0; btn < numButtons; btn++) {
            for (int counter : machine.buttons.get(btn)) {
                if (counter < numCounters) {
                    A[counter][btn] = 1;
                }
            }
        }

        int[] b = new int[numCounters];
        for (int i = 0; i < numCounters; i++) {
            b[i] = machine.targetState.get(i);
        }

        return solveIntegerLP(A, b, numCounters, numButtons);
    }

    private int solveIntegerLP(int[][] A, int[] b, int rows, int cols) {
        // 7x7 é o melhor balanço velocidade/precisão
        boolean useExact = (cols <= 7 && rows <= 7);

        if (useExact) {
            return solveBranchAndBound(A, b, rows, cols);
        }

        // Para sistemas grandes, usar melhor heurística
        int result1 = solveGreedyIntegerLP(A, b, rows, cols);
        int result2 = solveGreedyVariant2(A, b, rows, cols);
        int result3 = solveGreedyVariant3(A, b, rows, cols);

        return Math.min(result1, Math.min(result2, result3));
    }

    private int solveBranchAndBound(int[][] A, int[] b, int rows, int cols) {
        int upperBound = solveGreedyIntegerLP(A, b, rows, cols);
        int[] bestSolution = new int[cols];
        int[] currentSolution = new int[cols];
        int[] currentState = new int[rows];
        int[] minCost = {upperBound};

        branchAndBoundRecursive(A, b, rows, cols, 0, currentSolution, currentState,
                0, minCost, bestSolution);
        return minCost[0];
    }

    private void branchAndBoundRecursive(int[][] A, int[] b, int rows, int cols,
                                         int btnIdx, int[] current, int[] state,
                                         int currentCost, int[] minCost, int[] bestSolution) {
        if (currentCost >= minCost[0]) return;

        if (btnIdx == cols) {
            boolean valid = true;
            for (int i = 0; i < rows; i++) {
                if (state[i] != b[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid && currentCost < minCost[0]) {
                minCost[0] = currentCost;
                System.arraycopy(current, 0, bestSolution, 0, cols);
            }
            return;
        }

        int totalDeficit = 0;
        for (int i = 0; i < rows; i++) {
            if (state[i] < b[i]) totalDeficit += (b[i] - state[i]);
        }

        if (totalDeficit == 0) {
            branchAndBoundRecursive(A, b, rows, cols, cols, current, state, currentCost, minCost, bestSolution);
            return;
        }

        int maxUseful = 0;
        boolean isUseful = false;
        for (int i = 0; i < rows; i++) {
            if (A[i][btnIdx] > 0 && state[i] < b[i]) {
                isUseful = true;
                maxUseful = Math.max(maxUseful, b[i] - state[i]);
            }
        }

        if (!isUseful) {
            current[btnIdx] = 0;
            branchAndBoundRecursive(A, b, rows, cols, btnIdx + 1, current, state, currentCost, minCost, bestSolution);
            return;
        }

        maxUseful = Math.min(maxUseful, 30);

        for (int presses = 0; presses <= maxUseful; presses++) {
            if (currentCost + presses >= minCost[0]) break;

            current[btnIdx] = presses;
            int[] newState = state.clone();
            boolean exceeds = false;
            for (int i = 0; i < rows; i++) {
                newState[i] += A[i][btnIdx] * presses;
                if (newState[i] > b[i]) {
                    exceeds = true;
                    break;
                }
            }

            if (!exceeds) {
                branchAndBoundRecursive(A, b, rows, cols, btnIdx + 1, current, newState,
                        currentCost + presses, minCost, bestSolution);
            }
        }
        current[btnIdx] = 0;
    }

    private int solveGreedyIntegerLP(int[][] A, int[] b, int rows, int cols) {
        int[] solution = new int[cols];
        int[] current = new int[rows];

        for (int iter = 0; iter < 1000; iter++) {
            int maxDeficit = 0;
            int deficitRow = -1;
            for (int i = 0; i < rows; i++) {
                int deficit = b[i] - current[i];
                if (deficit > maxDeficit) {
                    maxDeficit = deficit;
                    deficitRow = i;
                }
            }
            if (maxDeficit == 0) break;

            int bestBtn = -1;
            double bestRatio = -1;
            for (int btn = 0; btn < cols; btn++) {
                if (A[deficitRow][btn] == 0) continue;
                int helps = 0, harms = 0;
                for (int i = 0; i < rows; i++) {
                    if (A[i][btn] > 0) {
                        int diff = b[i] - current[i];
                        if (diff > 0) helps++;
                        else if (diff < 0) harms++;
                    }
                }
                double ratio = helps - harms * 2.0;
                if (ratio > bestRatio) {
                    bestRatio = ratio;
                    bestBtn = btn;
                }
            }
            if (bestBtn == -1) break;

            int presses = (maxDeficit + A[deficitRow][bestBtn] - 1) / A[deficitRow][bestBtn];
            presses = Math.min(presses, 100);
            solution[bestBtn] += presses;
            for (int i = 0; i < rows; i++) {
                current[i] += A[i][bestBtn] * presses;
            }
        }

        for (int btn = 0; btn < cols; btn++) {
            while (solution[btn] > 0) {
                boolean canRemove = true;
                for (int i = 0; i < rows; i++) {
                    if (A[i][btn] > 0 && current[i] - A[i][btn] < b[i]) {
                        canRemove = false;
                        break;
                    }
                }
                if (canRemove) {
                    solution[btn]--;
                    for (int i = 0; i < rows; i++) {
                        current[i] -= A[i][btn];
                    }
                } else {
                    break;
                }
            }
        }

        int cost = 0;
        for (int i = 0; i < cols; i++) cost += solution[i];
        return cost;
    }

    private int solveGreedyVariant2(int[][] A, int[] b, int rows, int cols) {
        int[] solution = new int[cols];
        int[] current = new int[rows];

        double[] efficiency = new double[cols];
        for (int btn = 0; btn < cols; btn++) {
            for (int i = 0; i < rows; i++) {
                if (A[i][btn] > 0 && b[i] > 0) efficiency[btn]++;
            }
        }

        Integer[] order = new Integer[cols];
        for (int i = 0; i < cols; i++) order[i] = i;
        java.util.Arrays.sort(order, (a, b2) -> Double.compare(efficiency[b2], efficiency[a]));

        for (int idx = 0; idx < cols; idx++) {
            int btn = order[idx];
            int maxNeed = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][btn] > 0 && current[i] < b[i]) {
                    int need = (b[i] - current[i] + A[i][btn] - 1) / A[i][btn];
                    maxNeed = Math.max(maxNeed, need);
                }
            }
            if (maxNeed > 0) {
                solution[btn] = maxNeed;
                for (int i = 0; i < rows; i++) {
                    current[i] += A[i][btn] * maxNeed;
                }
            }
        }

        int cost = 0;
        for (int i = 0; i < cols; i++) cost += solution[i];
        return cost;
    }

    private int solveGreedyVariant3(int[][] A, int[] b, int rows, int cols) {
        int[] solution = new int[cols];
        int[] current = new int[rows];

        for (int i = 0; i < rows; i++) {
            if (b[i] == 0) continue;
            int bestBtn = -1;
            int minOthers = Integer.MAX_VALUE;
            for (int btn = 0; btn < cols; btn++) {
                if (A[i][btn] > 0) {
                    int others = 0;
                    for (int j = 0; j < rows; j++) {
                        if (j != i && A[j][btn] > 0) others++;
                    }
                    if (others < minOthers) {
                        minOthers = others;
                        bestBtn = btn;
                    }
                }
            }
            if (bestBtn >= 0) {
                int need = (b[i] - current[i] + A[i][bestBtn] - 1) / A[i][bestBtn];
                if (need > 0) {
                    solution[bestBtn] += need;
                    for (int j = 0; j < rows; j++) {
                        current[j] += A[j][bestBtn] * need;
                    }
                }
            }
        }

        int cost = 0;
        for (int i = 0; i < cols; i++) cost += solution[i];
        return cost;
    }

    private int improveWithLocalSearch(int[][] A, int[] b, int rows, int cols, int initialCost) {
        int[] solution = buildSolutionFromGreedy(A, b, rows, cols);
        int[] current = new int[rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                current[j] += A[j][i] * solution[i];
            }
        }

        // Fase 1: Remover excessos óbvios
        for (int btn = 0; btn < cols; btn++) {
            while (solution[btn] > 0) {
                boolean canRemove = true;
                for (int i = 0; i < rows; i++) {
                    if (A[i][btn] > 0 && current[i] - A[i][btn] < b[i]) {
                        canRemove = false;
                        break;
                    }
                }
                if (canRemove) {
                    solution[btn]--;
                    for (int i = 0; i < rows; i++) {
                        current[i] -= A[i][btn];
                    }
                } else {
                    break;
                }
            }
        }

        // Fase 2: Busca local mais agressiva - tentar substituições
        boolean improved = true;
        int iterations = 0;
        while (improved && iterations < 50) {
            improved = false;
            iterations++;

            // Tentar substituir pressionamentos de um botão por outro mais eficiente
            for (int btn1 = 0; btn1 < cols; btn1++) {
                if (solution[btn1] == 0) continue;

                // Tentar remover 1 de btn1
                solution[btn1]--;
                for (int i = 0; i < rows; i++) {
                    current[i] -= A[i][btn1];
                }

                // Verificar se ficou válido
                boolean needsFix = false;
                for (int i = 0; i < rows; i++) {
                    if (current[i] < b[i]) {
                        needsFix = true;
                        break;
                    }
                }

                if (!needsFix) {
                    // Conseguimos remover sem adicionar nada!
                    improved = true;
                    continue;
                }

                // Precisa adicionar em outro botão - encontrar o melhor
                int bestBtn = -1;
                int minAdditions = Integer.MAX_VALUE;

                for (int btn2 = 0; btn2 < cols; btn2++) {
                    if (btn2 == btn1) continue;

                    // Calcular quantos pressionamentos de btn2 precisamos
                    int needed = 0;
                    for (int i = 0; i < rows; i++) {
                        if (current[i] < b[i] && A[i][btn2] > 0) {
                            int deficit = b[i] - current[i];
                            int need = (deficit + A[i][btn2] - 1) / A[i][btn2];
                            needed = Math.max(needed, need);
                        }
                    }

                    if (needed < minAdditions && needed > 0) {
                        // Verificar se não ultrapassa outros contadores
                        boolean safe = true;
                        for (int i = 0; i < rows; i++) {
                            if (current[i] + A[i][btn2] * needed > b[i] + 10) {
                                safe = false;
                                break;
                            }
                        }
                        if (safe) {
                            minAdditions = needed;
                            bestBtn = btn2;
                        }
                    }
                }

                // Se economiza pressionamentos, fazer a troca
                if (bestBtn != -1 && minAdditions == 0) {
                    // Economizamos 1 pressionamento!
                    improved = true;
                } else {
                    // Reverter remoção do btn1
                    solution[btn1]++;
                    for (int i = 0; i < rows; i++) {
                        current[i] += A[i][btn1];
                    }
                }
            }
        }

        int cost = 0;
        for (int i = 0; i < cols; i++) cost += solution[i];
        return cost;
    }

    private int[] buildSolutionFromGreedy(int[][] A, int[] b, int rows, int cols) {
        int[] solution = new int[cols];
        int[] current = new int[rows];

        for (int iter = 0; iter < 500; iter++) {
            int maxDeficit = 0;
            int deficitRow = -1;
            for (int i = 0; i < rows; i++) {
                int deficit = b[i] - current[i];
                if (deficit > maxDeficit) {
                    maxDeficit = deficit;
                    deficitRow = i;
                }
            }
            if (maxDeficit == 0) break;

            int bestBtn = -1;
            double bestRatio = -1;
            for (int btn = 0; btn < cols; btn++) {
                if (A[deficitRow][btn] == 0) continue;
                int helps = 0, harms = 0;
                for (int i = 0; i < rows; i++) {
                    if (A[i][btn] > 0) {
                        int diff = b[i] - current[i];
                        if (diff > 0) helps++;
                        else if (diff < 0) harms++;
                    }
                }
                double ratio = helps - harms * 2.0;
                if (ratio > bestRatio) {
                    bestRatio = ratio;
                    bestBtn = btn;
                }
            }
            if (bestBtn == -1) break;

            int presses = (maxDeficit + A[deficitRow][bestBtn] - 1) / A[deficitRow][bestBtn];
            solution[bestBtn] += presses;
            for (int i = 0; i < rows; i++) {
                current[i] += A[i][bestBtn] * presses;
            }
        }
        return solution;
    }

    public int solvePart2(Path filePath) {
        List<Machine> machines = readMachinesPart2(filePath);
        int totalPresses = 0;

        for (int i = 0; i < machines.size(); i++) {
            Machine m = machines.get(i);
            int presses = solveMachinePart2(m);
            if (presses == -1) {
                System.err.println("Máquina " + (i + 1) + " não tem solução!");
                return -1;
            }
            System.out.println("Máquina " + (i + 1) + ": " + presses + " pressionamentos");
            totalPresses += presses;
        }
        return totalPresses;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Path testPath = Path.of("src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_10_Factory/inputtest.txt");
        Path inputPath = Path.of("src/main/java/org/desviante/exercicios/adventofcode2025/AOC25_10_Factory/input.txt");

        System.out.println("========== PARTE 1: Luzes (GF2) ==========");
        System.out.println("\n=== Teste ===");
        int result1Test = factory.solvePart1(testPath);
        System.out.println("Total: " + result1Test + " (esperado: 7)");

        System.out.println("\n=== Input Real ===");
        int result1 = factory.solvePart1(inputPath);
        System.out.println("Total: " + result1);

        System.out.println("\n\n========== PARTE 2: Voltagem (Integer LP) ==========");
        System.out.println("\n=== Teste ===");
        int result2Test = factory.solvePart2(testPath);
        System.out.println("Total: " + result2Test + " (esperado: 33)");

        System.out.println("\n=== Input Real ===");
        int result2 = factory.solvePart2(inputPath);
        System.out.println("Total: " + result2);
    }
}
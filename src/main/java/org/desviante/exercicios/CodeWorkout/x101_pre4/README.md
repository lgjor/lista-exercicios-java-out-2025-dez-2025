# Exercício X101: pre4

## Descrição

Dado um array não vazio do tipo int, retorne um novo array contendo os elementos do array original que vieram antes do primeiro 4 no array original. O array original conterá pelo menos um 4. Observe que é válido em Java criar um array de comprimento 0.

## Solução

Solucionei percorrendo com um for, quando encontra o primeiro elemento 4, armazeno o índice e interrompo o laço for.

Com esse valor crio o novo array do tamanho correto e faço a cópia dos itens para retornar.

Outra opção seria utilizar o stream, dessa forma:

```
public static int[] pre4(int[] nums) {
if (nums == null || nums.length == 0) {
return new int[0];
}

        // 1. Encontrar o índice da primeira ocorrência de 4
        // Usamos IntStream.range para obter um Stream de índices (i = 0, 1, 2, ...)
        // .filter(i -> nums[i] == 4) encontra o índice onde o valor é 4
        // .findFirst() pega o primeiro índice que satisfaz a condição
        // .orElse(nums.length) retorna o comprimento total do array se 4 não for encontrado (o que é o limite correto)
        int indexOfFirstFour = IntStream.range(0, nums.length)
                                        .filter(i -> nums[i] == 4)
                                        .findFirst()
                                        .orElse(nums.length);

        // 2. Determinar o tamanho do novo array
        int tamanhoNovoArray = indexOfFirstFour; // Este é exatamente o número de elementos antes do 4

        // 3. Criar e copiar os elementos
        // Como o índice encontrado é o tamanho exato, usamos ele para a cópia.
        return Arrays.copyOf(nums, tamanhoNovoArray);
    }
```
# x102 - Same Ends

## Descrição

Dado um array de valores inteiros, retorne verdadeiro se o grupo de n números no início do array for igual ao grupo de n números no final do array. Por exemplo, com {5, 6, 45, 99, 13, 5, 6}, os extremos são iguais para n == 0 e n == 2, e falso para n == 1 e n == 3. Você pode assumir que n está no intervalo de 0 a nums.length, inclusive.

## Solução

1. Percorro o vetor de 0 até o índice n.
2. Criei variáveis para comparar a posição inicial e final.
3. Caso haja algum número que não seja igual, retorna falso.
4. Se terminar de iterar até n sem elementos falsos, retorna true.
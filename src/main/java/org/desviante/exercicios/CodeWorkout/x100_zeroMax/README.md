# Exercício X100: zeroMax

## Descrição

Escreva uma função em Java que implemente a seguinte lógica: Retorne uma versão do array fornecido onde cada valor zero no array é substituído pelo maior valor ímpar à direita do zero. Se não houver nenhum valor ímpar à direita do zero, deixe o zero como zero. Dica: para resolver este problema, você pode usar uma segunda função auxiliar, por exemplo, para encontrar o maior valor ímpar à direita de uma posição especificada.

## Solução

1. Percorri o array de trás para frente, assim era possível encontrar com antecedência o possível maior ímpar à direita de um zero.
2. Caso não encontre um maior a direita ímpar, permanece em zero.
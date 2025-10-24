# X19: makeBricks

Escreva uma função em Java para implementar a seguinte lógica: Queremos construir uma fileira de tijolos com `goal` centímetros de comprimento. Temos um número de `small` tijolos (1 pol cada) e `big` tijolos (5 pol cada). Retorne `true` se for possível construir a fileira `goal` escolhendo entre os tijolos fornecidos. Isso é um pouco mais difícil do que parece e pode ser feito sem loops (dica: use o operador mod `%`).

Exemplo: Se tivermos 2 tijolos de 5 polegadas e 3 de 1 polegadas e o objetivo for construir uma parede de 9 polegadas. O resultado deve ser falso, pois em nenhuma hipótese poderemos ter 5+3=8, e 5+5=10, o que fica abaixo do tamanho necessário no primeiro caso, e acima do tamanho necessário nos demais casos.

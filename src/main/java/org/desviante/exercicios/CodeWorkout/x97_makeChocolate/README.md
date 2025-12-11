# Exercício X97: makeChocolate

## Descrição

Queremos preparar um pacote com uma quantidade exata de quilos de chocolate. Temos barras pequenas (1 quilo cada) e barras grandes (5 quilos cada). Retorne a quantidade de barras pequenas a serem usadas, assumindo que sempre usamos as barras grandes antes das pequenas. Retorne -1 se não for possível.

## Solução

1. Calculei a quantidade de barras grandes necessárias para atingir o objetivo.
2. Calculei a quantidade de barras grandes que seriam usadas considerando o valor mínimo entre a quantidade necessária e o estoque. Exemplo: Se forem 3 barras necessárias, mas só possuirmos 2 no estoque, usamos 2. Se forem 3 barras necessárias e possuirmos 5 no estoque, só usamos as 3 necessárias.
3. Com a quantidade de barras grandes calculadas, obtive a quantidade restante para chegar ao objetivo.
4. Como cada barra pequena é igual a 1 unidade. Então a quantidade restante é igual a quantidade de barras pequenas que deve ser utilizada.
5. Verifique se há estoque suficiente de barras pequenas e retorno -1 caso não haja estoque.
6. Caso haja, retorno a quantidade de barras pequenas necessárias.

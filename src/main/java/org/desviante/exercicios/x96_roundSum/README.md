# X96: roundSum

Para este problema, arredondaremos um valor `int` para o múltiplo de 10 mais próximo se o seu dígito mais à direita for 5 ou mais, então 15 arredonda para 20. 

Alternativamente, arredondaremos para o múltiplo de 10 anterior se o seu dígito mais à direita for menor que 5, então 12 arredonda para 10. 

Dados 3 valores `int`, a, b, e c, retorne a soma de seus valores arredondados.

Para evitar repetição de código, escreva uma função auxiliar separada `public int round10(int num)` e chame-a 3 vezes. Escreva a função auxiliar inteiramente abaixo e no mesmo nível de indentação que `roundSum()`.
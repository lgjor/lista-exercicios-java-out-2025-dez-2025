# Exercício X98: without2

## Descrição

Dada uma string, se a mesma substring de 2 caracteres aparecer tanto no início quanto no fim, retorne o conteúdo da string sem a substring de 2 caracteres do início. Por exemplo, "HelloHe" resulta em "lloHe". Observe que a substring de 2 caracteres no início pode se sobrepor à do final, então "Hi" resulta em "". Se os dois caracteres no início e no fim da string não coincidirem, retorne a string original sem alterações.

## Solução

1. Verifiquei casos especiais: Se a string tem tamanho menor que dois ou igual a dois.
2. Capturei o prefixo e o sulfixo de 2 caracteres utilizando o método substring.
3. Comparei prefixo e sulfixo:
   Se prefixo = sulfixo -> retorna a palavra resultante sem prefixo.
   Se não for igual retorna a própria palavra.

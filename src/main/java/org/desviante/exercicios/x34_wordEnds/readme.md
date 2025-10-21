# x34_wordEnds

Escreva uma função em Java que implemente a seguinte lógica: Dada uma string `str` e um `word`, retorne uma string composta de cada caractere imediatamente antes e imediatamente depois de cada aparição do `word` em `str`. Ignore os casos em que não há caractere antes ou depois do `word`, e um caractere pode ser incluído duas vezes se estiver entre duas palavras.

Exemplos:
```
wordEnds("abcXY123XYijk", "XY") -> "c13i"

wordEnds("XY123XY", "XY") -> "13"

wordEnds("XY1XY", "XY") -> "11"
```
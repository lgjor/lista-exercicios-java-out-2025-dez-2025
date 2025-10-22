# Capturando algumas exceções

Considere os dois métodos: `methodThrowingExceptions` e `methodCatchingSomeExceptions`.

O primeiro lança exceções não verificadas de diferentes tipos.

Sua tarefa é implementar o segundo método. Ele deve chamar o primeiro método e capturar dois tipos de exceções:

`ArrayIndexOutOfBoundsException`
`NumberFormatException`

Dentro do(s) bloco(s) catch, você deve imprimir o nome da classe da exceção tratada (apenas o nome, sem pacotes) na saída padrão, como:

`ArrayIndexOutOfBoundsException`

Outros tipos de exceções não devem ser capturados pelo methodCatchingSomeExceptions.
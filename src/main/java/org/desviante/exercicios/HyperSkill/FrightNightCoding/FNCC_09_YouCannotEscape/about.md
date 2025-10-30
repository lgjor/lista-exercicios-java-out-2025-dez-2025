# Sobre a Solução - YouCannotEscape

Este projeto resolve o problema de encontrar o menor caminho em um mapa, do ponto de partida ('P') até o objetivo ('G'), utilizando busca em largura (BFS) para garantir o caminho mais curto.

## Classes e Responsabilidades

- **YouCannotEscape.java**
  - Classe principal (main).
  - Orquestra a execução: carrega o mapa, encontra os endpoints e computa o menor caminho, exibindo o resultado.

- **ReadMap.java**
  - Responsável por ler o arquivo do mapa e construir a matriz de caracteres.
  - Identifica automaticamente as posições do início ('P') e do objetivo ('G'), retornando um objeto `EndPoints` com essas coordenadas.

- **EndPoints.java**
  - Estrutura que encapsula as posições do início e do objetivo.
  - Torna claro e seguro o manuseio dos pontos principais do percurso.

- **Position.java**
  - Representa uma posição (linha e coluna) no mapa.
  - Utilizada para armazenar estados na busca e reconstrução do caminho.

- **PathFinder.java**
  - Implementa o algoritmo de busca (BFS) para encontrar o menor caminho do início ao objetivo.
  - Fornece o resultado no formato solicitado (ex: "UDLR").

- **Movimento.java**
  - Enum que representa cada movimento possível: Cima (U), Baixo (D), Esquerda (L), Direita (R).
  - Para cada direção, fornece o deslocamento em linha/coluna e o símbolo correspondente.

## Abordagem
- O projeto segue uma arquitetura orientada a objetos, desacoplando leitura, representação e lógica de navegação.
- O uso de BFS garante o menor caminho.
- Demais utilidades (como enumeração dos movimentos) tornam o código mais limpo, reutilizável e fácil de manter.

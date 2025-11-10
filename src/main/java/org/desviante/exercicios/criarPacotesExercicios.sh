#!/bin/bash

# Define o número inicial e final dos exercícios
INICIO=56
FIM=70

# Array contendo os nomes dos exercícios, ordenados de X56 a X70
# (Índice 0 é para o X56, Índice 1 é para o X57, e assim por diante)
NAMES=(
    "lucky13"       # X56
    "num28"         # X57
    "moni14"        # X58
    "only14"        # X59
    "fizzBuzz"      # X60
    "no14"          # X61
    "either24"      # X62
    "has77"         # X63
    "has12"         # X64
    "hasOneThree"   # X65
    "twoTwo"        # X66
    "canBalance"    # X67
    "maxSpan"       # X68
    "fix34"         # X69
    "maxMirror"     # X70
)

echo "Criando pacotes (diretórios) para os exercícios de X${INICIO} a X${FIM} conforme a lista..."
echo "---"

# Loop para iterar de 56 a 70
for i in $(seq $INICIO $FIM); do
    # Calcula o índice correto no array de nomes (Ex: 56-56=0, 57-56=1)
    INDEX=$((i - INICIO))
    
    # Obtém o nome do exercício
    NOME_EXERCICIO=${NAMES[INDEX]}
    
    # Constrói o nome final do diretório no formato xNN_nomeExercicio
    NOME_DIRETORIO="x${i}_${NOME_EXERCICIO}"
    
    # Cria o diretório (pacote)
    mkdir "$NOME_DIRETORIO" 2>/dev/null
    
    # Exibe uma mensagem confirmando a criação
    echo "Criado: $NOME_DIRETORIO"
done

echo "---"
echo "Criação de todos os 15 pacotes concluída."
#!/bin/bash

# =======================================================
# PARÂMETROS DE CONFIGURAÇÃO
# Define o número inicial e final dos exercícios (Ex: X97 a X101)
INICIO=97
FIM=101

# Array contendo os nomes dos exercícios, ordenados por número
NAMES=(
    "makeChocolate"    # X97
    "without2"         # X98
    "firstHalf"        # X99
    "zeroMax"          # X100
    "sameEnds"         # X101
)
# =======================================================

# Calcula o número total de exercícios: (FIM - INICIO) + 1
TOTAL=$((FIM - INICIO + 1))

# VERIFICAÇÃO: Garante que o número de nomes corresponda ao total esperado.
if [ ${#NAMES[@]} -ne $TOTAL ]; then
    echo "ERRO DE CONFIGURAÇÃO: O número de nomes no array (${#NAMES[@]}) não corresponde ao total de exercícios esperado ($TOTAL)."
    echo "Verifique se a lista 'NAMES' está completa."
    exit 1
fi

echo "Criando $TOTAL pacotes (diretórios) para os exercícios de X${INICIO} a X${FIM}..."
echo "---"

# Loop para iterar do INICIO ao FIM
for i in $(seq $INICIO $FIM); do

    INDEX=$((i - INICIO))
    NOME_EXERCICIO=${NAMES[INDEX]}
    NOME_DIRETORIO="x${i}_${NOME_EXERCICIO}"

    # 1. Tenta criar o diretório
    if mkdir "$NOME_DIRETORIO"; then

        # 2. SE o diretório foi criado com sucesso, cria o arquivo README.md
        README_PATH="${NOME_DIRETORIO}/README.md"

        # Adiciona o título no README
        echo "# Exercício X${i}: ${NOME_EXERCICIO}" > "$README_PATH"
        echo "" >> "$README_PATH"
        echo "## Descrição" >> "$README_PATH"
        echo "" >> "$README_PATH"
        echo "## Solução" >> "$README_PATH"

        echo "Criado: $NOME_DIRETORIO (e README.md)"
    else
        # Mensagem se o diretório já existia ou houve outro erro
        echo "Atenção: $NOME_DIRETORIO já existe ou falhou a criação."
    fi
done

echo "---"
echo "Criação de todos os $TOTAL pacotes e arquivos README.md concluída."
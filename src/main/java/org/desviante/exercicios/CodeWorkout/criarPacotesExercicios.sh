#!/bin/bash

# =======================================================
# PARÂMETROS DE CONFIGURAÇÃO
# Define o número inicial e final para o intervalo principal de exercícios.
# Além deste intervalo, os exercícios fora de ordem devem ser adicionados ao array 'EXTRA_EXERCISES'.
INICIO=115
FIM=126

# Array contendo os dados dos exercícios, no formato:
# "Número|NomeFuncao|Descrição|Tags"
# NOTA: O número do exercício é usado como chave de busca.

EXERCISES_DATA=(
    "115|post4|Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 in the...|Java arrays loops"
    "116|notAlone|We'll say that an element in an array is \"alone\" if there are values before and after it, and those values are different from it. Return...|Java arrays loops"
    "117|zeroFront|Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are grouped at the start of...|Java arrays loops"
    "118|linearIn|Given two arrays of ints sorted in increasing order, called outer and inner, return true if all of the numbers in inner also appear in...|Java arrays loops"
    "119|squareUp|Given n >= 0, create an array of length n * n with the following pattern, shown here for n = 3 : {0, 0, 1, 0, 2, 1, 3, 2, 1} (spaces...|Java arrays loops"
    "120|makeOutWord|Given an out string of length 4, such as \"<<>>\", and a word, return a new string where the word is in the middle of the out...|Java String substring"
    "121|extraEnd|Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string's length will be at least 2...|Java String"
    "122|firstTwo|Given a string, return the string made of its first two chars, so the string \"Hello\" yields \"He\". If the string is shorter than length 2...|Java String substring"
    "123|catDog|Return true if the string \"cat\" and \"dog\" appear the same number of times in the given string.|Java String conditionals"
    "124|bobThere|Return true if the given string contains a \"bob\" string, but where the middle 'o' character can be any character.|Java String conditionals"
    "125|repeatSeparator|Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator...|Java String loops"
    "126|countYZ|Given a string, count the number of words ending in 'y' or 'z'--so the 'y' in \"heavy\" and the 'z' in \"fez\" count, but not the 'y' in...|Java String conditionals"
)

# Exercícios que estão fora da sequência principal (Ex: X158, X201)
EXTRA_EXERCISES_DATA=(
    "158|bunnyEars2|We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, 5, ...) have the normal 2 ears. The even bunnies (2, 4,...|Java recursion logic conditionals"
)

# =======================================================
# FUNÇÕES DE AUXÍLIO

# Função para extrair dados do exercício (Nome da Função, Descrição, Tags)
function get_exercise_data() {
    local num=$1
    local array_ref="$2"

    # Avalia a string para torná-la um array acessível
    local DATA_ARRAY
    eval "DATA_ARRAY=(\"\${$array_ref[@]}\")"

    for item in "${DATA_ARRAY[@]}"; do
        IFS='|' read -r ExNum ExName ExDesc ExTags <<< "$item"
        if [ "$ExNum" == "$num" ]; then
            echo "$ExName|$ExDesc|$ExTags"
            return 0
        fi
    done
    return 1
}

# Função principal para criar o pacote
function create_package() {
    local num=$1
    local name=$2
    local desc=$3
    local tags=$4

    local NOME_DIRETORIO="x${num}_${name}"

    # 1. Tenta criar o diretório
    if mkdir "$NOME_DIRETORIO" 2>/dev/null; then

        # 2. SE o diretório foi criado com sucesso, cria o arquivo README.md
        README_PATH="${NOME_DIRETORIO}/README.md"

        # Conteúdo do README
        {
            echo "# Exercício X${num}: ${name}"
            echo ""
            echo "## Tags"
            echo "\`${tags}\`"
            echo ""
            echo "---"
            echo ""
            echo "## Descrição"
            echo ""
            echo "> ${desc}"
            echo ""
            echo "---"
            echo ""
            echo "## Solução"
            echo ""
            echo "\`\`\`java"
            echo "public class ${name} {"
            echo "    // Sua solução aqui"
            echo "}"
            echo "\`\`\`"

        } > "$README_PATH"

        echo "Criado: $NOME_DIRETORIO (e README.md)"
    else
        # Mensagem se o diretório já existia ou houve outro erro
        echo "Atenção: $NOME_DIRETORIO já existe ou falhou a criação."
    fi
}

# =======================================================
# EXECUÇÃO PRINCIPAL

echo "Iniciando a criação de pacotes..."
echo "---"

# Processa o intervalo principal (INICIO a FIM)
for i in $(seq $INICIO $FIM); do
    DATA=$(get_exercise_data "$i" "EXERCISES_DATA")
    if [ $? -eq 0 ]; then
        IFS='|' read -r ExName ExDesc ExTags <<< "$DATA"
        create_package "$i" "$ExName" "$ExDesc" "$ExTags"
    else
        echo "Aviso: Dados não encontrados para o exercício X${i}. Pulando."
    fi
done

# Processa os exercícios extras
echo "---"
echo "Processando exercícios fora da sequência principal..."

for item in "${EXTRA_EXERCISES_DATA[@]}"; do
    IFS='|' read -r ExNum ExName ExDesc ExTags <<< "$item"
    create_package "$ExNum" "$ExName" "$ExDesc" "$ExTags"
done

echo "---"
echo "Criação de todos os pacotes e arquivos README.md concluída."
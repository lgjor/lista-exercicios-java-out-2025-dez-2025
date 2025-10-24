# Lista de nomes de diretórios que você deseja criar
$NomesDiretorios = "x26_atFirst", "x28_theEnd", "x29_factorial", "x30_repeatEnd", "x31_plusOut", "x32_mixString", "x33_zipZap", "x34_wordEnds", "x35_countCode", "x36_endOther", "x37_xyzThere", "x38_xyBalance", "x39_getSandwich", "x40_Sum_3_integers_in_array", "x41_plusTwo", "x42_frontPiece", "x43_countEvens", "x44_sum67", "x45_isEverywhere", "x47_withoutTen", "x48_sum13", "x49_modThree", "x50_tenRun", "x51_bigDiff", "x52_centeredAverage"

# Caminho raiz onde essas pastas serão criadas

# Main
$CaminhoMainBase = "D:\projetos\lista-exercicios-java-out-2025-dez-2025\src\main\java\org\desviante\exercicios"

# Test
$CaminhoTestBase = "D:\projetos\lista-exercicios-java-out-2025-dez-2025\src\test\java\org\desviante\exercicios"

# Loop para criar cada diretório
foreach ($Nome in $NomesDiretorios) {
    $CaminhoCompleto = Join-Path -Path $CaminhoTestBase -ChildPath $Nome
    
    # Cria o diretório. O -Force é uma boa prática.
    Write-Host "Criando diretório: $CaminhoCompleto"
    New-Item -Path $CaminhoCompleto -ItemType Directory -Force
}
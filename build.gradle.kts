plugins {
    id("java")
    id("application")
}

group = "org.desviante"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

// Configuração para facilitar a execução de diferentes exercícios
tasks.register("runAnoBissexto", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Ano Bissexto"
    mainClass.set("org.desviante.exercicios.anobissexto.AnoBissexto")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runNumberGenerators", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Number Generators"
    mainClass.set("org.desviante.exercicios.numbergenerators.Main")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runPublication", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Publication"
    mainClass.set("org.desviante.exercicios.publication.Main")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runLessByTen", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Less By Ten"
    mainClass.set("org.desviante.exercicios.x03_lessbyten.LessByTen")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

tasks.register("runTeaParty", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Tea Party"
    mainClass.set("org.desviante.exercicios.x04_teaParty.TeaParty")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runSortaSum", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Sorta Sum"
    mainClass.set("org.desviante.exercicios.x01_sortasum.SortaSum")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

tasks.register("runDice", JavaExec::class) {
    group = "exercicios"
    description = "Executa o jogo de dados (Programmazione OOP)"
    mainClass.set("org.desviante.exercicios.programmazione.dice.Dice")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

tasks.register("runLargest", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício de recursão - Largest"
    mainClass.set("org.desviante.exercicios.RecursionProgrammingExerciseLargest.Main")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runIn1To10", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício In1To10"
    mainClass.set("org.desviante.exercicios.x02_in1To10.In1To10")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runAnswerCell", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Answer Cell"
    mainClass.set("org.desviante.exercicios.x05_answerCell.AnswerCell")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runHelloName", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Hello Name"
    mainClass.set("org.desviante.exercicios.x06_HelloName.HelloName")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

tasks.register("runEndsLy", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Ends Ly"
    mainClass.set("org.desviante.exercicios.X7_endsLy.EndsLy")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runSeeColor", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício See Color"
    mainClass.set("org.desviante.exercicios.x08_seeColor.SeeColor")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("runMakeTags", JavaExec::class) {
    group = "exercicios"
    description = "Executa o exercício Make Tags"
    mainClass.set("org.desviante.exercicios.x09_makeTags.MakeTags")
    classpath = sourceSets["main"].runtimeClasspath
}

// Tarefa padrão para listar todos os exercícios
tasks.register("listarExercicios") {
    group = "exercicios"
    description = "Lista todos os exercícios disponíveis"
    doLast {
        println("""
        ====================================
        EXERCÍCIOS DISPONÍVEIS
        ====================================
        
        EXERCÍCIOS GERAIS:
        1. Ano Bissexto
           gradle runAnoBissexto
        
        2. Number Generators
           gradle runNumberGenerators
        
        3. Publication
           gradle runPublication
        
        4. Dice (Jogo de Dados)
           gradle runDice
        
        5. Recursion: Largest (Maior Elemento)
           gradle runLargest
        
        EXERCÍCIOS NUMERADOS (x0n_):
        6. X01 - Sorta Sum
           gradle runSortaSum
        
        7. X02 - In1To10 (Intervalo 1-10)
           gradle runIn1To10
        
        8. X03 - Less By Ten
           gradle runLessByTen
        
        9. X04 - Tea Party
           gradle runTeaParty
        
        10. X05 - Answer Cell
           gradle runAnswerCell
        
        11. X06 - Hello Name
           gradle runHelloName
        
        12. X07 - Ends Ly
           gradle runEndsLy
        
        13. X08 - See Color
           gradle runSeeColor
        
        14. X09 - Make Tags
           gradle runMakeTags
        
        15. X10 - Combo String (somente testes)
           gradle test --tests "*comboString*"
        
        ====================================
        Para executar os testes:
           gradle test
        
        Para testar um exercício específico:
           gradle test --tests "*x01_sortasum*"
           gradle test --tests "*x06_HelloName*"
           gradle test --tests "*comboString*"
        ====================================
        """.trimIndent())
    }
}
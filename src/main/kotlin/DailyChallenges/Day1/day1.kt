package DailyChallenges.Day1

import java.io.File

fun day1(){

    // Q1: [...] Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
    // Q2: [...] In your expense report, what is the product of the three entries that sum to 2020?

    val array = loadTxt()
    puzzle1(array)
    puzzle2(array)
}

fun loadTxt(): List<Int> {
    var array = emptyList<Int>()

    try{
        File("src/main/kotlin/DailyChallenges/Day1/day1.txt").forEachLine {
            array += it.toInt()
        }
    }catch(e: Exception){
        println("File not found.")
    }
    return array
}

fun puzzle1(array: List<Int>) {
    for (i in array){
        for (j in array) {
            if(i+j == 2020){
                println("Puzzle 1: $i * $j = ${i*j}\n")
                return
            }
        }
    }
}

fun puzzle2(array: List<Int>) {
    for (i in array){
        for (j in array) {
            for (k in array){
                if(i+j+k == 2020){
                    println("Puzzle 2: $i * $j * $k = ${i*j*k}")
                    return
                }
            }
        }
    }
}

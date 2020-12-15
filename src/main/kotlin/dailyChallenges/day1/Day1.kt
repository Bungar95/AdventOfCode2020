package dailyChallenges.day1

import dailyChallenges.loadTxtAsInt

class Day1() {

    fun day1() {

        // Q1: [...] Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
        // Q2: [...] In your expense report, what is the product of the three entries that sum to 2020?

        val array = loadTxtAsInt("src/main/kotlin/dailyChallenges/day1/day1.txt")
        day1puzzle1(array)
        day1puzzle2(array)
    }

    fun day1puzzle1(array: List<Int>) {
        for (i in array) {
            for (j in array) {
                if (i + j == 2020) {
                    println("Puzzle 1: $i * $j = ${i * j}\n")
                    return
                }
            }
        }
    }

    fun day1puzzle2(array: List<Int>) {
        for (i in array) {
            for (j in array) {
                for (k in array) {
                    if (i + j + k == 2020) {
                        println("Puzzle 2: $i * $j * $k = ${i * j * k}")
                        return
                    }
                }
            }
        }
    }
}
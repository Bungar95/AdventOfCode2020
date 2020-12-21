package adventOfCode20.day6

import adventOfCode20.loadTxtAsString

class Day6() {

    var p1AnswerPot: Int = 0
    var p2AnswerPot: Int = 0

    fun day6() {
        val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day6/day6.txt")
        var uniqueCharArray = mutableListOf<Char>()
        var rowGroupArray = mutableListOf<String>()

        for (row in array) {
            if (row.isNotBlank()) {
                rowGroupArray.add(row)
                for (i in row) {
                    if (!uniqueCharArray.contains(i)) {
                        //print(i)
                        uniqueCharArray.add(i)
                    }
                }

            } else {
                //println("$uniqueCharArray, ${uniqueCharArray.size}")
                p1AnswerPot += uniqueCharArray.size
                checkDay6Puzzle2(uniqueCharArray, rowGroupArray)
                uniqueCharArray.clear()
                rowGroupArray.clear()
            }
        }
        println("Puzzle 1 total: $p1AnswerPot")
        println("Puzzle 2 total: $p2AnswerPot")
    }

    fun checkDay6Puzzle2(uniqueCharArray: MutableList<Char>, rowGroupArray: MutableList<String>) {

        for (i in uniqueCharArray) {
            var checkChar = 0
            for (row in rowGroupArray) {
                if (row.contains(i)) checkChar++
            }
            if (checkChar == rowGroupArray.size) p2AnswerPot++
        }
    }
}
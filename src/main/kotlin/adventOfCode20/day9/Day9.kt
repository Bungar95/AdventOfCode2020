package adventOfCode20.day9

import adventOfCode20.loadTxtAsString

class Day9 {

    private val numbers = mutableListOf<Long>()
    private var previous25 = listOf<Long>()

    fun day9() {
        val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day9/day9.txt")
        for (i in array) {
            numbers.add(i.toLong())
        }
        val start = 25
        checkNumber(start)
    }

    private fun checkNumber(indexNum: Int) {
        var currentNumber = indexNum
        var checkState = 0
        previous25 = numbers.slice((currentNumber - 25) until currentNumber)
        for (i in previous25) {
            if (previous25.contains(numbers[currentNumber] - i)) checkState++
        }
        if (checkState == 0) {
            println("Puzzle 1: ${numbers[indexNum]}")
            println("Puzzle 2: ${startPuzzle2(numbers[indexNum])}")
        } else checkNumber(++currentNumber)
    }

    private fun startPuzzle2(indexNum: Long): Long {

        var i = 0
        var j = 1
        var sum = numbers[i] + numbers[j]

        fun increaseJ() {
            j++
            sum += numbers[j]
        }

        while (j < numbers.size) {
            when {
                sum < indexNum -> increaseJ()
                sum > indexNum -> {
                    sum -= numbers[i]
                    i++
                    if (i == j) increaseJ()
                }
                else -> {
                    val range = i..j
                    val min = numbers.slice(range).minOrNull()!!
                    val max = numbers.slice(range).maxOrNull()!!
                    return max+min
                }
            }
        }
        return 0
    }

}



package dailyChallenges.day9

import dailyChallenges.loadTxtAsString

class Day9 {

    private val numbers = mutableListOf<Long>()
    private var previous25 = listOf<Long>()

    fun day9(){
        val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day9/day9.txt")
        for(i in array){
            numbers.add(i.toLong())
        }
        val start = 25
        checkNumber(start)

    }

    private fun checkNumber(l: Int) {
        var currentNumber = l
        var checkState = 0
        previous25 = numbers.slice((currentNumber - 25) until currentNumber)
        for (i in previous25) {
            if (previous25.contains(numbers[currentNumber]-i)) checkState++
        }
        if(checkState == 0) println(numbers[l])
        else checkNumber(++currentNumber)
    }

}
package adventOfCode20.day10

import adventOfCode20.loadTxtAsInt

class Day10 {

    var oneDifference = 0
    var threeDifference = 1 // part of challenge: *In addition, your device has a built-in joltage adapter rated for 3 jolts higher than the highest-rated adapter in your bag.*

    fun day10(){
        var array = loadTxtAsInt("src/main/kotlin/dailyChallenges/day10/day10.txt").sorted()
        var iterator = array.listIterator()
        var xPoint = iterator.next()

        while (iterator.hasNext()){
            var yPoint = iterator.next()
            addToCounters(xPoint, yPoint)
            if(yPoint == array.last()) addToCounters(xPoint, yPoint) //needed because last element won't go through loop
            xPoint = yPoint
        }
        println(oneDifference*threeDifference)
    }

    private fun addToCounters(xPoint: Int, yPoint: Int) {
        when(yPoint-xPoint){
            3 -> threeDifference++
            1 -> oneDifference++
        }
    }

}

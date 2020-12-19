package dailyChallenges.day13

import dailyChallenges.loadTxtAsString

class Day13 {
    var array = loadTxtAsString("src/main/kotlin/dailyChallenges/day13/day13.txt")
    private val earliestDepart = array[0].toLong()
    var busIds = emptyList<Long>().toMutableList()
    var earliestBus: Long = earliestDepart
    var earliestBusId: Long = 0

    fun day13(){

        for(i in array[1].split(",")) if(isNumber(i)) busIds.add(i.toLong())
        //println(busIds)
        for(i in busIds) checkTime(i)
        println("Puzzle 1: Earliest bus is $earliestBusId at $earliestBus, result: ${(earliestBus-earliestDepart)*earliestBusId}")
    }

    private fun checkTime(i: Long) {
        var time= i
        while(time < earliestDepart)
            time += i
        checkIfEarliestBus(time, i)
        //println("$i bus can come at $time")
    }

    private fun checkIfEarliestBus(time: Long, i: Long) {
        if(earliestBus == earliestDepart) earliestBus = time
        else if(time < earliestBus) {
            earliestBus = time
            earliestBusId = i
        }
    }

    private fun isNumber(string: String): Boolean {
        return try {
            string.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }
}
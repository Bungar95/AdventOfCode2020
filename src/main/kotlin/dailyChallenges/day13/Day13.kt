package dailyChallenges.day13

import dailyChallenges.loadTxtAsString

class Day13 {

    fun day13(){
        var busIds = emptyList<Int>().toMutableList()
        var array = loadTxtAsString("src/main/kotlin/dailyChallenges/day13/day13.txt")

        for(i in array[1].split(",")) if(isNumber(i)) busIds.add(i.toInt())
        println(busIds)

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
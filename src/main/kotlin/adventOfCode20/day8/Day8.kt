package adventOfCode20.day8

import adventOfCode20.loadTxtAsString

class Day8Move(
    val action: String,
    val offset: Int,
    var executed: Int = 0
)

class Day8 {

    var glValue: Int = 0
    private val moves = mutableListOf<Day8Move>()

    fun day8(){
        val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day8/day8.txt")
        for(i in array){
            var move = Day8Move(i.split(" ")[0], i.split(" ")[1].toInt())
            moves.add(move)
        }

        startMove(moves[0])
        println(glValue)
    }

    private fun startMove(currentMove: Day8Move) {
        var num = moves.indexOf(currentMove)
        currentMove.executed++
        if(checkExecutedNum(currentMove.executed)) {
            when (currentMove.action) {
                "acc" -> {
                    glValue += currentMove.offset
                    startMove(moves[++num])
                }
                "jmp" -> {
                    startMove(moves[num + currentMove.offset])
                }
                "nop" -> {
                    startMove(moves[++num])
                }
            }
        } else return
    }

    private fun checkExecutedNum(executed: Int): Boolean {
        return executed != 2
    }

}
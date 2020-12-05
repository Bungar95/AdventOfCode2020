package DailyChallenges.Day3

import DailyChallenges.loadTxtAsString
import java.lang.Exception

var treeCounter = 0

fun day3() {

    val array = loadTxtAsString("src/main/kotlin/DailyChallenges/Day3/day3.txt")
    var x=0 //row
    var y=0 //column
    var rightMoves: Int
    var downMoves: Int

    while(true){
        try {
            var maxRowSize = array[x].length
            checkPosition(array[x][y])
            y = continueSleight(y, maxRowSize)
            x++
        } catch (e: Exception){
            println(treeCounter)
            return
        }
    }
}

fun checkPosition(c: Char) {
    if(c.toString() == "#") treeCounter++
}

fun continueSleight(y: Int, max: Int): Int {

    var column = y
    when(max-(column+1)){
        2 -> return 0 // y will land on 1st column next row
        1 -> return 1 // y will land on 2nd column next row
        0 -> return 2 // y will land on 3rd column next row
        else -> {
            column += 3
            return column
        }
    }
}

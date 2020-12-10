package dailyChallenges.day3

import dailyChallenges.loadTxtAsString
import java.lang.Exception
import java.math.BigInteger


val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day3/day3.txt")

fun day3() {

    day3puzzle1()
    day3puzzle2()
}

fun day3puzzle1() {
    //Q1: start by counting all the trees you would encounter for the slope right 3, down 1
    println("Puzzle 1: (3,1) -> ${doSlope(1, 1)} trees")
}

fun day3puzzle2() {
    //Q2: What do you get if you multiply together the number of trees encountered on each of the listed slopes?
    var result: BigInteger = doSlope(1, 1)
    result *= doSlope(3, 1)
    result *= doSlope(5, 1)
    result *= doSlope(7, 1)
    result *= doSlope(1, 2)
    println("Puzzle 2: (1,1)*(3,1)*(5,1)*(7,1)*(1,3) -> $result trees")
}

fun doSlope(rowNum: Int, columnNum: Int): BigInteger {

    var treeCounter : Int = 0
    var x=0 //row
    var y=0 //column
    val right = rowNum
    val down = columnNum

    while(true){
        try {
            var maxRowSize = array[x].length
            if(array[x][y].toString() == "#") treeCounter++
            y = updateColumn(y, right, maxRowSize)
            x += down
        } catch (e: Exception){
            return treeCounter.toBigInteger()
        }
    }
}

fun updateColumn(y:Int, right:Int, maxRowSize:Int): Int {

    var column = y

    if(maxRowSize-(column+1) >= right) {
        column += right
    }else{
        column = right-(maxRowSize-column)
    }
    return column
}

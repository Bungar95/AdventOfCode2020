package dailyChallenges.day5

import dailyChallenges.loadTxtAsString

fun day5() {
    val fileArray = loadTxtAsString("src/main/kotlin/dailyChallenges/day5/day5.txt")
    var max: Int = 0
    var puzzle2: MutableList<Int> = arrayListOf(1)

    for (row in fileArray){

        var arrayRow = arrayOf(0,127)
        var arrayColumn = arrayOf(0, 7)
        var rowSeat: Int = 0
        var columnSeat: Int = 0

        println(row)
        for (i in row) {

            when (i.toString()) {
                "F", "B" -> {
                    if(checkIfFinalSeat(arrayRow))
                        rowSeat = declareSeat(i.toString(), arrayRow)
                    //println("${arrayRow[0]} ${arrayRow[1]}")
                    arrayRow = appointSeat(i.toString(), arrayRow)

                }
                "R", "L" -> {
                    if(checkIfFinalSeat(arrayColumn))
                        columnSeat = declareSeat(i.toString(), arrayColumn)
                    //println("${arrayColumn[0]} ${arrayColumn[1]}")
                    arrayColumn = appointSeat(i.toString(), arrayColumn)

                }
            }
        }

        println("$rowSeat, $columnSeat, ${rowSeat*8+columnSeat}")
        var result = (rowSeat*8)+columnSeat
        puzzle2.add(result)
        if(result > max) max = result

    }
    checkPuzzle2SeatId(puzzle2)
    println("Max: $max")
}

fun checkPuzzle2SeatId(puzzle2: MutableList<Int>) {
    puzzle2.sort()
    for (i in 0 until puzzle2.lastIndex) {
        if (i + 2 >= puzzle2.lastIndex) {
            break
        }
        if (puzzle2[i] + 1 != puzzle2[i+2] - 1) {
            //Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.
            println("Puzzle 2 seat id: ${puzzle2[i]+2}")
        }
    }
}

fun checkIfFinalSeat(seat: Array<Int>): Boolean{
    return seat[0] - seat[1] == 1 || seat[1] - seat[0] == 1
}

fun declareSeat(char: String, arraySeat: Array<Int>): Int {

    return if(char == "F" || char == "L")
        arraySeat[0]
    else arraySeat[1]

}

fun appointSeat(char: String, arrayRowOrColumn: Array<Int>): Array<Int> {

    return if (char == "F" || char ==  "L") {
        var median = (arrayRowOrColumn[0]+arrayRowOrColumn[1])/2
        arrayOf(arrayRowOrColumn[0], median)
    } else {
        var median = (arrayRowOrColumn[0]+arrayRowOrColumn[1])/2+1
        arrayOf(median, arrayRowOrColumn[1])
    }

}

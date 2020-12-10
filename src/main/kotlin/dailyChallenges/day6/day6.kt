package dailyChallenges.day6

import dailyChallenges.loadTxtAsString

var answerPot: Int = 0

fun day6() {
    val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day6/day6.txt")
    var groupArray = mutableListOf<Char>()

    for(row in array) {
        if(row.isNotBlank()){
            for (i in row) {
                if (!groupArray.contains(i)) {
                    //print(i)
                    groupArray.add(i)
                }
            }
        }else{
            println("$groupArray, ${groupArray.size}")
            answerPot += groupArray.size
            groupArray.clear()
        }
    }
    println("Total: $answerPot")
}
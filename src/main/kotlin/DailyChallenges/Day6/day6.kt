package DailyChallenges.Day6

import DailyChallenges.loadTxtAsString

var answerPot: Int = 0

fun day6() {
    val array = "aabccxaxh" //loadTxtAsString("src/main/kotlin/DailyChallenges/Day6/day6.txt")
    var groupArray = mutableListOf<String>()
    var groupArrayCounter = 0
    for(i in array) {
        if (!groupArray.contains(i.toString())) {
            groupArray.add(i.toString())
        }
    }
    println(groupArray.size)
}
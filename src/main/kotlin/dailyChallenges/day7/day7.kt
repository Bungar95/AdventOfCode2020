package dailyChallenges.day7

import java.io.File

var bagThatContainsShinyGold = mutableListOf<String>()
var bagWithBagWithShinyGoldBagAKABagInception = mutableListOf<String>()
var shinyCount = 0
val bagContents =
    File("src/main/kotlin/dailyChallenges/day7/day7.txt").readLines()
        .associate { line ->
            val (bag, contains) = line.split(" bags contain ")
            val contentList = contains.split(", ")
                .mapNotNull { s ->
                    val (n, adj, color) = s.split(' ')
                    n.toIntOrNull()?.let { it to "$adj $color" }
                }
            bag to contentList
        }

fun day7() {

    findBagsWithShinyBags()
    bagception() // bags with bags with shiny gold bags
    day7puzzle1()

}

fun day7puzzle1() {
    println(shinyCount)
}

fun bagception() {
   loop@for (i in bagContents) {
        //if(i.value.isEmpty()) println(i) empty bags
        //if(i.value.size == 2) println(i) check how many bags a bag contains
        for (j in i.value) {
            if(j.second in bagThatContainsShinyGold || j.second == "shiny gold") {
                println(i)
                shinyCount++
                continue@loop
            }
        }
    }
}

fun findBagsWithShinyBags() {
    for (i in bagContents){
        //if(i.value.isEmpty()) println(i) empty bags
        //if(i.value.size == 2) println(i) check how many bags a bag contains
        for(j in i.value){
            if(j.second.contains("shiny gold"))
            bagThatContainsShinyGold.add(i.key)
        }
    }
}

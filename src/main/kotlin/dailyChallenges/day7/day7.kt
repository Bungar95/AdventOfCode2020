package dailyChallenges.day7

import dailyChallenges.loadTxtAsString
import java.io.File

fun day7() {
    //  MAP bag to it's contents - a list of pairs (count, color)
    val myBag = "shiny gold"
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

    println(bagContents)

}
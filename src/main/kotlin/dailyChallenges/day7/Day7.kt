package dailyChallenges.day7

import java.io.File

//result should be 211

class Day7() {

    var bagsWithShiny = emptySet<String>().toMutableSet()
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

        bagsWithShiny.add("shiny gold")
        for (bag in bagContents) {
            recursive(bag.key, bag.value)
        }
        val shiny = bagsWithShiny.size
        println("$shiny")
    }

    fun recursive(key: String, value: List<Pair<Int, String>>) {

        if (key == "shiny gold") {
            return
        }

        for (i in value) {

            if (i.second in bagsWithShiny || i.second == "shiny gold") {
                bagsWithShiny.add(key)
                return
            } else if (i.second.isBlank()) return
            else recursive(i.second, bagContents.getValue(i.second))
        }
    }
}
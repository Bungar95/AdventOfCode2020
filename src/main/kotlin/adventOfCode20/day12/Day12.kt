package adventOfCode20.day12

import adventOfCode20.loadTxtAsString
import kotlin.math.abs

class Day12 {
    var facedDirection: String = "E"
    var northSouth = 0 // north is positive, south negative
    var eastWest = 0 // east is positive, west negative

    fun day12() {

        var array = loadTxtAsString("src/main/kotlin/dailyChallenges/day12/day12.txt")

        for (i in array){
            when(i[0].toString()){
                "L", "R" -> facedDirection = turnShip(facedDirection, i)
                "N", "S", "E", "W" -> moveDirection(i)
                "F" -> moveForward(facedDirection,i)
            }
            //println("Did: $i, faced: $facedDirection, Num: $northSouth, $eastWest")
        }

        println("NS: $northSouth, EW: $eastWest, Manhattan distance: ${abs(northSouth)+abs(eastWest)} ")
    }

    private fun moveForward(facedDirection: String, i: String) {
        when(facedDirection){
            "N" -> northSouth += i.split("F")[1].toInt()
            "S" -> northSouth -= i.split("F")[1].toInt()
            "E" -> eastWest += i.split("F")[1].toInt()
            "W" -> eastWest -= i.split("F")[1].toInt()
        }
    }

    private fun moveDirection(i: String) {
        when(i[0].toString()){
            "N" -> northSouth += i.split("N")[1].toInt()
            "S" -> northSouth -= i.split("S")[1].toInt()
            "E" -> eastWest += i.split("E")[1].toInt()
            "W" -> eastWest -= i.split("W")[1].toInt()
        }
    }

    fun turnShip(facedDirection: String, command: String): String {
        var direction = facedDirection
        when (direction) {
            "N" -> {
                when (command) {
                    "L90", "R270" -> return "W"
                    "L180", "R180" -> return "S"
                    "L270", "R90" -> return "E"
                }
            }
            "S" -> {
                when (command) {
                    "L90", "R270" -> return "E"
                    "L180", "R180" -> return "N"
                    "L270", "R90" -> return "W"
                }
            }
            "E" -> {
                when (command) {
                    "L90", "R270" -> return "N"
                    "L180", "R180" -> return "W"
                    "L270", "R90" -> return "S"
                }
            }
            "W" -> {
                when (command) {
                    "L90", "R270" -> return "S"
                    "L180", "R180" -> return "E"
                    "L270", "R90" -> return "N"
                }
            }
        }
     return direction
    }
}



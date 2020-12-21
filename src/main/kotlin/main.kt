import adventOfCode20.day1.Day1
import adventOfCode20.day10.Day10
import adventOfCode20.day12.Day12
import adventOfCode20.day13.Day13
import adventOfCode20.day2.Day2
import adventOfCode20.day3.Day3
import adventOfCode20.day4.Day4
import adventOfCode20.day5.Day5
import adventOfCode20.day6.Day6
import adventOfCode20.day7.Day7
import adventOfCode20.day8.Day8
import adventOfCode20.day9.Day9
import jetbrains30Days.coffeeMachine.coffeMachine

fun main() {

    while (true) {
        println("Hello user, choose what you want. ('list' to get all the commands, 'exit' to leave)")
        println("Read the code for more context.")
        when (readLine()?.toLowerCase()) {
            "list" -> {
                println("Advent of Code 2020: 'day1', 'day2'... 'day13'")
                println("Other: 'chattybot', 'dailychallenge', 'coffee', 'unitconverter', 'parkinglot', 'flashcards'")
            }
            //Advent of Code 2020
            "day1" -> Day1().day1()
            "day2" -> Day2().day2()
            "day3" -> Day3().day3()
            "day4" -> Day4().day4()
            "day5" -> Day5().day5()
            "day6" -> Day6().day6()
            "day7" -> Day7().day7()
            "day8" -> Day8().day8()
            "day9" -> Day9().day9()
            "day10" -> Day10().day10()
            "day11" -> println("Didn't feel like doing this one, sorry mate.")
            "day12" -> Day12().day12()
            "day13" -> Day13().day13()
            // 30 day Kotlin challenge (started Kotlin during this)
            "chattybot" -> jetbrains30Days.simpleChattyBot.main()
            "dailychallenge" -> jetbrains30Days.dailyProblems.main()
            "coffee" -> jetbrains30Days.coffeeMachine.main()
            "unitconverter" -> jetbrains30Days.unitConverter.main()
            "parkinglot" -> jetbrains30Days.parkingLot.main()
            "flashcards" -> jetbrains30Days.flashcards.main()

            "exit", "leave", "c" -> {
                println("Bye!")
                return
            }
        }
    }
}
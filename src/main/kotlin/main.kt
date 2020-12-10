import dailyChallenges.day1.day1
import dailyChallenges.day2.day2
import dailyChallenges.day3.day3
import dailyChallenges.day4.day4
import dailyChallenges.day5.day5
import dailyChallenges.day6.day6

fun main() {

    while (true) {
        println("Welcome to Advent of Code: (write day1, day2... day24")
        when (readLine()?.toLowerCase()) {
            "hello", "hi", "howdy" -> println("Hello user, tell me which day.")
            "day1" -> day1()
            "day2" -> day2()
            "day3" -> day3()
            "day4" -> day4()
            "day5" -> day5()
            "day6" -> day6()
            "exit", "leave", "c" -> {
                println("Bye!")
                return
            }
        }
    }

}
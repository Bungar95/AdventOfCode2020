import DailyChallenges.Day1.day1

fun main() {

    while (true) {
        println("Welcome to Advent of Code: (write day1, day2... day24")
        when (readLine()?.toLowerCase()) {
            "hello", "hi", "howdy" -> println("Hello user, tell me which day.")
            "day1" -> day1()
            "exit" -> {
                println("Bye!")
                return
            }
        }
    }

}
package dailyChallenges.day2

import dailyChallenges.loadTxtAsString

var puzzle1Counter = 0
var puzzle2Counter = 0

fun day2(){

    val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day2/day2.txt")

    for (i in array){
        var min = i.split(":")[0].split(" ")[0].split("-")[0].toInt()
        var max = i.split(":")[0].split(" ")[0].split("-")[1].toInt()
        var letter = i.split(":")[0].split(" ")[1]
        var password = i.split(":")[1].trim()

        day2puzzle1(password, letter, min, max)
        day2puzzle2(password, letter, min, max)
    }
    // Each line gives the password policy and then the password.
    // Q1: The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid.
    println("Puzzle 1: $puzzle1Counter passwords")
    // Q2: Exactly one of these positions must contain the given letter.
    println("Puzzle 2: $puzzle2Counter passwords")
}

fun day2puzzle1(password: String, letter: String, min: Int, max: Int) {

    var letterCounter = 0
    for (j in password){
        if(letter == j.toString())
            letterCounter++
    }
    if(letterCounter >= min && letterCounter <= max) puzzle1Counter++
}

fun day2puzzle2(password: String, letter: String, min: Int, max: Int) {

    if((letter == password[min-1].toString() || letter == password[max-1].toString()) && password[min-1] != password[max-1]) puzzle2Counter++
}



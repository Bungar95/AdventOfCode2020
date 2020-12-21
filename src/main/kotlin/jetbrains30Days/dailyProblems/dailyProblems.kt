package jetbrains30Days.dailyProblems

import java.util.*

fun main(){
    println("I only did 2 as I found out they count for the challenge literally the last day. Choose 1:")
    println("1. I only had to make 2 methods that speed up or down a car by 5")
    println("2. Here is the challenge text:")
    println("Here is a program that reads an unbounded sequence of words from the input. It stops reading when the next word that appears in the input is stop. Print the word that occurs most frequently in the input. If some words appeared equally frequently, then print the first one. If stop is the first word then print null")
    println("You can try it by typing 'mostcommon', any other word will return to the 'main menu'.")

    while (true)
        when(readLine()?.toLowerCase()){
            "mostcommon" ->{
                mostCommon()
                return
            }
            else -> return
        }
}

class Car(val make: String, val year: Int) {

    var speed = 0

    fun accelerate() {
        speed += 5
    }

    fun decelerate() {
        if (speed >= 5) speed -= 5
        else speed = 0
    }

}

fun mostCommon(){

        val words = mutableMapOf<String,Int>()
        val scanner = Scanner(System.`in`)
        while(true){
            val word = scanner.nextLine()
            if (word == "stop") break
            else if (!words.containsKey(word)){
                words.put(word, 1)
            }else words.put(word, value = words.getValue(word)+1)
        }
        var maxBy = words.maxByOrNull { it.value }
        print("${maxBy?.key} -> ${maxBy?.value} times\n")
}
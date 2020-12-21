package jetbrains30Days.flashcards

import sun.rmi.runtime.Log
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

/*
    This project is 70% finished.
    Examples in the package to see how you could use the commands
 */

val scanner = Scanner(System.`in`)
var map = mutableMapOf<String, String>()
var logList = mutableListOf<String>()
var hardestCardList = mutableMapOf<String, Int>()

fun main() {

    while (true){
        println("Input the action (add, remove, import, export, ask, exit):")
        when (readLine()){
            "add" -> add()
            "remove" -> remove()
            "import" -> import()
            "export" -> export()
            "ask" -> ask()
            //"log" -> saveLog()
            "hardest card" -> showHardestCard()
            "reset stats" -> hardestCardList.clear()
            "exit" -> {
                print("Bye bye!")
                return
            }
        }
    }
}

fun showHardestCard() {
    var hardestCard = hardestCardList.maxByOrNull { it ->  it.value }
    print("The hardest card is ${hardestCard?.key}. You have ${hardestCard?.value} errors answering them.")
}

fun addToHardestCard(key: String){
    if(!hardestCardList.containsKey(key)) hardestCardList.put(key, 1)
    else {
        val newValue = hardestCardList.getValue(key)+1
        hardestCardList.put(key, newValue)
    }
}

fun saveLog() {

}

fun add() {

    println("The card:")
    var termInput = scanner.nextLine()
    if (map.containsKey(termInput)) println("The card \u0022$termInput\u0022 already exists.")
    else {
        println("The definition of the card:")
        var definitionInput = scanner.nextLine()
        if (map.containsValue(definitionInput)) println("The definition \u0022$definitionInput\u0022 already exists.")
        else {
            println("The pair (\u0022$termInput\u0022:\u0022$definitionInput\u0022) has been added.")
            map.put(termInput, definitionInput)
        }
    }
}

fun remove() {

    println("The card:")
    var userInput = readLine()
    if(map.containsKey(userInput)) {
        map.remove(userInput)
        println("The card has been removed.")
    }
    else println("Can't remove \u0022$userInput\u0022: there is no such card.")
}

fun import() {

    var cards = 0
    println("File name:")
    val filePathInput = readLine()
    try{
        val myFile = File("src/main/kotlin/jetbrains30Days/flashcards/$filePathInput")
        myFile.forEachLine {
            val array = it.split(':')
            if(map.containsKey(array[0])){
                map.replace(array[0],array[1])
            }else {
                map.put(array[0], array[1])
            }
            cards ++
        }

        println("$cards cards have been loaded.")
    }catch(e: Exception){
        println("File not found.")
    }
}

fun export() {

    var cards = 0
    println("File name:")
    val filePathInput = readLine()
    val myFile = File("src/main/kotlin/jetbrains30Days/flashcards/$filePathInput")
    myFile.writeText("")
    for (i in map) {
        var key = i.key
        var value = i.value
        val string = "$key:$value\n"
        myFile.appendText(string)
        cards++
    }

    println("$cards cards have been saved.")

}

fun ask() {

    println("How many times to ask?")
    val n = scanner.nextInt()
    scanner.nextLine() // eats the \n
    loop@ for (i in 1..n){
        for ((key,value) in map){
            println("Print the definition of \u0022$key\u0022:")
            var userInput = scanner.nextLine()
            if (userInput == value) {
                println("Correct answer.")
                continue@loop
            }
            else {
                for ((key2,value2) in map){
                    if(map.containsValue(userInput) && userInput == value2){
                        println("Wrong answer. The correct one is \u0022$value\u0022, you've just written the definition of \u0022$key2\u0022")
                        addToHardestCard(key)
                        continue@loop
                    }else {
                        if(!map.containsValue(userInput)) {
                            println("Wrong answer. The correct one is \u0022$value\u0022.")
                            addToHardestCard(key)
                            continue@loop
                        }
                    }
                }
            }
        }
    }
}
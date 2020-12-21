package jetbrains30Days.simpleChattyBot
import java.util.*

val scanner = Scanner(System.`in`) // Do not change this line

fun main() {
    greet("Aid", "2020") // change it as you need
    remindName()
    guessAge()
    count()
    test()
    end()
}

fun greet(assistantName: String, birthYear: String) {
    println("Hello! My name is " + assistantName + ".")
    println("I was created in " + birthYear + ".")
    println("Please, remind me your name.")
}

fun remindName() {
    val name = scanner.nextLine()
    println("What a great name you have, " + name + "!")
}

fun guessAge() {
    println("Let me guess your age.")
    println("Say me remainders of dividing your age by 3, 5 and 7.")
    val rem3 = scanner.nextInt()
    val rem5 = scanner.nextInt()
    val rem7 = scanner.nextInt()
    val age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105
    println("Your age is " + age + "; that's a good time to start programming!")
}

fun count() {
    println("Now I will prove to you that I can count to any number you want.")
    val num = scanner.nextInt()
    for (i in 0..num) {
        print(i)
        println("!")
    }
}

fun test() {
    println("Let's test your programming knowledge.")
    println("Why do we use methods?")
    val first = 1
    val second = 2
    val third = 3
    val fourth = 4
    println(""+first+". To repeat a statement multiple times.")
    println(""+second+". To decompose a program into several small subroutines.")
    println(""+third+". To determine the execution time of a program.")
    println(""+fourth+". To interrupt the execution of a program.")
    val question = false
    do {
        val answer:Int = scanner.nextInt()
        if(answer == 2){
            val question = true;
            break
        }else{
            println("Please, try again")
        }
    }while (question != true)
}

fun end() {
    println("Congratulations, have a nice day!") // Do not change this text
}

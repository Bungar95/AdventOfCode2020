package jetbrains30Days.coffeeMachine

var coffeMachine = CoffeeMachine()

fun main() {

    coffeMachine.currentWater = 400
    coffeMachine.currentMilk = 540
    coffeMachine.currentBeans = 120
    coffeMachine.currentDisposableCups = 9
    coffeMachine.currentMoney = 550

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readLine()) {
            "buy" -> buyCoffee(coffeMachine)
            "fill" -> fillMachine(coffeMachine)
            "take" -> takeMoney(coffeMachine)
            "remaining" -> currentState(coffeMachine)
            "exit" -> return
        }
    }
}
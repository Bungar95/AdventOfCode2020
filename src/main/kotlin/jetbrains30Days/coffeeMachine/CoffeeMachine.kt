package jetbrains30Days.coffeeMachine

class CoffeeMachine {
    var currentWater = 0
    var currentMilk = 0
    var currentBeans = 0
    var currentDisposableCups = 0
    var currentMoney = 0
}

enum class COFFEE (val coffeeID: Int, val coffeeName: String, val waterNeeded: Int, val milkNeeded: Int, val beansNeeded: Int, val DisposableCupsNeeded: Int, val moneyNeeded: Int ){
    ESPRESSO(1, "Espresso", 250, 0, 16,1, 4),
    LATTE(2, "Latte", 350, 75, 20, 1,7),
    CAPPUCCINO(3, "Cappuccino", 200, 100, 12, 1, 6)
}

fun currentState(coffeeMachine: CoffeeMachine){
    println("\nThe coffee machine has:")
    println("${coffeeMachine.currentWater} of water")
    println("${coffeeMachine.currentMilk} of milk")
    println("${coffeeMachine.currentBeans} of coffee beans")
    println("${coffeeMachine.currentDisposableCups} of disposable cups")
    println("$${coffeeMachine.currentMoney} of money\n")
}

fun buyCoffee(coffeeMachine: CoffeeMachine): CoffeeMachine{
    println("What do you want to buy? ${COFFEE.ESPRESSO.coffeeID} - espresso," +
            " ${COFFEE.LATTE.coffeeID} - latte," +
            " ${COFFEE.CAPPUCCINO.coffeeID} - cappuccino:")
    val userChoice = readLine()

    for (i in COFFEE.values()) {
        when (userChoice) {
            "${i.coffeeID}" -> {
                if(coffeeMachine.currentWater < i.waterNeeded){
                    println("Sorry, not enough water!")
                }else{
                    coffeMachine.currentWater -= i.waterNeeded
                    if(coffeeMachine.currentMilk < i.milkNeeded){
                        println("Sorry, not enough milk!")
                    }else{
                        coffeMachine.currentMilk -= i.milkNeeded
                        if(coffeeMachine.currentBeans < i.beansNeeded){
                            println("Sorry, not enough coffee beans!")
                        }else{
                            coffeMachine.currentBeans -= i.beansNeeded
                            if(coffeeMachine.currentDisposableCups < i.DisposableCupsNeeded){
                                println("Sorry, not enough water!")
                            }else{
                                coffeMachine.currentDisposableCups -= i.DisposableCupsNeeded
                                coffeMachine.currentMoney += i.moneyNeeded
                                println("I have enough resources, making you a coffee!\nbzzzzz \nDone! Enjoy!")
                                currentState(coffeMachine)
                            }
                        }
                    }
                }
            }
        }
    }

    return coffeeMachine
}

fun fillMachine(coffeeMachine: CoffeeMachine): CoffeeMachine{
    println("Write how many ml of water do you want to add: ")
    coffeeMachine.currentWater += (readLine() ?: "1").toString().toInt()
    println("Write how many ml of milk do you want to add: ")
    coffeeMachine.currentMilk += (readLine() ?: "1").toString().toInt()
    println("Write how many grams of coffee beans do you want to add: ")
    coffeeMachine.currentBeans += (readLine() ?: "1").toString().toInt()
    println("Write how many disposable cups of coffee do you want to add: ")
    coffeeMachine.currentDisposableCups += (readLine() ?: "1").toString().toInt()

    return coffeeMachine
}

fun takeMoney(coffeeMachine: CoffeeMachine): CoffeeMachine{
    println("\nI gave you $${coffeeMachine.currentMoney}\n")
    coffeeMachine.currentMoney = 0

    return coffeeMachine
}
package jetbrains30Days.parkingLot

import java.util.*
import kotlin.collections.ArrayList

/* Example of this:
> park KA-01-HH-9999 White
Sorry, a parking lot has not been created.
> create 3
Created a parking lot with 3 spots.
> status
Parking lot is empty.
> park KA-01-HH-9999 White
White car parked in spot 1.
> reg_by_color GREEN
No cars with color GREEN were found.
> park KA-01-HH-3672 Green
Green car parked in spot 2.
>spot_by_reg KA-01-HH-9999
1
> park Rs-P-N-21 Red
Red car parked in spot 3.
> leave 2
Spot 2 is free.
> status
1 KA-01-HH-9999 White
3 Rs-P-N-21 Red
> exit
*/

data class ParkingSpots (val id: Int, var isAvailable: Boolean, var parkedCarRegistration: String, var parkedCarColor: String)

var parkingLot = ArrayList<ParkingSpots>()
val scanner = Scanner(System.`in`)

fun main() {

    println("You can 'create [number], 'status', 'park [string, color]', leave [string]")
    println("reg_by_color [color], spot_by_color [color], spot_by_reg [string]")
    println("'exit' to go back to menu")

    while (true) {
        val userInput = scanner.nextLine()
        val wholeInput: List<String> = userInput.split(" ")


        when (wholeInput[0]) {
            "create" -> {
                if(parkingLot.isEmpty()) {
                    parkingLot = createParkingLot(wholeInput)
                }else{
                    parkingLot.clear()
                    parkingLot = createParkingLot(wholeInput)
                }
            }
            "status" -> {
                if(!parkingLot.isEmpty()) {
                    checkParkingLotStatus(parkingLot)
                }else println("Sorry, parking lot is not created.")
            }
            "park" -> {
                if(!parkingLot.isEmpty()) {
                    if (checkAvailability(parkingLot)) {
                        parkCar(parkingLot, wholeInput)
                    } else println("Sorry, parking lot is full.")
                }else println("Sorry, parking lot is not created.")
            }
            "leave" -> {
                if(!parkingLot.isEmpty()) {
                    leaveSpot(parkingLot, wholeInput)
                }else println("Sorry, parking lot is not created.")
            }
            "reg_by_color" -> if(!parkingLot.isEmpty()) {
                registrationByColor(parkingLot, wholeInput)
            }else println("Sorry, parking lot is not created.")
            "spot_by_color" -> if(!parkingLot.isEmpty()) {
                spotByColor(parkingLot, wholeInput)
            }else println("Sorry, parking lot is not created.")
            "spot_by_reg" -> if(!parkingLot.isEmpty()) {
                spotByRegistration(parkingLot, wholeInput)
            }else println("Sorry, parking lot is not created.")
            "exit" -> return
        }
    }
}

fun spotByRegistration(parkingLot: ArrayList<ParkingSpots>, wholeInput: List<String>) {

    var foundCar = false
    for (i in parkingLot) {
        if (i.parkedCarRegistration == wholeInput[1]) {
            println(i.id)
            foundCar = true
        }
    }

    if (foundCar == false) println("No cars with registration number ${wholeInput[1]} were found.")
}

fun spotByColor(parkingLot: ArrayList<ParkingSpots>, wholeInput: List<String>) {

    var array = arrayListOf<Int>()

    for(i in parkingLot){
        if (i.parkedCarColor.toLowerCase() == wholeInput[1].toLowerCase()){
            array.add(i.id)
        }
    }

    if (array.isEmpty()) println("No cars with color ${wholeInput[1]} were found.")
    else println(array.joinToString(", "))

}

fun registrationByColor(parkingLot: ArrayList<ParkingSpots>, wholeInput: List<String>) {

    var array = arrayListOf<String>()

    for(i in parkingLot){
        if (i.parkedCarColor.toLowerCase() == wholeInput[1].toLowerCase()){
            array.add(i.parkedCarRegistration)
        }
    }

    if (array.isEmpty()) println("No cars with color ${wholeInput[1]} were found.")
    else println(array.joinToString(", "))

}

fun checkParkingLotStatus(parkingLot: ArrayList<ParkingSpots>) {

    var parkedSpots = 0

    for(i in parkingLot){
        if (i.isAvailable == false) {
            println("${i.id} ${i.parkedCarRegistration} ${i.parkedCarColor}")
            parkedSpots++
        }
    }

    if (parkedSpots == 0) println("Parking lot is empty.")
}

fun parkCar(parkingLot: ArrayList<ParkingSpots>, input: List<String>): ArrayList<ParkingSpots> {
    val registration = input[1]
    val carColor = input[2]

    for(i in parkingLot){
        if (i.isAvailable == true){
            i.parkedCarRegistration = registration
            i.parkedCarColor = carColor
            i.isAvailable = false
            println("$carColor car parked on the spot ${i.id}.")
            break // when it fills up the first available spot, quit loop
        }
    }

    return parkingLot
}

fun leaveSpot(parkingLot: ArrayList<ParkingSpots>, input: List<String>): ArrayList<ParkingSpots> {
    val parkingspot = input[1].toInt()

    if(parkingLot[parkingspot-1].isAvailable == false ){
        parkingLot[parkingspot-1].parkedCarRegistration = ""
        parkingLot[parkingspot-1].parkedCarColor = ""
        parkingLot[parkingspot-1].isAvailable = true
        println("Spot $parkingspot is free.")
    }

    return parkingLot

}

fun createParkingLot(input: List<String>): ArrayList<ParkingSpots>{
    var parkingSpot: ParkingSpots
    var lotNumber = input[1].toInt()
    for (i in 1..lotNumber){
        val id:Int = i
        parkingSpot = ParkingSpots(id, true, "", "")
        parkingLot.add(parkingSpot)
    }

    println("Created a parking lot with $lotNumber spots.")
    return parkingLot
}

fun checkAvailability(parkingLot: ArrayList<ParkingSpots>): Boolean {
    var emptySpots = 0
    for (i in parkingLot){
        if (i.isAvailable == true){
            emptySpots++
        }

    }
    if (emptySpots != 0) return true
    else return false
}
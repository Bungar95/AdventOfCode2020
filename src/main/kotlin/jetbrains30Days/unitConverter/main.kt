package jetbrains30Days.unitConverter

import java.util.*
import kotlin.collections.ArrayList

val scanner = Scanner(System.`in`)

fun main() {

    while(true) {
        println("Enter what you want to convert (ex. '37 celsius to fahrenheit', '10 cm to m')...")
        println("'exit' to go back")
        val userInput = scanner.nextLine()
        if(userInput=="exit"){
            break
        }

        try {
            var unitArray: ArrayList<Any> = processUserInput(userInput)

            var assignedNumber = unitArray[0] as Double
            var assignedUnit = unitArray[1] as String
            var targetUnit = unitArray[2] as String
            var assignedUnitPlural = unitArray[3] as String
            var targetUnitPlural = unitArray[4] as String

            var processedArray: ArrayList<Any> = convertUnit(assignedNumber, assignedUnit, targetUnit)

            val finalAssignedUnit = processedArray[0] as String
            val finalTargetNumber = processedArray[1]
            val finalTargetUnit = processedArray[2] as String
            val assignedUnitMeasure = processedArray[3] as String
            val targetUnitMeasure = processedArray[4] as String

            if(doUnitsExist(assignedUnitPlural, targetUnitPlural)){
                if(errorCheckNegativeNumber(assignedNumber, assignedUnitMeasure)) {
                    if(errorCheckCompatibility(assignedUnitMeasure, assignedUnitPlural, targetUnitMeasure, targetUnitPlural)){
                        println("$assignedNumber $finalAssignedUnit is $finalTargetNumber $finalTargetUnit")
                    }
                }
            }
        } catch (Exception: Error){
            println("Parse error.")
        }

    }
}

fun processUserInput(userInput:String): ArrayList<Any> {

    val wholeInput = userInput.toLowerCase().split(" ","degree", "degrees")

    var assignedNumber = wholeInput[0].toDouble()
    var assignedUnit: String
    if(wholeInput[1] != "") {
        assignedUnit = wholeInput[1]
    } else {
        assignedUnit = wholeInput[3]
    }
    var targetUnit = wholeInput.last()

    var unitArray = arrayListOf<String>()
    unitArray.add(assignedUnit)
    unitArray.add(targetUnit)

    determineUnits(unitArray)

    assignedUnit = unitArray[2]
    val assignedUnitPlural = unitArray[3]
    targetUnit = unitArray[4]
    val targetUnitPlural = unitArray[5]

    var resultArray = arrayListOf<Any>()
    resultArray.add(assignedNumber)
    resultArray.add(assignedUnit)
    resultArray.add(targetUnit)
    resultArray.add(assignedUnitPlural)
    resultArray.add(targetUnitPlural)

    //returns units in their singular state
    return resultArray

}

fun determineUnits(unitArray: ArrayList<String>): ArrayList<String> {
    for (iterator in 0..1){
        when (unitArray[iterator].toLowerCase()) {
            "m", "meter", "meters" -> {
                unitArray += LENGTH.METER.unitSingularName
                unitArray += LENGTH.METER.unitPluralName
            }
            "km", "kilometer", "kilometers" -> {
                unitArray += LENGTH.KILOMETER.unitSingularName
                unitArray += LENGTH.KILOMETER.unitPluralName
            }
            "cm", "centimeter", "centimeters" -> {
                unitArray += LENGTH.CENTIMETER.unitSingularName
                unitArray += LENGTH.CENTIMETER.unitPluralName
            }
            "mm", "millimeter", "millimeters" -> {
                unitArray += LENGTH.MILLIMETER.unitSingularName
                unitArray += LENGTH.MILLIMETER.unitPluralName
            }
            "mi", "mile", "miles" -> {
                unitArray += LENGTH.MILE.unitSingularName
                unitArray += LENGTH.MILE.unitPluralName
            }
            "yd", "yard", "yards" -> {
                unitArray += LENGTH.YARD.unitSingularName
                unitArray += LENGTH.YARD.unitPluralName
            }
            "ft", "foot", "feet" -> {
                unitArray += LENGTH.FOOT.unitSingularName
                unitArray += LENGTH.FOOT.unitPluralName
            }
            "in", "inch", "inches" -> {
                unitArray += LENGTH.INCH.unitSingularName
                unitArray += LENGTH.INCH.unitPluralName
            }
            "g", "gram", "grams" -> {
                unitArray += WEIGHT.GRAM.unitSingularName
                unitArray += WEIGHT.GRAM.unitPluralName
            }
            "kg", "kilogram", "kilograms" -> {
                unitArray += WEIGHT.KILOGRAM.unitSingularName
                unitArray += WEIGHT.KILOGRAM.unitPluralName
            }
            "mg", "milligram", "milligrams" -> {
                unitArray += WEIGHT.MILLIGRAM.unitSingularName
                unitArray += WEIGHT.MILLIGRAM.unitPluralName
            }
            "lb", "pound", "pounds" -> {
                unitArray += WEIGHT.POUND.unitSingularName
                unitArray += WEIGHT.POUND.unitPluralName
            }
            "oz", "ounce", "ounces" -> {
                unitArray += WEIGHT.OUNCE.unitSingularName
                unitArray += WEIGHT.OUNCE.unitPluralName
            }
            "c", "dc", "celsius", "degree celsius", "degrees celsius" -> {
                unitArray += TEMPERATURE.CELSIUS.unitSingularName
                unitArray += TEMPERATURE.CELSIUS.unitPluralName
            }
            "f", "df", "fahrenheit", "degree fahrenheit", "degrees fahrenheit" -> {
                unitArray += TEMPERATURE.FAHRENHEIT.unitSingularName
                unitArray += TEMPERATURE.FAHRENHEIT.unitPluralName
            }
            "k", "kelvin", "kelvins" -> {
                unitArray += TEMPERATURE.KELVIN.unitSingularName
                unitArray += TEMPERATURE.KELVIN.unitPluralName
            }
            else -> {
                unitArray += IMPOSSIBLE.NOPE.unitSingularName
                unitArray += IMPOSSIBLE.NOPE.unitPluralName
            }
        }
    }

    return unitArray
}

fun convertUnit(assignedNumber: Double, assignedUnit: String, targetUnit: String): ArrayList<Any>{
    var targetNumber: Double = assignedNumber
    var firstUnit = assignedUnit
    var secondUnit = targetUnit
    var firstUnitMeasure = ""
    var secondUnitMeasure = ""


    for (i in LENGTH.values()){
        if (firstUnit == i.unitSingularName ){
            if(targetNumber > 1.0 || targetNumber < 1.0) firstUnit = i.unitPluralName
            targetNumber *= i.sizeInM // i found which unit it is and converted to meters
            firstUnitMeasure = "Length"
            for (j in LENGTH.values()){
                if (secondUnit == j.unitSingularName){
                    targetNumber /= j.sizeInM // j found which unit is the target and converted from meters to it
                    secondUnitMeasure = "Length"
                    if (targetNumber > 1.0 || targetNumber < 1.0) secondUnit = j.unitPluralName
                }
            }
        }
    }

    for (i in WEIGHT.values()){
        if (firstUnit == i.unitSingularName){
            if(targetNumber > 1.0 || targetNumber < 1.0) firstUnit = i.unitPluralName
            targetNumber *= i.sizeInG
            firstUnitMeasure = "Weight"
            for (j in WEIGHT.values()){
                if (secondUnit == j.unitSingularName){
                    targetNumber /= j.sizeInG
                    secondUnitMeasure = "Weight"
                    if (targetNumber > 1.0 || targetNumber < 1.0) secondUnit = j.unitPluralName
                }
            }
        }
    }

    for (i in TEMPERATURE.values()){
        if (firstUnit == i.unitSingularName){
            firstUnitMeasure = "Temperature"
            for (j in TEMPERATURE.values()) {
                if (secondUnit == j.unitSingularName){
                    secondUnitMeasure = "Temperature"
                    when(firstUnit){
                        "degree Celsius" -> {
                            if(targetNumber > 1.0 || targetNumber < 1.0) firstUnit = i.unitPluralName
                            when(secondUnit){
                                "degree Celsius" -> targetNumber = targetNumber
                                "degree Fahrenheit" -> targetNumber = targetNumber * 9/5 + 32
                                "Kelvin" -> targetNumber += 273.15
                            }
                        }
                        "degree Fahrenheit" -> {
                            if(targetNumber > 1.0 || targetNumber < 1.0) firstUnit = i.unitPluralName
                            when(secondUnit){
                                "degree Celsius" -> targetNumber = (targetNumber-32) * 5/9
                                "degree Fahrenheit" -> targetNumber = targetNumber
                                "Kelvin" -> targetNumber = (targetNumber + 459.67) * 5/9
                            }
                        }
                        "Kelvin" -> {
                            if(targetNumber > 1.0 || targetNumber < 1.0) firstUnit = i.unitPluralName
                            when(secondUnit){
                                "degree Celsius" -> targetNumber -= 273.15
                                "degree Fahrenheit" -> targetNumber = targetNumber * 9/5 - 459.67
                                "Kelvin" -> targetNumber = targetNumber
                            }
                        }
                    }
                    if(targetNumber > 1.0 || targetNumber < 1.0) secondUnit = j.unitPluralName
                }
            }
        }
    }

    var finalArray = arrayListOf<Any>()
    finalArray.add(firstUnit)
    finalArray.add(targetNumber)
    finalArray.add(secondUnit)
    finalArray.add(firstUnitMeasure)
    finalArray.add(secondUnitMeasure)

    return finalArray
}
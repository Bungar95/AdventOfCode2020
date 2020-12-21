package jetbrains30Days.unitConverter

fun errorCheckNegativeNumber(number: Double, unitMeasure: String ): Boolean{

    val assignedNumber = number
    val assignedUnitMeasure = unitMeasure


    if (assignedNumber<0 && assignedUnitMeasure != "Temperature"){
        println("$assignedUnitMeasure shouldn't be negative.")
        return false
    }

    return true
}

fun doUnitsExist(unitPlural1: String, unitPlural2: String): Boolean{
    val assignedUnitPlural = unitPlural1
    val targetUnitPlural = unitPlural2

    if(assignedUnitPlural == "???" || targetUnitPlural == "???"){
        println("Conversion from $assignedUnitPlural to $targetUnitPlural is impossible")
        return false
    }

    return true
}

fun errorCheckCompatibility(unitMeasure1 : String, unitPlural1: String, unitMeasure2: String, unitPlural2: String): Boolean{

    val assignedUnitMeasure = unitMeasure1
    val targetUnitMeasure = unitMeasure2
    val assignedUnitPlural = unitPlural1
    val targetUnitPlural = unitPlural2

    if (assignedUnitMeasure != targetUnitMeasure){
        println("Conversion from $assignedUnitPlural to $targetUnitPlural is impossible")
        return false
    }

    return true
}

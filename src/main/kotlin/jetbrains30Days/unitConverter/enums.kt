package jetbrains30Days.unitConverter

enum class LENGTH(val unitSingularName: String, val unitPluralName: String, val sizeInM: Double ){
    METER ("meter", "meters", 1.0),
    KILOMETER ("kilometer", "kilometers", 1000.0),
    CENTIMETER("centimeter", "centimeters", 0.01),
    MILLIMETER("millimeter", "millimeters", 0.001),
    MILE("mile", "miles", 1609.35),
    YARD("yard", "yards", 0.9144),
    FOOT ("foot", "feet", 0.3048),
    INCH ("inch", "inches", 0.0254)
}

enum class WEIGHT (val unitSingularName: String, val unitPluralName: String, val sizeInG: Double){
    GRAM("gram", "grams", 1.0),
    KILOGRAM("kilogram", "kilograms", 1000.0),
    MILLIGRAM("milligram", "milligrams", 0.001),
    POUND("pound", "pounds", 453.592),
    OUNCE("ounce", "ounces", 28.3495)
}

enum class TEMPERATURE (val unitSingularName: String, val unitPluralName: String){
    CELSIUS("degree Celsius", "degrees Celsius"),
    FAHRENHEIT("degree Fahrenheit", "degrees Fahrenheit"),
    KELVIN("Kelvin", "Kelvins")
}

enum class IMPOSSIBLE(val unitSingularName: String, val unitPluralName: String){
    NOPE ("???", "???")
}
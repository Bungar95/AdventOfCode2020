package DailyChallenges

import java.io.File

fun loadTxtAsInt(filePath : String): List<Int> {

    var array = emptyList<Int>()

    try{
        File(filePath).forEachLine {
            array += it.toInt()
        }
    }catch(e: Exception){
        println("File not found.")
    }
    return array
}

fun loadTxtAsString(filePath : String): List<String> {

    var array = emptyList<String>()

    try{
        File(filePath).forEachLine {
            array += it
        }
    }catch(e: Exception){
        println("File not found.")
    }
    return array
}

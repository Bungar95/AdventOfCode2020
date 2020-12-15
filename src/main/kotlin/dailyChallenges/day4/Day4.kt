package dailyChallenges.day4

import dailyChallenges.loadTxtAsString
import java.util.regex.Pattern

class Day4() {

    val hexadecimal: Pattern = Pattern.compile("#([0-9a-f]{6})$");
    val onlyDigits: Pattern = Pattern.compile("[0-9]+")
    var passwordMap = mutableMapOf<String, Any?>()
    var validNoRulesPasswordCounter: Int = 0
    var validPasswordCounter: Int = 0

/*
Q1: Count the number of valid passports - those that have all required fields.
Treat cid as optional. In your batch file, how many passports are valid?

Q2: You can continue to ignore the cid field, but each other field has strict rules
about what values are valid for automatic validation:

byr (Birth Year) - four digits; at least 1920 and at most 2002.
iyr (Issue Year) - four digits; at least 2010 and at most 2020.
eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
hgt (Height) - a number followed by either cm or in:
If cm, the number must be at least 150 and at most 193.
If in, the number must be at least 59 and at most 76.
hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
pid (Passport ID) - a nine-digit number, including leading zeroes.
cid (Country ID) - ignored, missing or not.
*/

    fun day4() {
        val array = loadTxtAsString("src/main/kotlin/dailyChallenges/day4/day4.txt")
        passwordMap.clear()
        for (row in array) {
            if (row.isNotBlank()) {
                var rowPairs = row.split(" ")
                var pairNum = row.split(" ").count()
                for (i in 0 until pairNum) {
                    var pair = rowPairs[i].split(":")
                    passwordMap[pair[0]] = pair[1]
                }
            } else {
                //println(passwordMap) // contains all pairs before blank line
                processPassword(passwordMap)
                passwordMap.clear()
            }
        }
        println("Q1: Without rules, $validNoRulesPasswordCounter valid passwords.")
        println("Q2: With set rules, $validPasswordCounter valid passwords.")
    }

    fun processPassword(passwordMap: MutableMap<String, Any?>) {

        if (
            passwordMap.containsKey("iyr") &&
            passwordMap.containsKey("pid") &&
            passwordMap.containsKey("eyr") &&
            passwordMap.containsKey("hcl") &&
            passwordMap.containsKey("ecl") &&
            passwordMap.containsKey("byr") &&
            passwordMap.containsKey("hgt")
        ) {
            validNoRulesPasswordCounter++ //Q1
            iyrProcess(passwordMap["iyr"].toString())
        }

    }

    fun iyrProcess(issue: String) {
        if (issue.length == 4 && issue.toInt() >= 2010 && issue.toInt() <= 2020)
            pidProcess(passwordMap["pid"].toString())
    }

    fun pidProcess(passport: String) {
        if (passport.length == 9 && onlyDigits.matcher(passport).matches())
            eyrProcess(passwordMap["eyr"].toString())
    }

    fun eyrProcess(expiration: String) {
        if (expiration.length == 4 && expiration.toInt() >= 2020 && expiration.toInt() <= 2030)
            hclProcess(passwordMap["hcl"].toString())
    }

    fun hclProcess(hair: String) {
        if (hair.length == 7 && hair[0].toString() == "#" && hexadecimal.matcher(hair).matches())
            eclProcess(passwordMap["ecl"].toString())
    }

    fun eclProcess(eyes: String) {
        when (eyes) {
            "amb", "blu", "brn", "gry", "grn", "hzl", "oth" -> byrProcess(passwordMap["byr"].toString())
        }
    }

    fun byrProcess(birthYear: String) {
        if (birthYear.length == 4 && birthYear.toInt() >= 1920 && birthYear.toInt() <= 2002)
            hgtProcess(passwordMap["hgt"].toString())
    }

    fun hgtProcess(height: String) {
        when (true) {
            height.contains("cm") -> {
                if (height.contains("cm") &&
                    height.split("cm")[0].toInt() >= 150 &&
                    height.split("cm")[0].toInt() <= 193
                )
                    validPasswordCounter++
            }
            height.contains("in") -> {
                if (height.contains("in") &&
                    height.split("in")[0].toInt() >= 59 &&
                    height.split("in")[0].toInt() <= 76
                )
                    validPasswordCounter++
            }
        }
    }
}
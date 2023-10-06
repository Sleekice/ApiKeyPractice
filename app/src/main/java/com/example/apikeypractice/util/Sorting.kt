package com.example.apikeypractice.util

class Sorting {
//fun processArray(sizeInput: String, arrayInput: String, replaceInput: String): String {
//    val size = sizeInput.toInt()
//    val replaceNumber = replaceInput.toInt()
//
//    val arrayItems = arrayInput.split(" ").map { it.toInt() }.toMutableList()
//

//    // Replace the specified number with 1
//    arrayItems.replaceAll { if (it == replaceNumber) 1 else it }
//
//    return arrayItems.joinToString("")
//}

    //Breaking Down Functions
fun main(){
        println("This is :" + processArray("6","2 3 6 2 3 2", "3"))
        println("This is :" + processArray("6","2 3 6 2 3 2", "1"))
        println("This is :" + processArray("6","2 1 6 5 3 2", "2"))
        println("This is :" + processArray("6","2 1 6 5 1 5", "5"))
}

        fun convertInputToInt(sizeInput: String, arrayInput: String, replaceInput: String): Triple<Int, List<Int>, Int> {
            val size = sizeInput.toInt()
            val replaceNumber = replaceInput.toInt()
            val arrayItems = arrayInput.split(" ").map { it.toInt() }
            return Triple(size, arrayItems, replaceNumber)
        }

        fun replaceNumberWithOne(arrayItems: MutableList<Int>, replaceNumber: Int) {
            arrayItems.replaceAll { if (it == replaceNumber) 1 else it }
        }

        fun concatenateArrayToString(arrayItems: List<Int>): String {
            return arrayItems.joinToString("")
        }

        fun processArray(sizeInput: String, arrayInput: String, replaceInput: String): String {
            val (size, arrayItems, replaceNumber) = convertInputToInt(sizeInput, arrayInput, replaceInput)

            replaceNumberWithOne(arrayItems.toMutableList(), replaceNumber)

            return concatenateArrayToString(arrayItems)
        }
    }


package com.example.prac01.Kotiln

fun main(array: Array<String>) {

    first()
    println(second(85))
    println(third(84))
    gugudan()

}

    fun first() {
        var list1 = mutableListOf<Int>()
        // var list1 = MutableList(9,{0})
        var list2 = mutableListOf<String>()
        // var list2 = MutableList(9, {True})

        for (i in 1..9) {
            list1.add(i - 1, i)
        }

        for (i in 1..9) {
            if (list1[i - 1] % 2 == 0) {
                list2.add("True")
            } else {
                list2.add("False")
            }
        }

        /*list1.forEachIndexed { index, value ->
            if (value %2 ==0){
                list2[index] = true
            }else{
                list2[index] = false
            }
        }
        */
        println(list1)
        println(list2)
    }

    fun second(socre: Int):String {
//        var result: String = "F"
        when (socre) {
            in 91..100 -> return "A"
            in 81..90 -> return "B"
            in 71..80 -> return "C"
            in 61..70 -> return "D"
            else -> return "F"
        }
    }

    fun third(number: Int):Int {
        var a: Int = number / 10
        var b: Int = number % 10
        return a+b
    }

    fun gugudan() {
        for (i in 1..9) {
            for (j in 1..9) {
                println("$i * $j = ${i * j}")
            }
            println()
        }
    }


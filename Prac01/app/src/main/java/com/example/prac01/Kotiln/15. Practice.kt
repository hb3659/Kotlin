package com.example.prac01.Kotiln

fun main(array: Array<String>){

    val a = mutableListOf<Int>(1,2,3)
    a.add(4)
    println(a)
    a.add(0,100)
    println(a)

    a.set(0,200)
    println(a)

    a.removeAt(1)
    println(a)
    println()


    val b = mutableSetOf<Int>(1,2,3,4,5,5,5,5)
    b.add(2)
    println(b)
    b.remove(2)
    println(b)
    b.remove(100)
    println(b)

    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two", 2)
    println(c)
    c.replace("two",3)
    println(c)
    println(c.values)
    c.clear()
    println(c)

    // 리스트의 크기를 정할 때
    var list = MutableList(9, {0})
    // ==> 모두 0이 들어간 9 크기의 리스트

    val list2 = List(9, {1})
    // ==> 모두 1이 들어간 9 크기의 리스트
}
package com.example.prac01.Kotiln

/*class Calculate{
    var fNumber:Int = 0
    var sNumber:Int = 0

    constructor(){
    }

    fun plus(Num1:Int, Num2:Int):Int{
        this.fNumber = Num1
        this.sNumber = Num2
        return Num1+Num2
    }

    fun min(Num1:Int, Num2:Int):Int{
        this.fNumber = Num1
        this.sNumber = Num2
        return Num1-Num2
    }

    fun mul(Num1:Int, Num2:Int):Int{
        this.fNumber = Num1
        this.sNumber = Num2
        return Num1*Num2
    }

    fun div(Num1:Int, Num2:Int):Int{
        this.fNumber = Num1
        this.sNumber = Num2
        return Num1/Num2
    }
}


fun main(array: Array<String>){
    var cal:Calculate = Calculate()
    println(cal.min(30,5))

    var bank:Bank = Bank("AAA", "870424")
    bank.Account()
    bank.Check()
    bank.out("5,000")
    bank.come("1,000,000")

    var tv:Television = Television()
    tv.OnOff("On")
    tv.OnOff("Off")
    tv.change("S사")
}*/

fun main(array: Array<String>) {
    var cal1: Calculater1 = Calculater1()
    println(cal1.plus(5, 6))

    var cal2: Calculater2 = Calculater2()
    println(cal2.minus(10, 2, 3))

    var cal3: Calculater3 = Calculater3(3)
    println(cal3.plus(5).minus(2))
    // 기능을 이어쓸 수 있다
    println()

    var account: Account = Account("AAA", "940627", 1000)
    println(account.Check())
    println(account.save(1000))
    println(account.Withdraw(2000))
    println(account.Check())
    println()

    var account2: Account2 = Account2("BBB", "950406")
    println(account2.Check())
    println(account2.save(1000))
    println(account2.Withdraw(2000))
    println(account2.Check())
    println()

    var account3: Account2 = Account2("CCC", "970107", 5000)
    println(account3.Check())
}

class Calculater1() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤어 들어온 수를 뺀다
        return a - b
    }

    fun multi(a: Int, b: Int): Int {
        return a * b
    }

    fun div(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 나눈다
        return a / b
    }
}

class Calculater2() {
    fun plus(vararg Numbers: Int): Int {
        var result: Int = 0
        Numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg Numbers: Int): Int {
        var result: Int = Numbers[0]
        for (i in 1 until Numbers.size) {
            result -= Numbers[i]
        }
        return result
    }

    fun multi(vararg Numbers: Int): Int {
        var result: Int = 1
        for (i in 0 until Numbers.size) {
            if (Numbers[i] != 0) {
                result *= Numbers[i]
            }
        }
        return result
    }

    fun div(vararg Numbers: Int): Int {
        var result: Int = Numbers[0]
        Numbers.forEachIndexed { index, value ->
            if (index != 0) {
                // 0번째의 값을 result에 넣기 때문에
                // 0번째의 값으로 result를 나누게 된다
                // 따라서 1번째 값으로 나눌 수 있도록 중첩 if 문을 사용한다
                if (value != 0) {
                    result = result / value
                }
            }
        }
        return result
    }
}

class Calculater3(var inintialValue: Int) {

    fun plus(number: Int): Calculater3 {
        var result = this.inintialValue + number
        return Calculater3(result)
    }

    fun minus(number: Int): Calculater3 {
        var result = this.inintialValue - number
        return Calculater3(result)
    }

    fun multi(number: Int): Calculater3 {
        var result = this.inintialValue * number
        return Calculater3(result)
    }

    fun div(number: Int): Calculater3 {
        var result = this.inintialValue / number
        return Calculater3(result)
    }

}


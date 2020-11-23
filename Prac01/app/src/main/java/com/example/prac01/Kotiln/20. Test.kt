package com.example.prac01.Kotiln

/*class Bank(var Name:String, var Birth:String){
    fun Account(){
        println("$Name 님의 계좌가 만들어졌습니다.")
    }

    fun Check(){
        var account:String = "5,000,000"
        println("$Name 님의 계좌의 잔액은 $account 원입니다.")
    }

    fun out(exMoney:String){
        var a:String = exMoney
        println("계좌에서 $exMoney 원을 출금했습니다.")
    }

    fun come(inMoney:String){
        var a:String = inMoney
        println("계좌에서 $inMoney 원을 예금했습니다.")
    }
}*/

class Account {
    var Name: String
    var Birth: String
    var Money: Int

    constructor(Name: String, Birth: String, Money: Int) {
        this.Name = Name
        this.Birth = Birth
        if (Money >= 0) {
            this.Money = Money
        } else {
            this.Money = 0
        }
    }

    fun Check(): Int {
        return Money
    }

    fun Withdraw(amount: Int): Boolean {
        if (Money >= amount) {
            Money = Money - amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        Money = Money + amount
    }
}

class Account2(val Name: String, var Birth: String, var Money: Int = 1000) {
    fun Check(): Int {
        return Money
    }

    fun Withdraw(amount: Int): Boolean {
        if (Money >= amount) {
            Money = Money - amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        Money = Money + amount
    }
}

class Account3(initialMoney: Int) {

    var Money: Int = if (initialMoney >= 0) initialMoney else 0

    fun Check(): Int {
        return Money
    }
}

fun main(array: Array<String>){
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
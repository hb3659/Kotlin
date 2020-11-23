package com.example.prac01.Kotiln

/*class Television(){
    var Channel:String = ""

    fun OnOff(power:String){
        if(power=="On"){
            println("TV를 켰습니다")
        }else if(power=="Off"){
            println("TV를 껐습니다")
        }else{
            println("On/Off 중 하나를 입력하세요")
        }
    }

    fun change(channel:String){
        if(channel == "M사"){
            println("채널이 M사로 변경되었습니다.")
        }else if(channel=="K사"){
            println("채널이 K사로 변경되었습니다.")
        }else if(channel=="S사"){
            println("채널이 S사로 변경되었습니다.")
        }else{
            println("나오지 않는 채널입니다.")
        }
    }
}*/

class TV(val channels: List<String>) {
    // True -> On, False -> Off
    var OnorOff: Boolean = false
    var currentChannelNumber: Int = 0
        set(value) {
            field = value
            // currentChannelNumber = value 는 무한루프!!!
            // set 함수 ==> currentChannelNumber 에 어떤 값을 할당할 때 호출된다
            // 따라서 current...Number 에 value 할당한다는 뜻이므로
            // 무한 루프에 빠지게 된다
            // 이를 해결하기 위한 방법이 field
            if (field >2){
                field = 0
            }
            if (field < 0){
                field = 2
            }
        }
    // get ==> 값이 호출될 때 사용되는 함수
    get(){
        println(field)
        return field
    }

    fun switch() {
        OnorOff = !OnorOff
    }

    fun channelUp() {
        currentChannelNumber = currentChannelNumber + 1
        /*
        channels.forEachIndexed { index, item ->
            if(currentChannelNumber == index){
                currentChannelNumber = currentChannelNumber+1
                return
            }
        }
        */
    }

    fun channelDown() {
        currentChannelNumber = currentChannelNumber - 1
        /*
        channels.forEachIndexed { index, item ->
            if(currentChannelNumber == index){
                currentChannelNumber = currentChannelNumber-1
                return
            }
        }
        */
    }

    fun checkCurrentChennel(): String {
        return channels[currentChannelNumber]
    }
}

fun main(array: Array<String>) {
    val tv: TV = TV(listOf<String>("K", "M", "S"))

    tv.channelUp()
    println(tv.checkCurrentChennel())
    tv.channelDown()
    tv.channelDown()
    println(tv.checkCurrentChennel())
    println(tv.currentChannelNumber)

}
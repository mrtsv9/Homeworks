package homework2

object Singleton {
    fun createAutomobiles(){
        var firstAuto = Auto("BMW", "white", 200, "number1")
        firstAuto.toString()
        var secondAuto = Auto("Scoda", "black", 400)
        secondAuto.toString()
        var thirdAuto = Auto("Mercedes", "yellow", 300, "number2")
        thirdAuto.toString()
        var fourthAuto = Auto("Audi", "red", 214)
        fourthAuto.toString()
        var fifthAuto = Auto("Reno", "white", 432, "number3")
        fifthAuto.toString()
        var sixAuto = Auto("Range Rover", "green", 123, "number4")
        sixAuto.toString()
    }


}
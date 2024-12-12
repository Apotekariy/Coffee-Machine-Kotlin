package machine

var coffeeMachine = StateOfMachine()

fun main() {

    coffeeMachine.water = 400
    coffeeMachine.milk = 540
    coffeeMachine.beans = 120
    coffeeMachine.disposableCups = 9
    coffeeMachine.money = 550

    action()
}

fun action() {
    do {
        println("Write action (buy, fill, take, remaining, exit):")
        val input = readln()
        when (input) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
        }
        println()
    } while (input != "exit")
}

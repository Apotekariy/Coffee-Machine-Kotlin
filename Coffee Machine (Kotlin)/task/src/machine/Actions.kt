package machine

//Support functions
fun remaining() {
        println("""
        The coffee machine has:
        ${coffeeMachine.water} ml of water
        ${coffeeMachine.milk} ml of milk
        ${coffeeMachine.beans} g of coffee beans
        ${coffeeMachine.disposableCups} disposable cups
        ${'$'}${coffeeMachine.money} of money
    """.trimIndent())
}


fun makeCoffee(nameOfCoffee: CoffeeTypes){
        when {
                nameOfCoffee.water > coffeeMachine.water -> println("Sorry, not enough water!")
                nameOfCoffee.milk > coffeeMachine.water -> println("Sorry, not enough milk!")
                nameOfCoffee.beans > coffeeMachine.beans -> println("Sorry, not enough beans!")
                coffeeMachine.disposableCups == 0 -> println("Sorry, not enough disposable cups!")

                //Sufficient amount of ingredients

                else -> {
                        coffeeMachine.water -= nameOfCoffee.water
                        coffeeMachine.milk -= nameOfCoffee.milk
                        coffeeMachine.beans -= nameOfCoffee.beans
                        coffeeMachine.money += nameOfCoffee.money
                        coffeeMachine.disposableCups--
                        println("I have enough resources, making you a coffee!")
                }
        }
}

//Main functions
fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val input = readln()
        when (input) {
                "1" -> makeCoffee(CoffeeTypes.ESPRESSO)
                "2" -> makeCoffee(CoffeeTypes.LATTE)
                "3" -> makeCoffee(CoffeeTypes.CAPPUCCINO)
                "back" -> return
        }
}

fun fill() {
        println("Write how many ml of water you want to add:")
        val plusWater = readln().toInt()

        println("Write how many ml of milk you want to add:")
        val plusMilk = readln().toInt()

        println("Write how many grams of coffee beans you want to add:")
        val plusBeans = readln().toInt()

        println("Write how many disposable cups you want to add:")
        val plusDisposable = readln().toInt()

        coffeeMachine.water += plusWater
        coffeeMachine.milk  += plusMilk
        coffeeMachine.beans += plusBeans
        coffeeMachine.disposableCups += plusDisposable
        return
    }

fun take() {
        println("I gave you \$${coffeeMachine.money}")
        coffeeMachine.money = 0
}
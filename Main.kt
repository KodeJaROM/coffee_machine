package machine

fun main() {

//    initial amounts of product available
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    fun printSupplies(water: Int, milk: Int, beans: Int, cups: Int, money: Int) {
        println(
            """
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $beans g of coffee beans
        $cups disposable cups
        $$money of money
        
    """.trimIndent()
        )
    }

    printSupplies(water, milk, beans, cups, money)
    println("Write action (buy, fill, take):")
    val input = readln()

    when (input) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            val cType = readln().toInt()
            when (cType) {
                1 -> {
                    water -= 250
                    beans -= 16
                    money += 4
                }
                2 -> {
                    water -= 350
                    milk -= 75
                    beans -= 20
                    money += 7
                }
                3 -> {
                    water -= 200
                    milk -= 100
                    beans -= 12
                    money += 6
                }
            }
            cups -= 1
            printSupplies(water, milk, beans, cups, money)
        }
        "fill" -> {
            println("Write how many ml of water you want to add:")
            water += readln().toInt()
            println("Write how many ml of milk you want to add:")
            milk += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            beans += readln().toInt()
            println("Write how many disposable cups you want to add:")
            cups += readln().toInt()

            printSupplies(water, milk, beans, cups, money)
        }
        "take" -> {
            println("I gave you $$money")
            money = 0
            printSupplies(water, milk, beans, cups, money)
        }
    }
}



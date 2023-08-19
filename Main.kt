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

    fun fillCoffeeMachine() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    fun takeMoney() {
        println("I gave you $$money")
        money = 0
    }

    data class CoffeeRecipe(val name: String, val water: Int, val milk: Int, val beans: Int, val cost: Int)

    val coffeeRecipes = listOf(
        CoffeeRecipe("Espresso", 250, 0, 16, 4),
        CoffeeRecipe("Latte", 350, 75, 20, 7),
        CoffeeRecipe("Cappuccino", 200, 100, 12, 6)
    )

    fun makeCoffee(recipe: CoffeeRecipe) {
        val missingIngredient = when {
            water < recipe.water -> "water"
            milk < recipe.milk -> "milk"
            beans < recipe.beans -> "coffee beans"
            else -> null
        }

        if (missingIngredient == null) {
            water -= recipe.water
            milk -= recipe.milk
            beans -= recipe.beans
            money += recipe.cost
            cups--
            println("I have enough ingredients, making you a ${recipe.name}!")
        } else {
            println("Sorry, not enough $missingIngredient!")
        }
    }

    fun buyCoffee() {
        println("What do you want to buy?")
        for ((index, recipe) in coffeeRecipes.withIndex()) {
            println("${index + 1} - ${recipe.name} $${recipe.cost}")
        }
        val choice = readln()
        if (choice == "back") {
            return
        } else {
            val choiceInt = choice.toInt()
            if (choiceInt in 1..coffeeRecipes.size) {
                makeCoffee(coffeeRecipes[choiceInt - 1])
            } else {
                println("Invalid choice")
            }
        }
    }


    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val input = readln()

        when (input) {
            "exit" -> break
            "buy" -> buyCoffee()
            "fill" -> fillCoffeeMachine()
            "take" -> takeMoney()
            "remaining" -> printSupplies(water, milk, beans, cups, money)
        }
    }
}




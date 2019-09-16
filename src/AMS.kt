import java.util.*

fun main(args: Array<String>){
    //println("Good ${if (args[0].toInt()<12) "Morning" else "Night" }, Kotlin")
    feedTheFish()
    println(canAddFish(10.0, listOf(3,3,3))) //---> false
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false)) //---> tru
    println(canAddFish(9.0, listOf(1,1,3), 3)) //---> false
    println(canAddFish(10.0, listOf(), 7, true)) //---> true
    //dayOfWeek()
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true):Boolean{
    return((tankSize * if (hasDecorations) 0.8 else 1.0) - currentFish.sum() - fishSize >= 0)


}


fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day)){
        println("Change the water today")
    }
    swim(50,"slow") // swim(speed = "slow")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    //val isTooHot =
    //val isDirty = dirty > 30
    //val isSunday = day == "Sunday"
    return when {
        isTooHot(temperature)-> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun getDirtySensorReading() = 20

fun isTooHot(temperature: Int): Boolean = temperature > 30
fun isDirty(dirty: Int): Boolean = dirty> 30
fun isSunday(day: String): Boolean = day =="Sunday"

fun swim (time: Int, speed: String = "fast"){
    println("Swimming speed $speed")
}

fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday","Wednesday",
        "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String) : String{
    var food = "fasting"
    return when(day){
        "Sunday" -> "plankton"
        "Monday" -> "flakes"
        "Tuesday" -> "redworms"
        "Wednesday" -> "granules"
        "Thursday" -> "mosquitoes"
        "Friday" ->  "lettuce"
        "Saturday" -> "plankton"
        else -> "fasting"
    }

}



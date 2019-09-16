import java.util.*

fun main(args: Array<String>){
    //println("Good ${if (args[0].toInt()<12) "Morning" else "Night" }, Kotlin")
    //dayOfWeek()
    var fortune: String = ""
    var count: Int = 1
    while(!fortune.contains("Take it easy") && count <=10) {
        fortune = getFortuneCookie(getBirthday())
        println("\nYour fortune is: $fortune")
        count+=1
        println("the count is $count")
    }
    //println(whatShouldIDoToday())
}

fun whatShouldIDoToday(mood: String = readLine()!!, weather: String = "sunny",
                       temperature: Int = 24): String {

return when {
    isHappySunny(mood, weather)-> "go for a walk"
    isSadrainyCold(mood, weather, temperature) -> "stay in bed"
    isHot(temperature) -> "go swimming"
    else -> "Stay home and read."
}
}

fun isSadrainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" &&
        weather == "rainy" &&  temperature == 0
fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isHot(temperature: Int) = temperature > 35

fun getBirthday() : Int {
    print("Enter your birthday:")
    var birthday = readLine()?.toIntOrNull() ?: 1
    return birthday
}

fun getFortuneCookie(birthday: Int) : String{
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    return when(birthday){
        28 or 31 -> fortunes[0]
        in 1..7 -> fortunes[1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
    //return fortunes[birthday.rem(fortunes.size)]
}

fun dayOfWeek(){
    println("What day of the week is today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when(day){
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        5 -> println("Thursday")
        6 -> println("Friday")
        7 -> println("Saturday")
        else -> "Time has stopped"
    }
}


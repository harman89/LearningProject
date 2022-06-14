import java.util.*

//1
fun start(): String = "OK"
//2
fun toJSON(collection: Collection<Int>): String {
    return collection.joinToString(prefix = "[", separator = ":", postfix = "]")
}
//3
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if(toUpperCase) name.uppercase(Locale.getDefault()) else name) + number
}
//4
fun iscontainsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }
//5
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPatternOld() = """\d{2}\.\d{2}\.\d{4}"""
fun getPattern():String = """\d{2} $month \d{4}"""
//6
class Person(val name:String, val age: Int)
//7
fun sendMessageToClient(
    client: Client?,
    message: String?,
    mailer: Mailer
) {
    if (client == null || message == null) return
    val personalInfo = client.personalInfo ?: return
    val email = personalInfo.email ?: return
    mailer.sendMessage(email, message)
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

//8
fun Int.r(): RationalNumber = RationalNumber(this,1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first,second)

data class RationalNumber(val numerator: Int, val denominator: Int)

//9
fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2,5,2,1,6,8,956,345,123,5634,5,0,12,-12,-2425,-244532)
    Collections.sort(arrayList, object: java.util.Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o2-o1
        }
    })
    return arrayList
}

//10
fun getListLambda(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2,5,2,1,6,8,956,345,123,5634,5,0,12,-12,-2425,-244532)
    Collections.sort(arrayList, { x, y -> y-x })
    return arrayList
}


fun main() {
    println("#1")
    println(start())
    println("#2")
    println(toJSON(listOf(1,2,3,4,5)))
    println("#3")
    println(foo(name = "foo", toUpperCase = true))
    println("#4")
    println(iscontainsEven(listOf(2,3,5)))
    println("#5")
    println(Regex(pattern = getPatternOld()).find(input = "23.05.22, 23.05.2022")?.value)
    println(Regex(pattern = getPattern()).find(input = "23.05.22, 23.05.2022, 23 MAY 2022, 23 MAY 22")?.value)
    println("#6")
    val person = Person("John",32)
    println(person.name +" "+ person.age)
    println("#7")
    println()
    println("#8")
    println(5.r())
    val pair = Pair(1,2)
    println(pair.r())
    println("#9")
    println(getList())
    println("#10")
    println(getListLambda())
}
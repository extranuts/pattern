package tasks.kotlinlessons

class KotRunner {
    val scan = java.util.Scanner(System.`in`)
    fun main(args: Array<String>){
        val a = scan.nextInt()
        val b = scan.nextInt()
        val a1 = a/100
        var a2 = a%10
        var b1 = b/100
        var b2 = b%10
        println(a1+a2+b1+b2)



    }
}
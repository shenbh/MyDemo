package ab.com.mykotlindemo

/**
 * Created by shenbinghong on 2018/1/20.
 */

fun main(args: Array<String>) {
    Greenter(args[0]).greent()

    Blueter().bluet()


    //lambda（匿名函数）
    //lambda表达式使用实例
    val sumLambda:(Int, Int) -> Int = {x, y -> x+y}
    print(sumLambda(1,2))

    //Null检查机制
    //类型后加？表示可为空
    var age: String? = "23"
    //抛出空指针异常
    var ages = age!!.toInt()
    //不做处理，直接返回null
    var ages1 = age?.toInt()
    //age为空返回 -1
    var ages2 = age?.toInt() ?: -1
}

//构造方法带参数
class Greenter(val name:String){
    fun greent(){
        print("hello I'm Greenter")
    }
}

//构造方法无参
class Blueter(){
    fun bluet(){
        print(2)
    }
}

//函数定义。参数格式为 参数：类型
fun sum(a: Int, b: Int): Int {
    return a + b;
}

//表示式作为函数体，返回类型自动推断。
fun sum2(a: Int, b: Int) = a + b

public fun sum3(a: Int, b: Int): Int = a + b //public 方法必须明确写出返回类型

//无返回值的函数（类似Java中的void）
fun printSum(a: Int, b: Int): Unit{
    print(a + b)
}

public fun printSum2(a: Int, b: Int){//如果返回值类型是Unit，则可以省略（public方法也是这样）
    print(a + b)
}

//可变长参数函数
fun vars(vararg v: Int){
    for (vt in v){
        print(vt)
    }
}

//当一个引用可能为null时，对应的类型声明必须明确标记为null
//当str中的字符串内容不是一个整数时，返回null
/*
fun parseInt(str : String) : Int?{
    //...
}
*/


//类型检测及自动类型转换
fun getStringLength(obj: Any): Int?{
    if (obj is String){
        //做过类型判断后，obj会被系统自动转换为String类型
        return obj.length;
    }

    //在这里还有一种方法，与Java中instanceof不同，使用 !is
    /*if (obj !is String){
        //xxx
    }*/

    //这里的obj仍然是Any类型的引用
    return null
}

fun getStringLenth(obj: Any): Int?{
    //在 '&&' 运算符的右侧，'obj'的类型会自动被转换为 'String'
    if (obj is String && obj.length > 0){
        return obj.length
    }
    return null
}


//区间
fun section(){
    //区间表达式由操作符形式...的rangeTo函数辅以 in 和 !in 形成
    //区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现

    for (i in 1..4) print(i) //输出 '1234'

    for (i in 4..1) print(i) //什么都不输出

    /*if (i in 1..10){//等同于 1 <= i <=10
        print(i)
    }*/

    //使用step指定步长
    for (i in 1..4 step 2) print(i)//输出 "13"

    for (i in 4 downTo 1 step 2) print(i) //输出"42"

    //使用until函数排除结束元素
    for (i in 1 until 10){//i in [1,10) 排除了10
        print(i)
    }
}

//位移运算
fun driftOperation(){
    println(4.shl(2)) //右移
    println(4.shr(2)) //左移
    println(4.ushr(2))//无符号右移
    println(4.and(1))//与
    println(4.or(1))//或
    println(4.xor(2))//异或
    println(4.inv())//反向
}






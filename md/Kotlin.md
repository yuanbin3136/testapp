


每行的结尾不用";"了，每行必须分开
变量、常量、方法
变量 var a、var b:Boolean = x、var c : String = ""//用冒号:指定类型
var list = ArrayList()//不需要写new
常量 val
方法与参数及返回值
fun（a:Int,s:String) b:Boolean{//参数用 变量+冒号：+变量类型，方法需要返回值的在参数的括号外写一个
fun (a:Int,B:Int)c:Int = a + b//直接等于一段函数
fun(a:Any)//任意的类型
var list:List = ArrayList()这样写，add方法不能调用，需要定义为ArrayList类型(var list:ArrayList)
拼接字符串:
var host = "xxx"
var s = "http://$host:$port"
类：继承，class A : B(){//冒号+父类+括号()，再，View.Onclick..就是实现接口
只实现接口就冒号 :Iface,不加括号

静态方法
conpanion object{
@Jvmstatic //这行表示java代码也可以调用,A.Companion.a();
fun a(){
var s:String
全是静态的话就把class替换成object，之后内部的变量、方法就都是静态的。
object xxUtils{

get、set方法
textView.text = "xxx"//可以简化成.xx直接编辑或者读取；
list集合的get可以用list[index]像数组一样使用；

null
?表示可以为空，在编辑是ide会根据这个查找某些会出现空指针的代码并提示。

位运算
不用 &、|、^、~了，用 and、or、xor、inv()；
复习位运算：非0为真，^不同为1，同为0；~按位取反
&&、||还没看到
左移shl、右移shr
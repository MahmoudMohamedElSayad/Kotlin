package com.example.kotlin.utils

fun main(){
    var number:Int=28
    var window :String
    window=when (number){
        9->"sfdfsdf"
        10->"sadsafdsfsd"
        else->"no number"
    }
    var num1=0
    while (num1<10){
        kotlin.io.println("the number ${num1+1} is $num1")
        num1++
    }
    kotlin.io.println("the total numbers is $num1")
    var num2=10
    var total=0
    do {
        kotlin.io.println("the number is $num2")
        num2--
        total++
    }while (num2>0)
    kotlin.io.println("the total numbers is $total")
   for(item in 1..10){
       kotlin.io.println("$item")
   }
    var myArrayCount= arrayOf(1,2,3,4,5,6,7,8,9)
    for (i in myArrayCount.indices step 2){
        kotlin.io.println("$i")
    }
    kotlin.io.println("the myArraySize is ${myArrayCount.size}")
    for (x in myArrayCount[0] until  myArrayCount[myArrayCount.size-1]){
        kotlin.io.println("$x")
    }
    for (int in 10 downTo 1 step 1){
        kotlin.io.println("eeeeeeeee $int")
    }
    for(int in 0..10){
        if (int ==5){
            break
        }
        kotlin.io.println("$int")
    }
    for(int in 0..10){
        if (int ==5){
           continue
        }
        kotlin.io.println("$int")
    }
}
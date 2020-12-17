package com.example.homework5new

import com.google.gson.GsonBuilder

data class Person(val age: Int,
             val name: String,
             var mom: Person?,
             var dad: Person?,
             var relativesCount: Int,
             var isAdult: Boolean
)

fun main() {
    val me = Person(20, "Dima", null, null,  7, true)

    val dad = Person(45, "Dad", null, null,  7, true)
    val mom = Person(45, "Mom", null, null,  7, true)

    val grandpa = Person(70, "Dad's father", null, null,  7, true)
    val grandma = Person(70, "Dad's mother", null, null,  7, true)
    val grandpa1 = Person(70, "Mom's father", null, null,  7, true)
    val grandma1 = Person(70, "Mom's mother", null, null,  7, true)

    val grandGrandMa = Person(95, "Mom's grandmother", null, null,  7, true)

    me.dad = dad
    me.mom = mom


    dad.dad = grandpa
    dad.mom = grandma
    mom.dad = grandpa1
    mom.mom = grandma1

    grandma1.mom = grandGrandMa


    val gson = GsonBuilder().setPrettyPrinting().create()
    val familyTree = gson.toJson(me)
    println("Serialized object:\n${familyTree}")

    val familyTreeString: String = """ {"age" : 25, "name" : "Me", "dad" : {"age" : 45, "name" : "Dad", "dad" : null, "mom" : null, "relativesCount" : 2, "isAdult" : true}, "mom" : {"age" : 45, "name" : "Mom", "dad" : null, "mom" : null, "relativesCount" : 2, "isAdult" : true}, "relativesCount" : 2, "isAdult" : true} """
    val familyTreeObject = gson.fromJson(familyTreeString, Person::class.java)
    println("\nDeserialized object:\n${familyTreeObject}")
}
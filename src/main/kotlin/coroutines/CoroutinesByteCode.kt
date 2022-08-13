package coroutines

import kotlinx.coroutines.delay

object CoroutinesByteCode {

    suspend fun myFunction() {
        println("Before")
        delay(1000) // suspending
        println("After")
    }

    suspend fun counterFunction() {
        println("Before")
        var counter = 0
        delay(1000) // suspending
        counter++
        println("Counter: $counter")
        println("After")
    }

    suspend fun printUser(token: String) {
        println("Before")
        val userId = getUserId(token) // suspending
        println("Got userId: $userId")
        val userName = getUserName(userId, token) // suspending
        println(User(userId, userName))
        println("After")
    }

    suspend fun getUserName(userId: String, token: String) : String {
        delay(3000)
        return "Vasya!"
    }

    suspend fun getUserId(token: String): String {
        delay(2000)
        return "someUserId"
    }

}

data class User(val userId: String, val userName: String)

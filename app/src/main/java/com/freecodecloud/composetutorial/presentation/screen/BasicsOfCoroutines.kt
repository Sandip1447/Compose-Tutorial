package com.freecodecloud.composetutorial.presentation.screen

import kotlinx.coroutines.*
import kotlin.random.Random

// How to avoid Coroutine Mistakes

/*

// Don't do this way
suspend fun getUserFirstNames(userIds: List<String>): List<String> {

    val firstNames = mutableListOf<String>()

    for (id in userIds) {
        firstNames.add(getFirstName(id))
    }

    return firstNames
}
*/

// Do this way
suspend fun getUserFirstNames(userIds: List<String>): List<String> {

    val firstNames = mutableListOf<Deferred<String>>()
    coroutineScope {
        for (id in userIds) {
            // launch new independent coroutine from parent suspend function
            val firstName =
                async { getFirstName(id) }

            firstNames.add(firstName)
        }
    }
    return firstNames.awaitAll()
}

suspend fun getFirstName(userId: String): String {
    delay(1000L)
    return "First name"
}

// 2.

suspend fun doSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_1000)
        while (random != 50000 && isActive) { // isActive to check job is cancel or not
            random = Random.nextInt(100_1000)
            ensureActive() // add this if you cancel the job
        }
    }
    delay(500)
    job.cancel()

}
//3. if you are using network call then provide (Dispatchers.IO)

suspend fun doSomeNetworkCall(): String {
    return withContext(Dispatchers.IO) {
        "Hello using withContext(Dispatchers.IO)"
    }
}
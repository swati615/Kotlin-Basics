import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {
    // Single call
    println("Calling suspended version of do something gives " + doSomethingSuspend(0))

    // Parallel calls
    val deferredList: MutableList<Deferred<Int>> = mutableListOf()
    val job = launch(CoroutineExceptionHandler {_, exception ->
        println(exception.stackTrace)
    }) {
        for(i in 0..3) {
            println("Launching $i")
            deferredList.add(
                async {
                    doSomethingSuspend(i)
                }
            )
        }
        deferredList.awaitAll()
    }
    job.join()
}

fun doSomething(count: Int, onFailed: (String)->Unit, onSuccess:(Int) -> Unit) {
    println("Executing doSomething")
    onSuccess(count)
}

suspend fun doSomethingSuspend(count: Int): Int {
    return suspendCoroutine { continuation ->
        doSomething(count, { continuation.resumeWithException(Error("Something")) }, { continuation.resume(count) })
    }
}

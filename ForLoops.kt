fun main() {
    val array = arrayOf(1,2,3,4,5,6)
   
    // forward loop
    for (i in 0..array.size - 1)
    	print(array[i])
    
    println("")
    for(arr in array)
    	print(arr)
        
    println("")
    for((index, arr) in array.withIndex())
    	println("Index = " + index + " Element = " + arr)
        
    // reverse loop
    println("")
    for (i in array.size -1 downTo 0)
    	print(array[i])
    
    println("")
    for(arr in array.reversed()) 
    	print(arr)
    
    println("")
    //Step size
    for (i in 0..array.size-1 step 2)
    	print(array[i])
}

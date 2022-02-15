fun main() { 
    
    //Fixed size null initialized string array
    val emptyStringArray: Array<String?> = arrayOfNulls(4)
    emptyStringArray[0] = "Swati"
    print(emptyStringArray[0])
    emptyStringArray[3] = " Shah"
    println(emptyStringArray[3])
    
    // Fixed size fixed values string array
    val valuedArrayOfStrings = arrayOf("Hello", "How")
    println(valuedArrayOfStrings[0])
    valuedArrayOfStrings[0] = "Hi"
    println(valuedArrayOfStrings[0])
    
    //Fixed size non-initialized int array
    val emptyIntArray = IntArray(4)
    emptyIntArray[1] = 5
    println(emptyIntArray[1])
    
    //Fixed size fixed value int array
    val valuedArrayOfInts = intArrayOf(1,2,3,4)
    println(valuedArrayOfInts[1])
    
    //Variable size string array
    val emptyStringList = mutableListOf<String>()
    emptyStringList.add("Swati")
    println(emptyStringList.get(0))
    
    //Variable size int array
    val emptyIntList = mutableListOf<Int>()
    emptyIntList.add(1)
    println(emptyIntList.get(0))
    
    // 2D integer array fixed size
    val twoDimensionalInt = Array(3) { IntArray(3)}
    twoDimensionalInt[1][1] = 3
    println(twoDimensionalInt[1][1])
    
    // 2D string array fixed size
    val twoDimensionalString: Array<Array<String?>> = Array(3) { arrayOfNulls(3) }
    twoDimensionalString[1][1] = "2D Array"
    println(twoDimensionalString[1][1])
   
}

fun main(){
    val myList: MyList<String> = MyArrayList()
    for (i in 0..100){
        myList.add("$i")
    }
    for (i in 0..90){
        myList.removeAt(0)
    }

    for (i in 0 until myList.size()){
        println(myList.get(i))
    }
}
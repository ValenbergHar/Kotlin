import java.util.*

class Worker(val name :String, val occupy :String, val year :Int) {
    fun work(){
        println("...is working")
    }
    val experience: Int
    get()=Calendar.getInstance().get(Calendar.YEAR)-year


}
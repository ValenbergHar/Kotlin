fun main(){
    val student1 = Student("Jan", "Pazniak","232323")
    val student2 = Student("Jan", "Pazniak","232323")

    println(student1)
    println(student2)
    println(student1.hashCode())
    println(student2.hashCode())
    println(student1==student2)
    println(student1===student2)
}
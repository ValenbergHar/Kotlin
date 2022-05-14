fun main() {
//    val cat = Cat("Zianon", 12, 3.3f)
//    cat.printInfo()
//    println(cat.isOld())

    val worker = Worker("Zianon", "politic", 1989)
    println(worker.experience)
    worker.info()

}

//fun Cat.isOld() = age >=12
fun Worker.info()= println("Name - $name, Occupy - $occupy, year - $year, time - $experience")

package com.example.pr3

// 1. Базовый родительский класс Person
// 'open' позволяет наследоваться от этого класса
open class Person(val name: String, var age: Int) {

    // 'open' метод можно переопределять в классах-наследниках
    open fun displayInfo() {
        println("Person: Name = $name, Age = $age")
    }

    open fun work() {
        println("$name is doing general work.")
    }
}

// 2. Класс-наследник Student
class Student(
    name: String,
    age: Int,
    val studentId: String,
    var gpa: Double
) : Person(name, age) {

    // Переопределяем метод родителя
    override fun displayInfo() {
        super.displayInfo() // Вызываем базовый метод родителя
        println("   Details: Student ID = $studentId, GPA = $gpa")
    }

    override fun work() {
        println("Student $name is studying for exams.")
    }
}

// 3. Класс-наследник Teacher
class Teacher(
    name: String,
    age: Int,
    val subject: String,
    val salary: Double
) : Person(name, age) {

    override fun displayInfo() {
        println("Teacher: Name = $name, Subject = $subject, Salary = $$salary")
    }

    override fun work() {
        println("Teacher $name is teaching $subject.")
    }
}

// 4. Абстрактный класс и его реализация
abstract class Shape {
    abstract fun calculateArea(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

// 5. Data-класс для хранения данных
data class Course(val title: String, val credits: Int)


fun main() {
    println("=== LAB 3: CLASSES & INHERITANCE ===")

    // Создаем объекты
    val person = Person("Alex", 40)
    val student = Student("Ivan", 20, "ST12345", 4.8)
    val teacher = Teacher("Maria", 35, "Kotlin Programming", 1500.0)

    println("\n--- 1. Display Information ---")
    person.displayInfo()
    println()
    student.displayInfo()
    println()
    teacher.displayInfo()

    println("\n--- 2. Polymorphism in Action ---")
    val people: List<Person> = listOf(person, student, teacher)
    for (p in people) {
        p.work()
    }

    println("\n--- 3. Abstract Class Example ---")
    val rect = Rectangle(5.0, 4.0)
    println("Rectangle area: ${rect.calculateArea()}")

    println("\n--- 4. Data Class Example ---")
    val course1 = Course("Mobile App Development", 4)
    val course2 = course1.copy(title = "Advanced Kotlin")
    println("Course 1: $course1")
    println("Course 2: $course2")
}
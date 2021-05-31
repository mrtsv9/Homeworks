package homework4

import android.util.Log

class Worker(override var name: String, override var salary: Int) : Employee() {
//    constructor (name: String, salary: Int) : this()
    fun working(): String {
        return "he is working"
    }
    override fun toString(): String {
        return "Worker ${this.name} earns ${this.salary}}"
    }
}
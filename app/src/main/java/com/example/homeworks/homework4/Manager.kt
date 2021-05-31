package homework4

class Manager(override var name: String, override var salary: Int) : Employee() {
//    constructor (name: String, salary: Int) : this()
    lateinit var list: MutableList<Worker>
    override fun toString(): String {
        return "Manager $name earns $salary"
    }

    fun showList(): String {
        return "Manager(list=$list)"
    }
}
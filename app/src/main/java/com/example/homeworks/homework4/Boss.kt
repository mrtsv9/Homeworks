package homework4

class Boss(override var name: String, override var salary: Int) : Employee() {
//    constructor (name: String, salary: Int) : this()
    lateinit var list: MutableList<Manager>
    override fun toString(): String {
        return "Boss $name earns $salary"
    }

    fun showList(): String {
        return "Boss(list=$list)"
    }
}
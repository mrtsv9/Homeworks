package homework3

open class Animal {
    val speed: Int = 0
    fun countHours(speed: Int, way: Double): Double {
        return way/(speed*3.6)
    }

    companion object {
        const val DISTANCE: Int = 1080
    }
}
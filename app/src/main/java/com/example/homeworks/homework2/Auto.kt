package homework2


class Auto(
    brand: String,
    color: String,
    engineVolume: Int,
    carNumber: String?
) {
    constructor(brand: String, color: String, engineVolume: Int) : this(
        brand,
        color,
        engineVolume,
        null
    )

    val brand: String = "default"
    val color: String = "black"
    val engineVolume: Int = 0
    var carNumber: String? = null

    override fun toString(): String {
        if (carNumber != null)
        return "Auto(brand='$brand', color='$color', engineVolume=$engineVolume, carNumber=$carNumber)"
        else
        return "Auto(brand='$brand', color='$color', engineVolume=$engineVolume) Transit"
    }


}
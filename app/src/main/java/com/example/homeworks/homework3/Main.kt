package homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homeworks.R

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var justDog = Dog("doggy")
        justDog.name= "doggy"
        var justCat = Cat("kitty")
        justCat.name = "kitty"
        // я не понял почему у меня не работает задание имен в конструкторе, пробовал разные способы,
        // но ничего особо не помогало, так что пришлось вручную
        Log.e("KEK", "${justDog.name} пробежал дистанцию в 72 км за " +
                "${justDog.countHours(10, 72.0)} часов")
        Log.e("KEK", "${justCat.name} пробежал дистанцию в 1080 метров за " +
                "${justCat.countHours(6, Animal.DISTANCE.toDouble()/1000)} часов")

    }
}
package ru.netology.markers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.markers.R

@AndroidEntryPoint
class AppActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("00000000-0000-0000-0000-000000000000")
        MapKitFactory.initialize(this)

    }
}

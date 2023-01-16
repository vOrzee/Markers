package ru.netology.markers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.markers.R
import ru.netology.markers.utils.API_KEY

@AndroidEntryPoint
class AppActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(API_KEY)
        MapKitFactory.initialize(this)
    }
}
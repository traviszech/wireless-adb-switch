package com.smoothie.widgetFactory

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.smoothie.wirelessDebuggingSwitch.R

open class CollapsingToolbarActivity(
    private val contentFragment: Fragment,
    private val titleStringResource: Int
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.isNavigationBarContrastEnforced = false

        if (NavigationBar.getInteractionMode(this) == NavigationBar.MODE_GESTURES) {
            window.navigationBarColor = Color.TRANSPARENT
            window.navigationBarDividerColor = Color.TRANSPARENT
        }
        else {
            window.navigationBarColor = getColor(R.color.colorOnSecondary)
            window.navigationBarDividerColor = getColor(R.color.colorOutline)
        }


        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.title = getString(titleStringResource)
        toolbar.setOnClickListener { finish() }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_holder, contentFragment)
            .commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        findViewById<ViewGroup>(R.id.root_view).invalidate()
    }

}

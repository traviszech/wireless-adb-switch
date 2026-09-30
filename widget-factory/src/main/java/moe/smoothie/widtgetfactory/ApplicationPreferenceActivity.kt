package moe.smoothie.widtgetfactory

import android.os.Bundle
import moe.smoothie.widgetfactory.R
import moe.smoothie.widtgetfactory.preference.PreferenceActivity

/**
 * /this derivative of [PreferenceActivity] will hide the navigation up button from the toolbar
 * if the [EXTRA_KEEP_NAVIGATION_UP] is not found inside an intent.
 */
open class ApplicationPreferenceActivity(
    preferenceResourceId: Int = R.xml.preferences_app,
    titleStringResource: Int = R.string.settings
) : PreferenceActivity(preferenceResourceId, titleStringResource) {

    companion object {
        const val EXTRA_KEEP_NAVIGATION_UP = "moe.smoothie.widgetfactory.KEEP_NAVIGATION_UP"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!intent.hasExtra(EXTRA_KEEP_NAVIGATION_UP)) {
            toolbar.setNavigationOnClickListener(null)
            toolbar.navigationIcon = null
        }
    }
}

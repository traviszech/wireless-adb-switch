package moe.smoothie.widtgetfactory.preference

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import moe.smoothie.widtgetfactory.CollapsingToolbarActivity
import moe.smoothie.widgetfactory.R

open class PreferenceActivity(
    val preferencesResourceId: Int,
    titleStringResource: Int = R.string.settings
) : CollapsingToolbarActivity(
    titleStringResource,
    PreferenceFragment()
) {

    @CallSuper
    open fun onPreferencesCreated(preferenceFragment: PreferenceFragment) {  }

    @CallSuper
    open fun onPreferenceFragmentViewCreated(view: View, savedInstanceState: Bundle?) { }
}

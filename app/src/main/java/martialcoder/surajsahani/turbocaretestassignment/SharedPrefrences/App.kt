package martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences

import android.app.Application
import android.content.Context

class App: Application() {
    private lateinit var context : Context
    val CHANNEL_ID = "turboCare"

    companion object{
        public lateinit var appPreference1: AppPrefrences


        val appInstance: App? = null

        fun getAppPreference(): AppPrefrences? {
            return appPreference1
        }

    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        appPreference1 = AppPrefrences.init(context, "turboCare")
    }

}
package com.example.todolistmvvmroom.firebase
import android.annotation.SuppressLint
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import timber.log.Timber

object RemoteConfigUtils {

    private const val  TAG = "RemoteConfigUtils"
    private const val HELLO_BUTTON_TEXT = "add_task_button_text"
    private const val HELLO_BUTTON_COLOR = "add_task_button_color"

    private val DEFALTS: HashMap<String, Any> =
        hashMapOf(
            HELLO_BUTTON_COLOR to "#006699",
            HELLO_BUTTON_TEXT to "Add Task"
        )
    @SuppressLint("StaticFieldLeak")
    private lateinit var remoteConfig: FirebaseRemoteConfig

    fun init(){
        remoteConfig = getFirebaseRemoteConfig()
    }
    private fun getFirebaseRemoteConfig(): FirebaseRemoteConfig{
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings: FirebaseRemoteConfigSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = if (BuildConfig.DEBUG){
                0
            }else{
                0
            }
        }
        remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(DEFALTS)
            fetchAndActivate().addOnCompleteListener {
                Timber.d("Remote config fetching from the firebase")
            }
        }
        return remoteConfig
    }

    fun getButtonColor(): String = remoteConfig.getString(HELLO_BUTTON_COLOR)
    fun getButtonText(): String =  remoteConfig.getString(HELLO_BUTTON_TEXT)
}
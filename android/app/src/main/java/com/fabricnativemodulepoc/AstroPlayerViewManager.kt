package com.fabricnativemodulepoc

import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


@ReactModule(name = AstroPlayerViewManager.NAME)
class AstroPlayerViewManager(private val reactApplicationContext: ReactApplicationContext): SimpleViewManager<AstroPlayerView>() {

    companion object {
        const val NAME = "RTNAstroPlayerView"
    }

    override fun getName(): String = NAME

    override fun createViewInstance(themedReactContext: ThemedReactContext): AstroPlayerView {
        val view = AstroPlayerView(themedReactContext)

        themedReactContext.addLifecycleEventListener(object : LifecycleEventListener {
            override fun onHostResume() {
                view.onHostResume()
            }

            override fun onHostPause() {
                view.onHostPause()
            }

            override fun onHostDestroy() {
                view.onHostDestroy()
            }
        })
        return view
    }

    @ReactProp(name = "url")
    fun setUrl(view: AstroPlayerView, url: String?) {
        println("setUrl: $url")
        url?.let { view.setUrl(it) }
    }

    @ReactProp(name = "sourceType")
    fun setSourceType(view: AstroPlayerView, sourceType: String?) {
        println("setSourceType: $sourceType")
//        sourceType?.let { view.setSourceType(it) }
    }

    @ReactProp(name = "autoplay")
    fun setAutoplay(view: AstroPlayerView, autoplay: Boolean?) {
        println("setSourceType: $autoplay")
//        autoplay?.let { view.setAutoplay(it) }
    }
}
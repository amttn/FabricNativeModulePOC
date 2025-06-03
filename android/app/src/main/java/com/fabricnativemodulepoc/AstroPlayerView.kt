package com.fabricnativemodulepoc

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.bitmovin.player.PlayerView
import com.bitmovin.player.api.Player
import com.bitmovin.player.api.source.SourceConfig
import com.bitmovin.player.api.source.SourceType

class AstroPlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var playerView: PlayerView? = null
    private var bitmovinPlayer: Player? = null

    private var currentUrl: String? = null
    private var currentSourceType: SourceType? = null

    init {
        setupPlayerView()
    }

    private fun setupPlayerView() {
        playerView = PlayerView(context).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        addView(playerView)
        bitmovinPlayer = playerView?.player
    }

    fun setUrl(url: String) {
        if (currentUrl != url) {
            currentUrl = url
            // Attempt to load the source if both URL and source type are available
            loadSourceIfReady()
        }
    }

    fun setSourceType(type: String) {
        val newSourceType = when (type.lowercase()) {
            "dash" -> SourceType.Dash
            "hls" -> SourceType.Hls
            "progressive" -> SourceType.Progressive
            else -> {
                // Log an error or handle unsupported types gracefully
                System.err.println("BitmovinPlayer: Unsupported source type received: $type. Defaulting to Progressive.")
                SourceType.Progressive // Fallback to a default type
            }
        }
        if (currentSourceType != newSourceType) {
            currentSourceType = newSourceType
            // Attempt to load the source if both URL and source type are available
            loadSourceIfReady()
        }
    }

    private fun loadSourceIfReady() {
        if (currentUrl != null && currentSourceType != null) {
            val sourceConfig = SourceConfig(currentUrl!!, currentSourceType!!)
            val source = com.bitmovin.player.api.source.Source(sourceConfig)
            bitmovinPlayer?.load(source)
            println("AstroPlayerView: Loading source: $currentUrl with type $currentSourceType")
        }
    }

    fun onHostResume() {
        println("AstroPlayerView: onHostResume called")
        playerView?.onResume()
    }

    fun onHostPause() {
        println("AstroPlayerView: onHostPause called")
        playerView?.onPause()
    }

    fun onHostDestroy() {
        println("AstroPlayerView: onHostDestroy called")
        playerView?.onDestroy()
        bitmovinPlayer = null
        playerView = null
    }

    fun getPlayer(): Player? {
        return bitmovinPlayer
    }
}
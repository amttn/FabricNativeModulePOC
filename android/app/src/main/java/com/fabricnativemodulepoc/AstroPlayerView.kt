package com.fabricnativemodulepoc

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class AstroPlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var playerView: PlayerView? = null
    private var player: Player? = null

    private var currentUrl: String? = null

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
        player = ExoPlayer.Builder(context).build()
        playerView?.player = player
    }

    fun setUrl(url: String) {
        if (currentUrl != url) {
            currentUrl = url
            // Attempt to load the source if both URL and source type are available
            loadSourceIfReady()
        }
    }

    private fun loadSourceIfReady() {
        currentUrl?.let {
            val mediaItem = MediaItem.fromUri(it)
            player?.setMediaItem(mediaItem)
            player?.prepare()
            player?.play()
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
        player?.release()
        playerView = null
        player = null
    }

    fun getPlayer(): Player? {
        return player
    }
}
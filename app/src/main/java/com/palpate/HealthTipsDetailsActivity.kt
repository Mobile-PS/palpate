package com.palpate

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.palpate.adapter.HealthTipListAdapter
import kotlinx.android.synthetic.main.health_tips_details_activity.*


class HealthTipsDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_tips_details_activity)

        back.setOnClickListener {
            finish()
        }

        val intent = getIntent();
        val myValue = intent.getStringExtra("type")
        if (myValue != null) {
            if (myValue == "video") {
                img_artical.visibility = View.GONE
                video_view.visibility = View.VISIBLE
                initializePlayer();
            } else {

                img_artical.visibility = View.VISIBLE
                video_view.visibility = View.GONE
            }
        }


    }

    private fun initializePlayer() {
        val player = ExoPlayerFactory.newSimpleInstance(
            DefaultRenderersFactory(this),
            DefaultTrackSelector(), DefaultLoadControl()
        )

        val videoPath = RawResourceDataSource.buildRawResourceUri(R.raw.samplevideo).toString()

        val uri: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.samplevideo)

        val audioSource = ExtractorMediaSource(
            uri,
            DefaultDataSourceFactory(this, "MyExoplayer"),
            DefaultExtractorsFactory(),
            null,
            null
        )

        player.prepare(audioSource)
        video_view.setPlayer(player)
        video_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM)
        player.playWhenReady = true
    }


}
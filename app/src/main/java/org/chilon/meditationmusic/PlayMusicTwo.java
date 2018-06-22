package org.chilon.meditationmusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayMusicTwo extends Activity {

    private Button stopButton;
    private MediaPlayer mdx;
    boolean isPlay = true;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        MainActivity mainActivity = new MainActivity();
        textView = (TextView) findViewById(R.id.play_music2_main_text_id);
        textView.setText(mainActivity.getMusicTypeItem(1));

        stopButton = (Button) findViewById(R.id.stopid);
        stopButton.setBackgroundResource(android.R.drawable.ic_media_pause);
        mdx = MediaPlayer.create(PlayMusicTwo.this, R.raw.violin_guitar);
        mdx.start();
        mdx.setLooping(true);

        //Button
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay) {
                    stopButton.setBackgroundResource(android.R.drawable.ic_media_play);
                    mdx.pause();
                    mdx = MediaPlayer.create(PlayMusicTwo.this, R.raw.violin_guitar);
                    isPlay = false;
                } else {
                    stopButton.setBackgroundResource(android.R.drawable.ic_media_pause);
                    mdx.start();
                    isPlay = true;
                }
            }
        });
    }
}

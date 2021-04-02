package kr.ezcode.app0803;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool mPool;
    int mDing;
    AudioManager mAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mDing = mPool.load(this,R.raw.bgm, 1);

        mAm = (AudioManager) getSystemService(AUDIO_SERVICE);

        findViewById(R.id.beep1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPool.play(mDing,1,1,0,0,1);
            }
        });

        findViewById(R.id.beep2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAm.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
            }
        });
    }
}
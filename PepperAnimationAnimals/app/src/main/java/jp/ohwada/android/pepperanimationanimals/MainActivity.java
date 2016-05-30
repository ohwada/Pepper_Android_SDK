package jp.ohwada.android.pepperanimationanimals;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity {

    private Animate mAnimate;
    private MediaPlayer mMediaPlayer;

    /**
     * === onCreate ===
     */    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * === onStart ===
     */
    @Override
    protected void onStart() {
        super.onStart();
        mAnimate = new Animate(this);
        mAnimate.setOnStartedListener(new Animate.OnStartedListener() {
            @Override
            public void onStarted() {
                // play sound, after animation started
                if ( mMediaPlayer != null ){
                    mMediaPlayer.start();
                }
            }
        });
    }        

    /**
     * === onStop ===
     */
    @Override
    protected void onStop() {
        super.onStop();
        stopMediaPlayer();  
    }

    /**
     * --- button onClick Elephant ---
     */
    public void onClickElephant(View view) {
        procAnimal(R.raw.elephant_a001, R.raw.elephant_sound);
    }

    /**
     * --- button onClick Dog ---
     */
    public void onClickDog(View view) {
        procAnimal(R.raw.dog_a001, R.raw.dog_sound);
    }

    /**
     * --- button onClick Feline ---
     */
    public void onClickFeline(View view) {
        procAnimal(R.raw.feline_a001, R.raw.feline_sound);
    }

    /**
     * --- button onClick Mouse ---
     */
    public void onClickMouse(View view) {
        procAnimal(R.raw.mouse_a001, R.raw.mouse_sound);
    }

    /**
     * --- button onClick Wolf ---
     */
    public void onClickWolf(View view) {
        procAnimal(R.raw.wolf_a001, R.raw.wolf_sound);
    }

    /**
     * --- button onClick Gorilla A ---
     */
    public void onClickGorillaA(View view) {
        procAnimal(R.raw.gorilla_a001, R.raw.gorilla_sound_a);
    }

    /**
     * --- button onClick Gorilla B ---
     */
    public void onClickGorillaB(View view) {
        procAnimal(R.raw.gorilla_b001, R.raw.gorilla_sound_b);
    }

    /**
     * --- button onClick Stop ---
     */
    public void onClickStop(View view) {
        stopMediaPlayer();
        // TODO: how to stop animation
    }

    /**
     * procAnimal
     */                        
    private void procAnimal(int res_amin, int res_sound) {
        // stop sound, if playing
        if ((mMediaPlayer != null) && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        if (res_sound != 0) {
            mMediaPlayer = MediaPlayer.create(this, res_sound);
        }
        if (res_amin != 0) {
            Animation animation = Animation.fromResources(this, res_amin);
            mAnimate.run(animation);
        }
    }

    /**
     * stopMediaPlayer
     */
    private void stopMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }    
    }

}

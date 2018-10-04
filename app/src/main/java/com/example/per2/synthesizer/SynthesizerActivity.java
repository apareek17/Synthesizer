package com.example.per2.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int WHOLE_NOTE = 400;
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonAh;
    private Button buttonBh;
    private Button buttonBbh;
    private Button buttonCh;
    private Button buttonCsh;
    private Button buttonDh;
    private Button buttonDsh;
    private Button buttonEh;
    private Button buttonFh;
    private Button buttonFsh;
    private Button buttonGh;
    private Button buttonGsh;
    private Map<Integer, Integer> noteMap;


    private Button buttonScale;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteAh;
    private int noteBbh;
    private int noteBh;
    private int noteCh;
    private int noteCsh;
    private int noteDh;
    private int noteDsh;
    private int noteEh;
    private int noteFh;
    private int noteFsh;
    private int noteGh;
    private int noteGsh;
    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;

    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        handler = new Handler();
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_ah, noteAh);
        noteMap.put(R.id.button_synth_bh, noteBh);
        noteMap.put(R.id.button_synth_bbh, noteBbh);
        noteMap.put(R.id.button_synth_ch, noteCh);
        noteMap.put(R.id.button_synth_csh, noteCsh);
        noteMap.put(R.id.button_synth_dh, noteDh);
        noteMap.put(R.id.button_synth_dsh, noteDsh);
        noteMap.put(R.id.button_synth_eh, noteEh);
        noteMap.put(R.id.button_synth_fh, noteFh);
        noteMap.put(R.id.button_synth_fsh, noteFsh);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        noteA = soundPool.load(this, R.raw.scalea,1 );
        noteBb = soundPool.load(this, R.raw.scalebb,1 );
        noteB = soundPool.load(this, R.raw.scaleb,1 );
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);
        noteAh = soundPool.load(this, R.raw.scalehigha,1 );
        noteBbh = soundPool.load(this, R.raw.scalehighbb,1 );
        noteBh = soundPool.load(this, R.raw.scalehighb,1 );
        noteCh = soundPool.load(this, R.raw.scalehighc, 1);
        noteCsh = soundPool.load(this, R.raw.scalehighcs, 1);
        noteDh = soundPool.load(this, R.raw.scalehighd, 1);
        noteDsh = soundPool.load(this, R.raw.scalehighds, 1);
        noteEh = soundPool.load(this, R.raw.scalehighe, 1);
        noteFh = soundPool.load(this, R.raw.scalehighf, 1);
        noteFsh = soundPool.load(this, R.raw.scalehighfs, 1);
        noteGh = soundPool.load(this, R.raw.scalehighg, 1);
        noteGsh = soundPool.load(this, R.raw.scalehighgs, 1);
    }

    private void setListeners(){
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonAh.setOnClickListener(noteListener);
        buttonBbh.setOnClickListener(noteListener);
        buttonBh.setOnClickListener(noteListener);
        buttonCh.setOnClickListener(noteListener);
        buttonCsh.setOnClickListener(noteListener);
        buttonDh.setOnClickListener(noteListener);
        buttonDsh.setOnClickListener(noteListener);
        buttonEh.setOnClickListener(noteListener);
        buttonFh.setOnClickListener(noteListener);
        buttonFsh.setOnClickListener(noteListener);
        buttonGh.setOnClickListener(noteListener);
        buttonGsh.setOnClickListener(noteListener);

        buttonScale.setOnClickListener(this);

    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonAh = findViewById(R.id.button_synth_ah);
        buttonBbh = findViewById(R.id.button_synth_bbh);
        buttonBh = findViewById(R.id.button_synth_bh);
        buttonCh = findViewById(R.id.button_synth_ch);
        buttonCsh = findViewById(R.id.button_synth_csh);
        buttonDh = findViewById(R.id.button_synth_dh);
        buttonDsh = findViewById(R.id.button_synth_dsh);
        buttonEh = findViewById(R.id.button_synth_eh);
        buttonFh = findViewById(R.id.button_synth_fh);
        buttonFsh = findViewById(R.id.button_synth_fsh);
        buttonGh = findViewById(R.id.button_synth_gh);
        buttonGsh = findViewById(R.id.button_synth_gsh);
        buttonScale = findViewById(R.id.button_main_scale);
    }

    @Override
    public void onClick(View view) {
        //one method to handle the clciks of all the buttons
        //but don't forget to tell the buttons who is doing the listening
        switch(view.getId()){
//            case R.id.button_synth_a:
//                soundPool.play(noteA, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_bb:
//                soundPool.play(noteBb, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_b:
//                soundPool.play(noteB, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_c:
//                soundPool.play(noteC, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_cs:
//                soundPool.play(noteCs, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_d:
//                soundPool.play(noteD, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_ds:
//                soundPool.play(noteDs, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_e:
//                soundPool.play(noteE, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_f:
//                soundPool.play(noteF, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_fs:
//                soundPool.play(noteFs, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_g:
//                soundPool.play(noteG, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_gs:
//                soundPool.play(noteGs, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_ah:
//                soundPool.play(noteAh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_bbh:
//                soundPool.play(noteBbh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_bh:
//                soundPool.play(noteBh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_ch:
//                soundPool.play(noteCh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_csh:
//                soundPool.play(noteCsh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_dh:
//                soundPool.play(noteDh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_dsh:
//                soundPool.play(noteDsh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_eh:
//                soundPool.play(noteEh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_fh:
//                soundPool.play(noteF, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_fsh:
//                soundPool.play(noteFsh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_gh:
//                soundPool.play(noteGh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
//            case R.id.button_synth_gsh:
//                soundPool.play(noteGsh, 1.0f, 1.0f, 1, 0,1.0f);
//                break;
            case R.id.button_main_scale:
                playScale();
                break;


        }
    }

    private void playScale() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteCh,WHOLE_NOTE));
        notes.add(new Note(noteBbh,WHOLE_NOTE * 2));
        notes.add(new Note(noteGs,WHOLE_NOTE/2));
        notes.add(new Note(noteBbh, WHOLE_NOTE/2));
        notes.add(new Note(noteCh,WHOLE_NOTE));
        notes.add(new Note(noteBbh, WHOLE_NOTE * 2));
        notes.add(new Note(noteGs,WHOLE_NOTE /2));
        notes.add(new Note(noteBbh, WHOLE_NOTE / 2));
        notes.add(new Note(noteCh, WHOLE_NOTE));
        notes.add(new Note(noteBbh, WHOLE_NOTE * 2));
        notes.add(new Note(noteGs, WHOLE_NOTE /2));
        notes.add(new Note(noteBbh,WHOLE_NOTE /2));
        notes.add(new Note(noteCh, WHOLE_NOTE /2));
        notes.add(new Note(noteCsh, WHOLE_NOTE /2));
        notes.add(new Note(noteCh,WHOLE_NOTE /2));
        notes.add(new Note(noteBbh, WHOLE_NOTE /2));
        notes.add(new Note(noteBbh, WHOLE_NOTE));
        notes.add(new Note(noteGs, WHOLE_NOTE /2));
        notes.add(new Note(noteBbh, WHOLE_NOTE /2));
        notes.add(new Note(noteCh, WHOLE_NOTE ));
        notes.add(new Note(noteBbh,WHOLE_NOTE * 2));
        notes.add(new Note(noteGs,WHOLE_NOTE /2));
        notes.add(new Note(noteBbh,WHOLE_NOTE /2));
        notes.add(new Note(noteCh,WHOLE_NOTE ));
        notes.add(new Note(noteBbh,WHOLE_NOTE * 2));
        notes.add(new Note(noteGs,WHOLE_NOTE / 2));
        notes.add(new Note(noteBbh,WHOLE_NOTE /2));
        notes.add(new Note(noteCh,WHOLE_NOTE));
        notes.add(new Note(noteBbh,WHOLE_NOTE * 2));
        notes.add(new Note(noteGs,WHOLE_NOTE / 2));
        notes.add(new Note(noteBbh,WHOLE_NOTE /2));
        notes.add(new Note(noteCsh,WHOLE_NOTE /2));
        notes.add(new Note(noteCsh,WHOLE_NOTE /2));
        notes.add(new Note(noteCh,WHOLE_NOTE /2));
        notes.add(new Note(noteBbh,WHOLE_NOTE /2));
        notes.add(new Note(noteGs,WHOLE_NOTE));
        notes.add(new Note(noteBbh,WHOLE_NOTE));

//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteF,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteGs,WHOLE_NOTE));
//        notes.add(new Note(noteF,WHOLE_NOTE));
//        notes.add(new Note(noteF,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteF,WHOLE_NOTE));
//        notes.add(new Note(noteDs,WHOLE_NOTE));
//        notes.add(new Note(noteA,WHOLE_NOTE));
//        notes.add(new Note(noteA,WHOLE_NOTE));
//        notes.add(new Note(noteA,WHOLE_NOTE));



//        notes.add(new Note(noteBb));
//        notes.add(new Note(noteB));
//        notes.add(new Note(noteC));
//        notes.add(new Note(noteCs));
//        notes.add(new Note(noteD));
//        notes.add(new Note(noteDs));
//        notes.add(new Note(noteE));
//        notes.add(new Note(noteF));
//        notes.add(new Note(noteFs));
//        notes.add(new Note(noteG));
//        notes.add(new Note(noteGs));
//        notes.add(new Note(noteAh));
//        notes.add(new Note(noteBbh));
//        notes.add(new Note(noteBh));
//        notes.add(new Note(noteCh));
//        notes.add(new Note(noteCsh));
//        notes.add(new Note(noteDh));
//        notes.add(new Note(noteDsh));
//        notes.add(new Note(noteEh));
//        notes.add(new Note(noteFh));
//        notes.add(new Note(noteFsh));
//        notes.add(new Note(noteGh));
//        notes.add(new Note(noteGsh));

        Note[] notesArr = new Note[notes.size()];
        for (int i = 0; i < notes.size(); i++) {
            notesArr[i] = notes.get(i);
        }
        scheduleSongs(500, notesArr);


    }

    private void delay(int duration){
        try {
            Thread.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }
    private void playNote(int note){
        playNote(note, 0);
    }

    private class KeyboardNoteListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int note = noteMap.get(id);
            playNote(note);
        }
    }


    private void scheduleSongs(long startDelay, Note[]... songs) {
        //the start delay makes sure all tasks are scheduled before songs are played
        long base = SystemClock.uptimeMillis() + startDelay;
        for (Note[] song: songs) {
            //delay accumulates as the song plays
            long delay = 0;
            for (final Note note: song) {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        soundPool.play(note.getNoteId(), 1f, 1f, 1, 0, 1f);
                    }
                }, base + delay); //schedule the note to play at the sum of the uptime and the delay
                delay+=note.getDelay();
            }
        }
    }
}

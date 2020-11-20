package com.homeworkshop.looperthreadexample;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.LongDef;

/**
 * Klasa watku działającego w tle, do którego będziemy wysyłać różne zadania
 */
public class ExampleLooperThread extends Thread {
    private static final String TAG = "ExampleLooperThread";

    //Handler jest wiązany z tym wątkiem w którym został zainicjalizowany
    public Handler handler;
    //wystawiamy loopera na zewnątrz.
    public Looper looper;

    @Override
    public void run() {
        //To dodaje Looper do wątku i tworzy Message queue
        Looper.prepare();
        //przypisujemy do widocznego na zwenątrz loopera lopper tego wątku.
        looper = Looper.myLooper();

        //musimy wywołać metodę Looper.prepare() zanim zainicjumemy Handlera
        handler = new ExampleHandler();

        Looper.loop();

        Log.d(TAG, "End of run()");
    }
}

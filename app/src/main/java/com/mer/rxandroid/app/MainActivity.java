package com.mer.rxandroid.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends Activity {

    EditText edt;
    TextView txt;

    Observable<String> observable;
    Observer<String> observer;
    public static final String TAG = "AppFlow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        txt = findViewById(R.id.txt);

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
                txt.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

    }

    public void onSubcribleClick(View view) {
        Log.d(TAG, "onSubcribleClick: " + edt.getText().toString());
        observable = Observable.just(edt.getText().toString());
        observable.subscribe(observer);
    }

}

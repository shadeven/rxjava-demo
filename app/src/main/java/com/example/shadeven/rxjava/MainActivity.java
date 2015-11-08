package com.example.shadeven.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

public class MainActivity extends Activity {

  @Bind(R.id.submit_btn) Button submitButton;
  @Bind(R.id.clear_btn) Button clearButton;
  @Bind(R.id.textView) TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.submit_btn)
  public void submit(View view) {
    Log.i(this.getClass().getName(), "Button clicked.");
    Observable.just("Steven", "Sophie")
            .subscribe(new Subscriber<String>() {
              @Override
              public void onCompleted() {
                Log.i(this.getClass().getName(), "Emitting completed.");
              }

              @Override
              public void onError(Throwable e) {
                Log.e(this.getClass().getName(), "Error occurred.");
              }

              @Override
              public void onNext(String s) {
                Log.i(this.getClass().getName(), "Emitting " + s);
                textView.append(" Emitting " + s);
              }
            });

  }

  @OnClick(R.id.clear_btn)
  public void clear(View view) {
    Log.i(this.getClass().getName(), "Content cleared.");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up submitButton, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}

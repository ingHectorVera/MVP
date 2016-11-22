package com.example.hectorvera.mvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.mvp.Presenter.MainPresenter;
import com.example.hectorvera.mvp.R;

public class MainActivity extends AppCompatActivity implements MainView{
    MainPresenter mainPresenter;
    private ProgressBar progressBar;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = ((ProgressBar) findViewById(R.id.a_main_progress));
        textView = ((TextView) findViewById(R.id.a_main_txt));

        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();
    }

    public void doMagic(View view) {
        mainPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mainPresenter != null) {
            mainPresenter.detachView();
        }
    }
}

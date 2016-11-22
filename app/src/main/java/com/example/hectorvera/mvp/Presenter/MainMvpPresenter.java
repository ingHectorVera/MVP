package com.example.hectorvera.mvp.Presenter;

import com.example.hectorvera.mvp.BasePresenter;
import com.example.hectorvera.mvp.View.MainView;

/**
 * Created by User on 11/22/2016.
 */

public interface MainMvpPresenter extends BasePresenter <MainView>{
    void loadData();
}

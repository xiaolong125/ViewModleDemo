package com.dev.flygo;

import android.os.Bundle;

import com.dev.flygo.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding activityMainBinding;
    private MainViewModle mainViewModle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModle = ViewModelProviders.of(this, new SavedStateViewModelFactory(getApplication(),this)).get(MainViewModle.class);
        activityMainBinding.setVm(mainViewModle);
        activityMainBinding.setLifecycleOwner(this);
    }
}

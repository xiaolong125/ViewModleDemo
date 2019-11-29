package com.dev.flygo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * 作者：flygo
 * 版本：1.0
 * 创建日期：2019/11/27
 * 描述：
 * 修订历史：
 */
@SuppressWarnings("ConstantConditions")
public class MainViewModle extends ViewModel{
    private static final String A_SCORE = "A_SCORE";
    private static final String B_SCORE = "B_SCORE";
    private int lastAScore = 0;
    private int lastBScore = 0;

    private SavedStateHandle savedStateHandle;
    public MainViewModle(SavedStateHandle handle){
        //设置默认值
        if(!handle.contains(A_SCORE)){
            handle.set(A_SCORE,0);
        }
        if(!handle.contains(B_SCORE)){
            handle.set(B_SCORE,0);
        }
        this.savedStateHandle = handle;
    }

    public MutableLiveData<Integer> getaTeamScore(){
        return savedStateHandle.getLiveData(A_SCORE);
    }

    public MutableLiveData<Integer> getbTeamScore(){
        return savedStateHandle.getLiveData(B_SCORE);
    }

    public void addATeamScore(int score){
        setLastScores();
        getaTeamScore().setValue(getaTeamScore().getValue()+score);
    }

    public void addBTeamScore(int score){
        setLastScores();
        getbTeamScore().setValue(getbTeamScore().getValue()+score);
    }

    public void undo(){
        getaTeamScore().setValue(lastAScore);
        getbTeamScore().setValue(lastBScore);
    }

    public void restart(){
        lastAScore = 0;
        lastBScore = 0;
        getaTeamScore().setValue(0);
        getbTeamScore().setValue(0);
    }

    private void setLastScores(){
        lastAScore = getaTeamScore().getValue();
        lastBScore = getbTeamScore().getValue();
    }
}

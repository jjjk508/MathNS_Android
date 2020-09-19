package com.example.mathns;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag_wrongnote extends Fragment implements View.OnClickListener {

    private View view;

    private Button answerBtn;
    private Button solveBtn;

    private View answerimg;
    private View mysolveimg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_wrongnote,container,false);  //xml 불러옴
        answerBtn = (Button)view.findViewById(R.id.answerBtn);
        solveBtn = (Button)view.findViewById(R.id.solveBtn);

        answerimg = view.findViewById(R.id.answerimg);
        mysolveimg = view.findViewById(R.id.mysolveimg);

        answerBtn.setOnClickListener(this);
        solveBtn.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.answerBtn:
                answerimg.setVisibility(View.VISIBLE);
                mysolveimg.setVisibility(View.GONE);
                break;
            case R.id.solveBtn:
                answerimg.setVisibility(View.GONE);
                mysolveimg.setVisibility(View.VISIBLE);
                break;
        }

    }
}


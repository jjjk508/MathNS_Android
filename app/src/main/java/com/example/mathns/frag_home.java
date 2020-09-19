package com.example.mathns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class frag_home extends Fragment {

    private View view;
    //문제 공유 리스트 뷰 생성
    private ListView questionList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home,container,false); //xml 불러옴
        //문제공유 리스트 뷰
        questionList = (ListView)view.findViewById(R.id.questionList);

        List<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        // 리스트와 데이터를 이어주는 다리역할(어댑터)
        questionList.setAdapter(adapter); //리스트에 어댑터 셋팅

        data.add("넓이 구하기 문제 도움필요해요~"); // 리스터에 들어갈 데이터 값(추후 db연동 수정요함)
        data.add("삼각형 문제 맞는지 확인해주세요~");
        data.add("이차 방정식 질문");
        data.add("미분 질문 있습니다!!");
        data.add("벡터방정식 도움 부탁 드립니다.");
        data.add("123123");

        adapter.notifyDataSetChanged(); //리스트 현 상태를 저장하겠다는 뜻
        return view;
    }
}


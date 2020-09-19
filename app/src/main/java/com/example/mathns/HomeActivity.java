package com.example.mathns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm; // 프래그먼트 매니저
    private FragmentTransaction ft; // 프래그먼트 트랜잭션

    //프래그먼트 생성
    private frag_home frag_home;
    private frag_profile frag_profile;
    private frag_wrongnote frag_wrongnote;
    private frag_recommendation frag_recommendation;
    private frag_login frag_login;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //바텀 네비게이션 뷰
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){ // 아이템 메뉴 아이디 가져옴
                    case R.id.action_bar_home:
                        setFrag(0);
                        break;
                    case R.id.action_bar_profile:
                        setFrag(1);
                        break;
                    case R.id.action_bar_wrongnote:
                        setFrag(2);
                        break;
                    case R.id.action_bar_recomendation:
                        setFrag(3);
                        break;
                    case R.id.action_bar_login:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });
        frag_home = new frag_home(); //프래그먼트 객체 생성
        frag_profile = new frag_profile();
        frag_wrongnote = new frag_wrongnote();
        frag_recommendation = new frag_recommendation();
        frag_login = new frag_login();
        setFrag(0); // 첫 프래그먼트 화면지정 ( 홈화면 )

    }

    //프래그먼트 교체가 일어나는 함수
    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); // 실질적인 프래그먼트 교체 이뤄질 때 프래그먼트 가져와서 트랜잭션

        switch(n){
            case 0:
                ft.replace(R.id.main_frame,frag_home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag_profile);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag_wrongnote);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag_recommendation);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frag_login);
                ft.commit();
                break;

        }

    }
    public void delFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n) {

            case 0:
                ft.remove(frag_home);
                ft.commit();
                frag_home = null;
                break;
            case 1:
                ft.remove(frag_profile);
                ft.commit();
                frag_profile = null;
                break;
            case 2:
                ft.remove(frag_wrongnote);
                ft.commit();
                frag_wrongnote = null;
                break;
            case 3:
                ft.remove(frag_recommendation);
                ft.commit();
                frag_recommendation = null;
                break;
            case 4:
                ft.remove(frag_login);
                ft.commit();
                frag_login = null;
                break;
        }
    }
}
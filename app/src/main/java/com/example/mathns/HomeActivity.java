package com.example.mathns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    // 2020-09-19 로그인 후 화면전환 수정
    private boolean loginBool = false; // 처음 로그인 값은 false


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Context context = this.getApplicationContext();
        final HomeActivity homeActivity = this;

        //바텀 네비게이션 뷰
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){ // 아이템 메뉴 아이디 가져옴
                    case R.id.action_bar_home:
                        // 2020-09-19 로그인 후 화면전환 수정
                        if(!loginBool) { // 로그인 후 동작
                            Toast.makeText(context, "로그인후에 이용 가능합니다.", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        setFrag(0);
                        break;
                    case R.id.action_bar_profile:
                        // 2020-09-19 로그인 후 화면전환 수정
                        if(!loginBool) { // 로그인 후 동작
                            Toast.makeText(context, "로그인후에 이용 가능합니다.", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        setFrag(1);
                        break;
                    case R.id.action_bar_wrongnote:
                        // 2020-09-19 로그인 후 화면전환 수정
                        if(!loginBool) { // 로그인 후 동작
                            Toast.makeText(context, "로그인후에 이용 가능합니다.", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        setFrag(2);
                        break;
                    case R.id.action_bar_recomendation:
                        // 2020-09-19 로그인 후 화면전환 수정
                        if(!loginBool) { // 로그인 후 동작
                            Toast.makeText(context, "로그인후에 이용 가능합니다.", Toast.LENGTH_LONG).show();
                            return false;
                        }
                        setFrag(3);
                        break;
                    case R.id.action_bar_login:
                        // 2020-09-19 로그인 후 화면전환 수정
                        if(loginBool) { // 로그인 후 동작
                            //Toast.makeText(context, "이미 로그인을 하셨습니다.", Toast.LENGTH_LONG).show();
                            new AlertDialog.Builder(homeActivity)
                                    .setTitle("로그아웃")
                                    .setMessage("이미 로그인을 하셨습니다.\n로그아웃 하시겠습니까?")
                                    //.setIcon(android.R.drawable.ic_menu_save)
                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            // 확인시 처리 로직
                                            Toast.makeText(context, "로그아웃 됐습니다.", Toast.LENGTH_SHORT).show();
                                            setLoginBool(false);
                                            bottomNavigationView.setSelectedItemId(R.id.action_bar_login);
                                        }})
                                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            // 취소시 처리 로직
                                            //Toast.makeText(context, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                                            setLoginBool(true);
                                        }})
                                    .show();
                            if(loginBool) {
                                return false;
                            } else {
                                break;
                            }
                        } else {
                            setFrag(4);
                        }
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

        // 2020-09-19 로그인 후 화면전환 수정
        //setFrag(4); // 첫 프래그먼트 화면지정
        bottomNavigationView.setSelectedItemId(R.id.action_bar_login);
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
                ft.replace(R.id.main_frame, frag_login);
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

    public BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }

    public void setBottomNavigationView(BottomNavigationView bottomNavigationView) {
        this.bottomNavigationView = bottomNavigationView;
    }

    public FragmentManager getFm() {
        return fm;
    }

    public void setFm(FragmentManager fm) {
        this.fm = fm;
    }

    public FragmentTransaction getFt() {
        return ft;
    }

    public void setFt(FragmentTransaction ft) {
        this.ft = ft;
    }

    public com.example.mathns.frag_home getFrag_home() {
        return frag_home;
    }

    public void setFrag_home(com.example.mathns.frag_home frag_home) {
        this.frag_home = frag_home;
    }

    public com.example.mathns.frag_profile getFrag_profile() {
        return frag_profile;
    }

    public void setFrag_profile(com.example.mathns.frag_profile frag_profile) {
        this.frag_profile = frag_profile;
    }

    public com.example.mathns.frag_wrongnote getFrag_wrongnote() {
        return frag_wrongnote;
    }

    public void setFrag_wrongnote(com.example.mathns.frag_wrongnote frag_wrongnote) {
        this.frag_wrongnote = frag_wrongnote;
    }

    public com.example.mathns.frag_recommendation getFrag_recommendation() {
        return frag_recommendation;
    }

    public void setFrag_recommendation(com.example.mathns.frag_recommendation frag_recommendation) {
        this.frag_recommendation = frag_recommendation;
    }

    public com.example.mathns.frag_login getFrag_login() {
        return frag_login;
    }

    public void setFrag_login(com.example.mathns.frag_login frag_login) {
        this.frag_login = frag_login;
    }

    public boolean isLoginBool() {
        return loginBool;
    }

    public void setLoginBool(boolean loginBool) {
        this.loginBool = loginBool;
    }

    public void setLogin(boolean flag) {
        loginBool = flag;
    }
}
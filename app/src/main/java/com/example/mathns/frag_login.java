package com.example.mathns;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.mathns.task.LoginTask;
import com.example.mathns.vo.User;

import java.util.concurrent.ExecutionException;

public class frag_login extends Fragment implements View.OnClickListener {

    private View view;

    private Button btnLogin;
    private Button btnSignUp;

    private EditText editID;
    private EditText editPassword;

    private String id;
    private String password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_login,container,false);  //xml 불러옴

        editID = (EditText) view.findViewById(R.id.editID);
        editPassword = (EditText) view.findViewById(R.id.editPassword);

        btnLogin = (Button)view.findViewById(R.id.btnLogin);
        btnSignUp = (Button)view.findViewById(R.id.btnSignUp);


        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:

                id = editID.getText().toString();
                password = editPassword.getText().toString();

                if(login(id,password)==1){

                    System.out.println("성공");
                    ((HomeActivity)getActivity()).delFrag(4);
                    ((HomeActivity)getActivity()).setFrag(0);
                }
                else if(login(id,password)==2){

                    System.out.println("비번 틀림");
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("알림");
                    builder.setMessage("비밀번호가 틀렸습니다.");
                    builder.setPositiveButton("ok",null);
                    builder.create().show();

                }else{

                    System.out.println("아이디 없음");
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("알림");
                    builder.setMessage("존재하지 않는 아이디입니다.");
                    builder.setPositiveButton("ok",null);
                    builder.create().show();
                }

                break;
            case R.id.btnSignUp:

                Intent intent = new Intent(getActivity(), JoinActivity.class);
                startActivity(intent);

                break;

        }
    }
    private int login(String userID,String userPassword){ //로그인 함수
        int returnBol = 1;
        User user = new User();
        user.setUserID(userID);
        user.setUserPassword(userPassword);
        try {
            // JSP와 통신
            String result = new LoginTask().execute( // 통신결과가 담김 (result에)
                    user.getUserID(), // 아래 파라미터 순서는 JoinTask sendmsg참고
                    user.getUserPassword()
            ).get().trim();

            Log.d("login 결과" , result);

            if("1".equals(result)) {
                returnBol = 1;
            }else if("2".equals(result)){
                returnBol = 2;
            }else{
                returnBol = 3;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("login 에러", e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("login 에러", e.toString());
        }

        return returnBol;
    }

}


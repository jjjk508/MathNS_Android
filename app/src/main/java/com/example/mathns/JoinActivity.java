package com.example.mathns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mathns.task.JoinTask;
import com.example.mathns.task.CheckTask;
import com.example.mathns.vo.User;

import java.util.concurrent.ExecutionException;

public class JoinActivity extends AppCompatActivity {

    private Button joinBtn;
    private Button checkBtn;
    private EditText joinID;
    private EditText joinPassword;
    private EditText joinName;
    private EditText joinEmail;
    private EditText joinNickName;

    private String ID;
    private String Password;
    private String Name;
    private String Email;
    private String NickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        checkBtn = findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ID = joinID.getText().toString();
                if(checkID(ID) == 1){
                    System.out.println("중복임"); // * 중복체크 알러트 뜨게 변경필요 *
                }else{
                    System.out.println("중복아님");
                }
            }

        });

        joinID = findViewById(R.id.joinID);
        joinPassword = findViewById(R.id.joinPassword);
        joinName = findViewById(R.id.joinName);
        joinEmail = findViewById(R.id.joinEmail);
        joinNickName = findViewById(R.id.joinNickName);

        joinBtn = findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = joinID.getText().toString();
                Password = joinPassword.getText().toString();
                Name = joinName.getText().toString();
                Email = joinEmail.getText().toString();
                NickName = joinNickName.getText().toString();
                User user = new User(ID,Password,Name,Email,NickName,0);
                join(user);

                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private int checkID(String userID){ //중복확인 함수
        int returnBol = 1;
        User user = new User();
        user.setUserID(userID);

        try{
            // JSP와 통신
            String result = new CheckTask().execute(
                    user.getUserID()
            ).get().trim();

            Log.d("check 결과",result);

            if("1".equals(result)){
                returnBol = 1;
            }else{
                returnBol = 2;
            }
        }catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("check 에러", e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("check 에러", e.toString());
        }

        return returnBol;
    }

    private boolean join(User user){ //회원가입 함수
        boolean returnBol = false;

        try {
            // JSP와 통신
            String result = new JoinTask().execute( // 통신결과가 담김 (result에)
                user.getUserID(), // 아래 파라미터 순서는 JoinTask sendmsg참고
                user.getUserPassword(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserNickname(),
                user.getUserLevel().toString()
            ).get().trim();

            Log.d("join 결과" , result);

            if("1".equals(result)) {
                returnBol = true;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("join 에러", e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("join 에러", e.toString());
        }

        return returnBol;
    }
}
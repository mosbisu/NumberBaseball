package com.kkr95.numberbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    Button btn;
    TextView tv;

    int com1, com2, com3;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
        et3= findViewById(R.id.et3);
        btn= findViewById(R.id.btn);
        tv= findViewById(R.id.tv);
        s= "";

        Random rnd= new Random();
        do {
            com1= rnd.nextInt(10);
            com2= rnd.nextInt(10);
            com3= rnd.nextInt(10);
        }
        while(com1==com2 || com1==com3 || com2==com3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int user1= Integer.parseInt(et1.getText().toString());
                int user2= Integer.parseInt(et2.getText().toString());
                int user3= Integer.parseInt(et3.getText().toString());
                int strike=0, ball=0;
                String str= "";

                if(user1 == com1) strike++;
                else if(user1 == com2 || user1 == com3) ball++;
                if(user2 == com2) strike++;
                else if(user2 == com1 || user2 == com3) ball++;
                if(user3 == com3) strike++;
                else if(user3 == com1 || user3 == com2) ball++;

                str= String.format("%d %d %d  : %d Strike, %d Ball\n", user1, user2, user3, strike, ball);
                s+= str;

                if(strike==3) s+=" 정답입니다.";
                tv.setText(s);

                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });
        tv.setMovementMethod(new ScrollingMovementMethod());

    }
}

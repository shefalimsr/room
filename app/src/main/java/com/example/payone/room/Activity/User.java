package com.example.payone.room.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.payone.room.R;
import com.example.payone.room.database.DatabaseManager;
import com.example.payone.room.database.entity.Lead;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class User extends AppCompatActivity {
    TextView name ;
    TextView number;
    Button next;
    Lead user;
    String one,two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        user= new Lead();

        name=(TextView)findViewById(R.id.name);
        number=(TextView)findViewById(R.id.number);
        next=(Button)findViewById(R.id.button);



        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                one = name.getText().toString() ;
                if(one.length()==0)
                    Log.d("testing","true");
                user.setName(one);

                two= " " + number.getText().toString();
                user.setMobile(two);

                    DatabaseManager.getInstance(getApplicationContext()).insertLead(user)
                            .subscribe(new CompletableObserver() {
                                @Override public void onSubscribe(Disposable d) {  }
                                @Override public void onComplete() { }
                                @Override public void onError(Throwable e) { }
                            });
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
package com.example.payone.room.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.payone.room.R;
import com.example.payone.room.adapters.LeadAdapter;
import com.example.payone.room.adapters.SingleData;
import com.example.payone.room.database.DatabaseManager;
import com.example.payone.room.database.entity.Lead;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    Button display;
    List<SingleData> ListAll = new ArrayList<SingleData>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(Button)findViewById(R.id.display);

        display.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // 1. get a reference to recyclerView
                recyclerView = (RecyclerView) findViewById(R.id.list);

                // this is data fro recycler view
                DatabaseManager.getInstance(getApplicationContext()).getAllEntries()
                        .subscribe(new Observer<Lead>() {
                            @Override public void onSubscribe(Disposable d) { }
                            @Override
                            public void onNext(Lead entry) {
                                SingleData sd=new SingleData(entry.getName(),entry.getMobile());
                                ListAll.add(sd);
                                LeadAdapter mAdapter = new LeadAdapter(ListAll);

                                // 4. set adapter
                                recyclerView.setAdapter(mAdapter);
                            }
                            @Override public void onError(Throwable e) { }
                            @Override public void onComplete() { }
                        });

                // 2. set layoutManger
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



                // 5. set item animator to DefaultAnimator
                recyclerView.setItemAnimator(new DefaultItemAnimator());



            }
        });


    }
}

package com.example.payone.room.database;

import android.content.Context;
import android.location.Location;

import com.example.payone.room.adapters.SingleData;
import com.example.payone.room.database.entity.Lead;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DatabaseManager {
    private Context context;

    public static DatabaseManager getInstance(Context context) {
        return new DatabaseManager(context);
    }

    private DatabaseManager(Context context) {
        this.context = context;
    }

    public Observable<Lead> getAllEntries() {
        return Observable.create(new ObservableOnSubscribe<Lead>() {
            @Override
            public void subscribe(ObservableEmitter<Lead> emitter) throws Exception {
                List<Lead> e = ApplicationDatabase.getInstance(context).leadDao().gelAll();
                for(Lead en : e) {
                    if(!emitter.isDisposed()) emitter.onNext(en);
                }
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Lead>> getListOfAllEntries() {
        return Observable.create(new ObservableOnSubscribe<List<Lead>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Lead>> emitter) throws Exception {
                List<Lead> e = ApplicationDatabase.getInstance(context).leadDao().gelAll();
                if(!emitter.isDisposed()) {
                    emitter.onNext(e);
                }
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

//    public Completable deleteAllEntries() {
//        return Completable.create(new CompletableOnSubscribe() {
//            @Override
//            public void subscribe(CompletableEmitter emitter) throws Exception {
//                ApplicationDatabase.getInstance(context).leadDao().deleteAll();
//                if(!emitter.isDisposed()) {
//                    emitter.onComplete();
//                }
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }

    public Completable insertLead(final Lead lead)
    {
        return  Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                Lead e = new Lead();
                e.setName(lead.getName());
                e.setMobile(lead.getMobile());
                ApplicationDatabase.getInstance(context).leadDao().insertSingle(e);
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    
}

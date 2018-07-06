package com.example.payone.room.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "leadData")
public class Lead {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;



    @ColumnInfo(name = "mobile")
    public String mobile;




    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }



    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}

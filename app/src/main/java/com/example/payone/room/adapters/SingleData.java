package com.example.payone.room.adapters;

import android.arch.persistence.room.ColumnInfo;

public class SingleData {

    public String name;
    public String mobile;

   public SingleData(String nm, String mob)
   {
       name=nm;
       mobile=mob;
   }



    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}

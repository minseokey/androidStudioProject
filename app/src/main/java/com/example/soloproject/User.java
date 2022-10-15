package com.example.soloproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User implements Parcelable {
    String userID;
    String userPassword;
    String userName;
    String userPhone;
    String userAddress;

    protected User(String userID,String userPassword,String userName,String userPhone,String userAddress){
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;

    }

    protected User(Parcel in) {
        userID = in.readString();
        userPassword = in.readString();
        userName = in.readString();
        userPhone = in.readString();
        userAddress = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userID);
        parcel.writeString(userPassword);
        parcel.writeString(userName);
        parcel.writeString(userPhone);
        parcel.writeString(userAddress);
    }

    public String getuserID() {
        return this.userID;
    }

    public String getuserPassword() {
        return this.userPassword;
    }

    public String getuserName() {
        return this.userName;
    }
}

class UserSet{
    static ArrayList<User> userSet = new ArrayList<>();
}

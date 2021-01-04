package com.finite.medspace_v1.Utils;

import android.content.Context;

import com.finite.medspace_v1.Model.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Global {
    public static Admin currentUser;

    public static Admin getCurrentUser() {
        return Global.currentUser;
    }

    public static void setCurrentUser(Admin currentUser) {
        Global.currentUser = currentUser;
    }

    public static String getDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(date);
    }

    public static boolean isGreaterDate(Date operate_date_1, Date operate_date_2) {
        return operate_date_1.getTime() > operate_date_2.getTime();
    }

    public static String randomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for(int i = 0; i < 20; i++){
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }


}

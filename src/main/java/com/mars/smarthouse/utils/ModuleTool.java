package com.mars.smarthouse.utils;

import com.mars.smarthouse.constant.ThemeList;
import javafx.scene.Parent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by worrywang on 2014/11/7.
 */
public class ModuleTool {
    public static void setTheme(Parent node,String theme,String font_levle){
        node.getStylesheets().clear();
        if(theme.equals(ThemeList.default_theme)){
            node.getStylesheets().add(ThemeList.default_theme_dir);
        }else{
            node.getStylesheets().add(ThemeList.default_theme_dir);
        }

        if(font_levle.equals(ThemeList.font_level_1)){
            node.getStylesheets().add(ThemeList.font_level_1_dir);
        }else if(font_levle.equals(ThemeList.font_level_2)){
            node.getStylesheets().add(ThemeList.font_level_2_dir);
        }else if(font_levle.equals(ThemeList.font_level_3)){
            node.getStylesheets().add(ThemeList.font_level_3_dir);
        }else if(font_levle.equals(ThemeList.font_level_4)){
            node.getStylesheets().add(ThemeList.font_level_4_dir);
        }else{

        }
    }

    public static  String getTime(){
        String result = null;
        Calendar calendar = Calendar.getInstance();;
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("EEE, yyyy MMM dd", Locale.CHINA);
        String currentTime = dateFm.format(date).toString();
        result = currentTime+" "+hours+":"+minutes+":"+seconds;
        return result;
    }

    public static String getDate(){
        String result = null;
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String currentTime = dateFm.format(date).toString();
        result = currentTime;
        return result;
    }
}

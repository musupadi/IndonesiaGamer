package com.destiny.indonesiagamer.Method;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Destiny {
    public String SmallDescription(String description){
        String Des = description;
        if (description.length() >= 100){
            Des = description.substring(0,100)+"...";
        }
        return Des;
    }
    public String Nilai(String nilai){
        int index = nilai.indexOf('/');
        String nilai_min = nilai.substring(0,index);
        String nilai_max = nilai.substring(index+1);
        double NILAI_MIN = Double.valueOf(nilai_min);
        double NILAI_MAX = Double.valueOf(nilai_max);
        double NILAI = NILAI_MIN/NILAI_MAX*100;
        DecimalFormat df = new DecimalFormat("#");
        String nilais = df.format(NILAI);
        return nilais;
    }
    public String AUTH_BASE_64(){
        String username = "destiny_pss_tk";
        String password = "45sq2355sqav139ewxza";

        String base = username+":"+password;

        String authHeader = "Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        return authHeader;
    }
    public String CheckerImageYoutube(String LinkYoutube,String Kabar){
        String link= BASE_URL()+Kabar;
        if (!LinkYoutube.equals("")){
            link = AutoTumbnailYoutube(GetIDYoutube(LinkYoutube));
        }
        return link;
    }
    public String AutoTumbnailYoutube(String code){
        String replace = "https://img.youtube.com/vi/"+code+"/mqdefault.jpg";
        return replace;
    }
    public String GetIDYoutube(String link){
        String replace1 = link.replace("https://www.youtube.com/watch?v=","");
        return replace1;
    }
    public String FajarNangis(String Jessica){
        String replace = Jessica.replace("&#39;","'");
        return replace;
    }
    public static String getThisDayDB(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Day = dateFormat1.format(date);
        String month = dateFormat2.format(date);
        String Year = dateFormat3.format(date);
        String dates = Year+"-"+month+"-"+Day;
        return dates;
    }
    public String FilterTextToJava(String text){
        String replaces = text.replace("</p>\\r\\n<ol>\\r\\n<li>","");
        String replace1 = replaces.replace("<p>","");
        String replace2 = replace1.replace("</p>","");
        String replace3 = replace2.replace("<span style=\"color: #ff6600;\">","");
        String replace4 = replace3.replace("</span>","");
        String replace5 = replace4.replace("<strong>","");
        String replace6 = replace5.replace("</strong>","");
        String replace7 = replace6.replace("<ol>","");
        String replace8 = replace7.replace("</ol>","");
        String replace9 = replace8.replace("<li>","");
        String replace10 = replace9.replace("</li>","");
        String replace11 = replace10.replace("<ul>","");
        String replace12 = replace11.replace("</ul>","");
        String replace13 = replace12.replace("\\n\\n","\\n");
        String replace14 = replace13.replace("<div>","");
        String replace15 = replace14.replace("</div>","");
        String replace16 = replace15.replace("<p>1.","");
        String replace17 = replace16.replace("<p style=\\\"text-align: left;\\\">","");
        String replace18 = replace17.replace("<a href=","");
        return replace18;
    }

    public void Toast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public String BASE_URL(){
        String BASE_URL = "http://www.indonesiagamer.rumahcantikratu.com/img/game/";
        return BASE_URL;
    }
    public String AUTH(String auth){
        String authHeader = "Bearer "+auth;
        return authHeader;
    }
    private void initOPPO(Context ctx) {
        try {

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity"));
            ctx.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
            try {

                Intent intent = new Intent("action.coloros.safecenter.FloatWindowListActivity");
                intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.floatwindow.FloatWindowListActivity"));
                ctx.startActivity(intent);
            } catch (Exception ee) {

                ee.printStackTrace();
                try{

                    Intent i = new Intent("com.coloros.safecenter");
                    i.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                    ctx.startActivity(i);
                }catch (Exception e1){

                    e1.printStackTrace();
                }
            }

        }
    }
    private static void autoLaunchVivo(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.secure",
                    "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"));
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                context.startActivity(intent);
            } catch (Exception ex) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.iqoo.secure",
                            "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                    context.startActivity(intent);
                } catch (Exception exx) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getToday(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        String today = dayName(thisDay,"dd/MM/yyyy");
        String HariIni = "Senin";
        if(today.equals("Monday")){
            HariIni = "Senin";
        }else if(today.equals("Tuesday")){
            HariIni = "Selasa";
        }else if(today.equals("Wednesday")){
            HariIni = "Rabu";
        }else if(today.equals("Thursday")){
            HariIni = "Kamis";
        }else if(today.equals("Friday")){
            HariIni = "Jumat";
        }else if(today.equals("Saturday")){
            HariIni = "Sabtu";
        }else if(today.equals("Sunday")){
            HariIni = "Minggu";
        }
        return HariIni;
    }
    public  String DateChanges(String year,String month,String day){
        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        String Dates = day+"-"+MONTH+"-"+year;
        return Dates;
    }
    public String MagicDateChange(String dates){
        String result = "";
        String year = dates.substring(0,4);
        String month = dates.substring(5,7);
        String day = dates.substring(8,10);

        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        result = day+"-"+MONTH+"-"+year;
        return result;

    }

    public static String Today(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dates = dateFormat3.format(date);
        return dates;
    }
    public static String thisDay(){
        DateFormat dateFormat1 = new SimpleDateFormat("dd");
        DateFormat dateFormat2 = new SimpleDateFormat("MM");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Day = dateFormat1.format(date);
        String month = dateFormat2.format(date);
        String Year = dateFormat3.format(date);
        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        return Day+"-"+MONTH+"-"+Year;
    }
    public static String dayName(String inputDate, String format){
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }
}

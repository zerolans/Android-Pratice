package com.example.swordlibrary.java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.swordlibrary.java.androidapi.TelephonyManagerJavaUtil;
import com.example.swordlibrary.R;

import java.util.Locale;


public class MainActivity2 extends AppCompatActivity {
    String text2 = "";
    TextView textView = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.info);
    }

    //打印 Local 信息
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public String getLocal() {
        Locale locale = Locale.getDefault();
        return "language: " + locale.getLanguage() + "\nCountry: " + locale.getCountry() + "\n languageTag: " + locale.toLanguageTag() + "\ndisplayCountry: " + locale.getDisplayCountry() + "\ngetDisplayLanguage: " + locale.getDisplayLanguage() + "\ngetDisplayName: " + locale.getDisplayName() + "\ngetDisplayScript: " + locale.getDisplayScript() + "\ngetDisplayVariant: " + locale.getDisplayVariant() + "\ngetISO3Country: " + locale.getISO3Country() + "\ngetISO3Language: " + locale.getISO3Language() + "\ngetScript: " + locale.getScript() + "\ngetVariant: " + locale.getVariant();

    }

    //模拟器检测测试
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void EmulatorCheckTest() {
        String text = "getOS: " + (EmulatorCheck.mayOnEmulator(this) ? "1" : "3") ;
        text2 = EmulatorCheck.debug(this);

        text = text + "\n\n " + text2;
    }

    //TelephonyManager 信息打印测试
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void TelephonyManagerJavaUtiltest() {
        TelephonyManagerJavaUtil.checkPermission(this);
        TelephonyManagerJavaUtil.debug(this);
    }

    //获取 Android 设备所在地区
    public void getIpAddress() {

        //1. 通过 NetworkInterface 获取 IP 地址，可能会获取不到
        //2. 通过 TelephonyManager 获取类似 MCC 或者 SIM 卡运营商所在地区的国家/地区代码
        //3. 通过 WifiManager 获取 IP 地址
        //4. 由服务器端下发 IP 地址，通过 IpSeekUtils 获取 IP 地址所在地区/国家
        //5. 访问外部连接
        //      http://pv.sohu.com/cityjson
        //      http://pv.sohu.com/cityjson?ie=utf-8
        //      http://ip.chinaz.com/getip.aspx


        Log.d("TAG", "shell 获取外网 ip：" + ShellAdbUtil.execShellCommand(false, "curl ifconfig.me").getSuccessString());
    }


}
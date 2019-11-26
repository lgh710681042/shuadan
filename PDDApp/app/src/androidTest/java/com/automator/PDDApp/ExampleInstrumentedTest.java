package com.automator.PDDApp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private String mPackageName="com.xunmeng.pinduoduo";
    private String activity_path = "com.xunmeng.pinduoduo.ui.activity.MainFrameActivity";
    private UiDevice mDevice = null;

    @Test
    public void useAppContext() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//
//        assertEquals("com.automator.PDDApp", appContext.getPackageName());
        mDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());//获取设备用例
        try {
            if(!mDevice.isScreenOn()){
                mDevice.wakeUp();//唤醒屏幕
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        startAPP(mPackageName);  //启动app
    }

    private void startAPP(String sPackageName){
        Context mContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        Intent myIntent = null;//mContext.getPackageManager().getLaunchIntentForPackage(sPackageName);  //通过Intent启动app
        if(myIntent != null)
        {
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            mContext.startActivity(myIntent);

            //等待启动
            mDevice.wait(Until.hasObject(By.pkg("com.xunmeng.pinduoduo").depth(0)), 5000);
        }
        else
        {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//可选
            ComponentName comp = new ComponentName(sPackageName,activity_path);
            intent.setComponent(comp);
            mContext.startActivity(intent);
        }
    }
}

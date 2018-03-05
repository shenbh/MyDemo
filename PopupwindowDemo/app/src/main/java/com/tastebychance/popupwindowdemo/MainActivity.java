package com.tastebychance.popupwindowdemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btn_show_up;
    private Button btn_show_down;
    private LayoutInflater mInflater;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mInflater = getLayoutInflater();

        btn_show_up = (Button) findViewById(R.id.btn_show_up);
        btn_show_down = (Button) findViewById(R.id.btn_show_down);
        btn_show_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*ArrayList<String> titles = new ArrayList<String>();
                titles.add("复制");
                titles.add("删除");*/

                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("dishname", "秘制香煎龙利鱼套餐");
                map1.put("num", "1");
                map1.put("price", "26");
                Constants.orderedDishes.add(map1);

                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("dishname", "黄金尾虾营养餐");
                map2.put("num", "1");
                map2.put("price", "33");
                Constants.orderedDishes.add(map2);



                View view = mInflater.inflate(R.layout.layout_popupwindow, null);
                PopUpwindowLayout popUpwindowLayout = (PopUpwindowLayout) view.findViewById(R.id.llayout_popupwindow);
                popUpwindowLayout.initViews(mContext, Constants.orderedDishes, false);


                final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int popupWidth = view.getMeasuredWidth();
                int popupHeight = view.getMeasuredHeight();
                int[] location = new int[2];
                // 允许点击外部消失
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                // 获得位置
                v.getLocationOnScreen(location);
                popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);



                popUpwindowLayout.setClickListener(new PopUpwindowLayout.OnClickCallback() {

                    @Override
                    public void onItemClick(LinearLayout parentView, int size, int index) {
                        switch (index) {
                            case 0:
                                Toast.makeText(mContext, "复制", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });

            }
        });
        /*btn_show_down.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                ArrayList<String> titles = new ArrayList<String>();
                titles.add("复制");
                titles.add("删除");

                View view = mInflater.inflate(R.layout.layout_popupwindow, null);
                PopUpwindowLayout popUpwindowLayout = (PopUpwindowLayout) view.findViewById(R.id.llayout_popupwindow);
                popUpwindowLayout.initViews(mContext, titles, false);
                final PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int popupWidth = view.getMeasuredWidth();
                int popupHeight = view.getMeasuredHeight();
                int[] location = new int[2];
                // 允许点击外部消失
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                // 获得位置
                v.getLocationOnScreen(location);
                popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//				popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);
                popupWindow.showAsDropDown(v);
                popUpwindowLayout.setClickListener(new PopUpwindowLayout.OnClickCallback() {

                    @Override
                    public void onItemClick(LinearLayout parentView, int size, int index) {
                        switch (index) {
                            case 0:
                                Toast.makeText(mContext, "复制", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });


            }
        });*/
    }
}

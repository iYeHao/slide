package com.example.slidecark;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.slidecark.R;
import com.example.flingslide.FlingAdapterView;

import java.util.ArrayList;
//import java.util.List;

public class MainActivity extends Activity {

    private ArrayList<CardMode> al;
   // private ArrayList<ImageView> iv;
    //定义一个cardmode的数组al
    private CardAdapter adapter;
    //定义一个card的适配器
    private int i;
    //定义滑动卡片的容器
    private FlingAdapterView flingContainer;
    //定义一个string类型的数组
   // private List<List<String>> list = new ArrayList<>();
    //定义下面的左右喜欢喝不喜欢的图片
    private ImageView left, right,music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //定义左边和右边的图片，和监听
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        music = (ImageView) findViewById(R.id.iv_card_flag6);
        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                left();
            }
        });
        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                right();
            }
        });
        music.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                playmusic();
            }
        });
        //iv=new ArrayList<>();
       // iv.add(R.drawable.picture_fisrt);
        //初始化al数组
    
        al = new ArrayList<CardMode>();
        al.add(new CardMode("胡欣语", 21,R.drawable.picture_fisrt,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("Norway", 21,R.drawable.picture_second,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("王清玉", 18, R.drawable.picture_third,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试1", 21, R.drawable.picture_four,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试2", 21, R.drawable.picture_five,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试3", 21, R.drawable.picture_six,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试4", 21, R.drawable.picture_seven,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试5", 21, R.drawable.picture_eight,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试6", 21, R.drawable.picture_nine,"信息科学与技术","中文","英文","男","学五食堂"));
        al.add(new CardMode("测试7", 21, R.drawable.picture_ten,"信息科学与技术","中文","英文","男","学五食堂"));
        //初始化arryAapter
        //ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);
        adapter = new CardAdapter(this, al);
        //定义一个主界面
        flingContainer = (FlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(adapter);
        
        flingContainer.setFlingListener(new FlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                al.remove(0);
                adapter.notifyDataSetChanged();
            }
          @Override
         public void onLeftCardExit(Object dataObject) {
                makeToast(MainActivity.this, "不喜欢");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(MainActivity.this, "喜欢");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                al.add(new CardMode("胡欣语", 21,R.drawable.picture_fisrt,"信息科学与技术","中文","英文","男","学五食堂"));
                adapter.notifyDataSetChanged();
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                try {
                    View view = flingContainer.getSelectedView();
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        flingContainer.setOnItemClickListener(new FlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(MainActivity.this, "点击图片");
            }
        });

    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    public void right() {
        flingContainer.getTopCardListener().selectRight();
    }

    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }
    public void playmusic() {
        
    }

}

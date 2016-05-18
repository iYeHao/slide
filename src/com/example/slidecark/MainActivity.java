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
    //����һ��cardmode������al
    private CardAdapter adapter;
    //����һ��card��������
    private int i;
    //���廬����Ƭ������
    private FlingAdapterView flingContainer;
    //����һ��string���͵�����
   // private List<List<String>> list = new ArrayList<>();
    //�������������ϲ���Ȳ�ϲ����ͼƬ
    private ImageView left, right,music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //������ߺ��ұߵ�ͼƬ���ͼ���
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
        //��ʼ��al����
    
        al = new ArrayList<CardMode>();
        al.add(new CardMode("������", 21,R.drawable.picture_fisrt,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("Norway", 21,R.drawable.picture_second,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("������", 18, R.drawable.picture_third,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����1", 21, R.drawable.picture_four,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����2", 21, R.drawable.picture_five,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����3", 21, R.drawable.picture_six,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����4", 21, R.drawable.picture_seven,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����5", 21, R.drawable.picture_eight,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����6", 21, R.drawable.picture_nine,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        al.add(new CardMode("����7", 21, R.drawable.picture_ten,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
        //��ʼ��arryAapter
        //ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);
        adapter = new CardAdapter(this, al);
        //����һ��������
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
                makeToast(MainActivity.this, "��ϲ��");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(MainActivity.this, "ϲ��");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                al.add(new CardMode("������", 21,R.drawable.picture_fisrt,"��Ϣ��ѧ�뼼��","����","Ӣ��","��","ѧ��ʳ��"));
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
                makeToast(MainActivity.this, "���ͼƬ");
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

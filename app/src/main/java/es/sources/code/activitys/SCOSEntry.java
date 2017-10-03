package es.sources.code.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import code.source.es.sosc.R;

public class SCOSEntry extends AppCompatActivity {
    private static final String MAIN_SCREEN_ACTION = "scos.intent.action.SCOSMAIN";
    private Button mTest;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        mView = findViewById(R.id.view);
        mTest = (Button)findViewById(R.id.test);
        setListeners();
    }
    /**
    * @Description ： 为控件添加事件监听
    * @author ： zhiman in 2017/10/2 14:50 mail-zhimanma@gmail.com
    */
    private void setListeners() {
        //监听屏幕滑动
        mView.setOnTouchListener(new View.OnTouchListener() {
            float posX1 = 0;
            float posX2 = 0;
            float posY1 = 0;
            float posY2 = 0;
            float detaX = 0;
            float detaY = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        posX1 = event.getX();
                        posY1 = event.getY();
                        Toast.makeText(SCOSEntry.this,"按下",Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        posX2 = event.getX();
                        posY2 = event.getY();
                        //Toast.makeText(SCOSEntry.this,"移动",Toast.LENGTH_SHORT).show();
                       break;
                    case MotionEvent.ACTION_UP:
                        detaX = posX2 - posX1;
                        detaY = posY2 - posY1;
                        //斜率在-1到1之间 滑动距离大于25 自右向左滑动
                        if((detaX < 0)&&(Math.abs(detaX) > 25)
                                &&(Math.abs(detaY/detaX)) < 1) {
                            Intent intent = new Intent(MAIN_SCREEN_ACTION);
                            intent.putExtra("test","from SOSCEntry");
                            startActivity(intent);
                            Toast.makeText(SCOSEntry.this,"跳转",Toast.LENGTH_LONG).show();
                            //Toast.makeText(SCOSEntry.this,detaX+"移动"+detaY,Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return true;
            }
        });
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MAIN_SCREEN_ACTION);
//                intent.putExtra("test","from SOSCEntry");
//                startActivity(intent);
//                Toast.makeText(SCOSEntry.this,"跳转",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SCOSEntry.this,LoginOrRegister.class);
                startActivity(intent);
            }
        });
    }
}

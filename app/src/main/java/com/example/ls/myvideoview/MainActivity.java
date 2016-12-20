package com.example.ls.myvideoview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private  CustomVideoView customVideoView;
    private Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        customVideoView = (CustomVideoView) findViewById(R.id.customVV);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        //加载路径
//        customVideoView.setVideoURI(Uri.parse("http://baidu.boosj.com/watch/01909434033952848915.html?page=videoMultiNeed"));
        customVideoView.setVideoPath("android.resource://" + getApplication().getPackageName() + "/" + R.raw.welcome);
//        customVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.media));
        //播放
        customVideoView.start();
        //循环播放
//        customVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                customVideoView.start();
//            }
//        });




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                Toast.makeText(this,"进入了主页",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

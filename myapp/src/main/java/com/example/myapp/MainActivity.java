package com.example.myapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.myapp.fragment.Collect_Fragment;
import com.example.myapp.fragment.Frist_Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 首页
     */
    private TextView mTv;
    private Toolbar mTool;
    private FrameLayout mFram;
    /**
     * 首
     */
    private Button mBt1;
    /**
     * 收
     */
    private Button mBt2;
    private Frist_Fragment frist;
    private Collect_Fragment collect;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTool();
        initFrag();
    }

    private void initFrag() {
        fm = getSupportFragmentManager();
        final FragmentTransaction tran = fm.beginTransaction();
        frist = new Frist_Fragment();
        collect = new Collect_Fragment();
        tran.add(R.id.Fram,frist);
        tran.add(R.id.Fram,collect);
        tran.show(frist);
        tran.hide(collect);
        tran.commit();

    }

    private void initTool() {
        mTool.setTitle("");
        setSupportActionBar(mTool);
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTool = (Toolbar) findViewById(R.id.Tool);
        mFram = (FrameLayout) findViewById(R.id.Fram);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(this);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt1:
                final FragmentTransaction t1 = fm.beginTransaction();
                t1.hide(frist);
                t1.hide(collect);
                t1.commit();
                break;
            case R.id.bt2:
                final FragmentTransaction t2 = fm.beginTransaction();
                t2.show(collect);
                t2.hide(frist);
                t2.commit();
                break;
        }
    }
}

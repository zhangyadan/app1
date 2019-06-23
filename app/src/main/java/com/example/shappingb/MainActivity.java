package com.example.shappingb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shappingb.fragments.Celloct_Fragment;
import com.example.shappingb.fragments.Frist_Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * 首页
     */
    private TextView mTv;
    private Toolbar mTool;
    private TabLayout mTable;
    private FragmentManager manager;
    private Frist_Fragment frist;
    private Celloct_Fragment celloct;
    private FrameLayout mFram;
    /**
     * 首页
     */
    private Button mFrist;
    /**
     * 收藏
     */
    private Button mCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTool();
        initFrag();

    }

    private void initFrag() {
        manager = getSupportFragmentManager();
        final FragmentTransaction tran = manager.beginTransaction();
        frist = new Frist_Fragment();
        celloct = new Celloct_Fragment();
        tran.add(R.id.Fram, frist);
        tran.add(R.id.Fram, celloct);
        tran.show(frist);
        tran.hide(celloct);
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
        mFrist = (Button) findViewById(R.id.frist);
        mFrist.setOnClickListener(this);
        mCollect = (Button) findViewById(R.id.collect);
        mCollect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.frist:
                final FragmentTransaction tran1 = manager.beginTransaction();
                tran1.show(frist);
                tran1.hide(celloct);
                tran1.commit();
                break;
            case R.id.collect:
                final FragmentTransaction tran2 = manager.beginTransaction();
                tran2.show(celloct);
                tran2.hide(frist);
                tran2.commit();
                break;
        }
    }
}

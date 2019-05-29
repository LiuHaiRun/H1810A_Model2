package com.example.liuhairui.day01_text02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.liuhairui.day01_text02.adapter.MyAdapter;
import com.example.liuhairui.day01_text02.bean.Student;
import com.example.liuhairui.day01_text02.db.DBUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mXrv;
    private ArrayList<Student> mStudents;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
       //数据库初始化20条数据
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Student student = new Student(Long.valueOf(i), "小明" + i, 12 + i);
            list.add(student);
        }
        //添加到数据库
        DBUtils.getInstance().insertAll(list);
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mStudents = new ArrayList<>();
        //查询数据库
        List<Student> students = DBUtils.getInstance().showAll();
        mStudents.addAll(students);
        //布局管理器
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        //适配器
        mMyAdapter = new MyAdapter(this, mStudents);
        mXrv.setAdapter(mMyAdapter);
    }
}

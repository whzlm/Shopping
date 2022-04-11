package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.shoping.bcar.frag.BcarFragment;
import com.example.shoping.discover.frag.DiscoverFragment;
import com.example.shoping.home.frag.HomeFragment;
import com.example.shoping.type.frag.TypeFragment;
import com.example.shoping.usr.frag.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private List<Fragment> frags;
    private int currentFragIndex;
    private int nowFragIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rgroup);
        frags = initFrag();
        radioChecked();
        //设置默认显示首页布局
        radioGroup.check(R.id.radio_index);

    }

    //点击导航时触发---切换fragment
    public void radioChecked(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_index:
                        currentFragIndex = 0;
                        break;
                    case R.id.radio_type:
                        currentFragIndex = 1;
                        break;
                    case R.id.radio_discover:
                        currentFragIndex = 2;
                        break;
                    case R.id.radio_buycar:
                        currentFragIndex = 3;
                        break;
                    case R.id.radio_user:
                        currentFragIndex = 4;
                        break;
                }
                if(nowFragIndex != currentFragIndex) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_position, frags.get(currentFragIndex)).commit();
                    nowFragIndex = currentFragIndex;
                }
            }
        });
    }


    public List<Fragment> initFrag(){
        List<Fragment> frags = new ArrayList<Fragment>();
        HomeFragment homeFragment = new HomeFragment();
        TypeFragment typeFragment = new TypeFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        BcarFragment bcarFragment = new BcarFragment();
        UserFragment userFragment = new UserFragment();

        frags.add(homeFragment);
        frags.add(typeFragment);
        frags.add(discoverFragment);
        frags.add(bcarFragment);
        frags.add(userFragment);

        return frags;
    }

}
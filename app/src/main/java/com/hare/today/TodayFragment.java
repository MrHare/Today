package com.hare.today;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by zhouanyuan on 27/10/2017.
 */

public class TodayFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_today, container, false);
        init();
        return rootView;
    }
    private void init(){
        TextView date = (TextView)rootView.findViewById(R.id.date_textView);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd");
        date.setText(simpleDateFormat.format(new java.util.Date()));

        ListView listView = (ListView)rootView.findViewById(R.id.today_textView);

    }

    //get the today's list
    public void getToday(){

    }
}




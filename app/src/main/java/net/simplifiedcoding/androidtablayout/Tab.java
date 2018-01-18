package net.simplifiedcoding.androidtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab extends Fragment {
    int position;
    //Overriden method onCreateView
    public static Tab newInstance(int position){
        Tab result = new Tab();
        Bundle args = new Bundle();
        args.putInt("put_int",position);

        result.setArguments(args);
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View result = inflater.inflate(R.layout.tab, container, false);
        TextView tmp = (TextView) result.findViewById(R.id.textView) ;
        tmp.setText(String.valueOf(getArguments().getInt("put_int")));
        return result;
    }
}

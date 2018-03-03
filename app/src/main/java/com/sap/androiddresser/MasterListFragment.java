package com.sap.androiddresser;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;
    public MasterListFragment() {
        // Required empty public constructor
    }

    public interface OnImageClickListener{
        void OnImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback=(OnImageClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement on ImageClicklistener");}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = (GridView)rootView.findViewById(R.id.gridview);




        gridView.setAdapter(new ImageAdapter(getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.OnImageSelected(i);
            }
        });

        return rootView;
    }

}

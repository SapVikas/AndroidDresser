package com.sap.androiddresser;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView =(ImageView) rootView.findViewById(R.id.body_part_imageview);
        if (mImageIds!=null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex<mImageIds.size()-1){
                mListIndex++;
                    }else {
                        mListIndex=0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));

                }
            });
        }else{
            Log.v("android robot","doesnt have any images");
        }
        return rootView;
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds=imageIds;
    }
    public void setListIndex(int index){
        mListIndex= index;
    }


}

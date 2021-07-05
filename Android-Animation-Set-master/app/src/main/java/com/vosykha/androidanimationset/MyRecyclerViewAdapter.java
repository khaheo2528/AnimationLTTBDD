package com.vosykha.androidanimationset;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vosykha.drawableanimation.DrawableAnimationActivity;
import com.vosykha.propertyanimation.PropertyAnimationActivity;
import com.vosykha.revealanimation.RevealAnimationActivity;
import com.vosykha.rippleanimation.TouchFeedbackActivity;
import com.vosykha.stateanimation.StateAnimationActivity;
import com.vosykha.transitionanimation.TransitionAnimationActivity;
import com.vosykha.vectoranimation.VectorAnimationActivity;
import com.vosykha.viewanimation.ViewAnimationActivity;

/*******************************************************************
 Created by Zed, Mai & Kaiwin
 Time:28/06/2021
 Email address:5951071041@st.utc2.edu.vn
 *******************************************************************/


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final int[] mIntArray;
    private final String[] mStringArray;
    Context mContext;

    public MyRecyclerViewAdapter(Context context, int[] intArray, String[] stringArray) {
        mContext = context;
        mIntArray = intArray;
        mStringArray = stringArray;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemNameTv.setText(mStringArray[position]);

        Uri uri = Uri.parse("res://" + mContext.getPackageName() + "/" + mIntArray[position]);
        DraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        holder.itemImg.setController(build);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, ViewAnimationActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, DrawableAnimationActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, PropertyAnimationActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, TouchFeedbackActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, RevealAnimationActivity.class));
                        break;
                    case 5:
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(((MainActivity) mContext), null);
                        Intent intent = new Intent(mContext, TransitionAnimationActivity.class);
                        mContext.startActivity(intent, activityOptionsCompat.toBundle());
                        break;
                    case 6:
                        mContext.startActivity(new Intent(mContext, StateAnimationActivity.class));
                        break;
                    case 7:
                        mContext.startActivity(new Intent(mContext, VectorAnimationActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStringArray != null ? mStringArray.length : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView itemNameTv;
        SimpleDraweeView itemImg;

        ViewHolder(View view) {
            super(view);
            itemView = view.findViewById(R.id.view_content);
            itemImg = view.findViewById(R.id.img_item);
            itemNameTv = view.findViewById(R.id.tv_item);
        }
    }
}

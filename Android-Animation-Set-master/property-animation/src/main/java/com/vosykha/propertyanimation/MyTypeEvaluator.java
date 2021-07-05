package com.vosykha.propertyanimation;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

/*******************************************************************
 Created by Zed, Mai & Kaiwin
 Time:28/06/2021
 Email address:5951071041@st.utc2.edu.vn
 *******************************************************************/


public class MyTypeEvaluator implements TypeEvaluator<PropertyBean> {
    ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    public PropertyBean evaluate(float fraction, PropertyBean startPropertyBean, PropertyBean endPropertyBean) {
//        float currentColor = startPropertyBean.getBackgroundColor() + (endPropertyBean.getBackgroundColor() - startPropertyBean.getBackgroundColor()) * fraction;
        int currentColor = (int) mArgbEvaluator.evaluate(fraction, startPropertyBean.getBackgroundColor(), endPropertyBean.getBackgroundColor());
        float currentRotationX = startPropertyBean.getRotationX() + (endPropertyBean.getRotationX() - startPropertyBean.getRotationX()) * fraction;
        float currentSize = startPropertyBean.getSize() + (endPropertyBean.getSize() - startPropertyBean.getSize()) * fraction;
        return new PropertyBean((int) currentColor, currentRotationX, currentSize);
    }
}

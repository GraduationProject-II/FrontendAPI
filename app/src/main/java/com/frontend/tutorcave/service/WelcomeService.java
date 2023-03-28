package com.frontend.tutorcave.service;

import android.animation.ArgbEvaluator;
import android.content.Context;

import androidx.viewpager.widget.ViewPager;

import com.frontend.tutorcave.adapter.WelcomeAdapter;
import com.frontend.tutorcave.repository.WelcomeRepository;
import com.frontend.tutorcave.util.SelectionUtil;

import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class WelcomeService implements WelcomeRepository {

    public WelcomeService() {
        // required empty public constructor
    }

    private final ArgbEvaluator evaluator = new ArgbEvaluator();

    @Override
    public void redirect(final Context context, int cardPosition, List<Class<?>> classOptions) {
        context.startActivity(
                SelectionUtil.cardSelection(context, cardPosition, classOptions)
        );
    }

    @Override
    public void setCardBackground(
            ViewPager viewPager,
            WelcomeAdapter adapter,
            int position,
            float positionOffSet,
            Integer[] colors
    ) {
        if (isPosition(position, adapter.getCount()-1, colors.length-1)) {
            viewPager.setBackgroundColor(
                    (Integer) evaluator.evaluate(positionOffSet, colors[position], colors[position+1])
            );
        }
        else viewPager.setBackgroundColor(colors[colors.length-1]);
    }

    private boolean isPosition(int position, int count, int length) {
        return position < count && position < length;
    }
}
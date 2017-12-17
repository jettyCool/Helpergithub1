package com.example.admin.helper.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Admin on 11/4/2017.
 */


public class FontManager {

    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "OpenSans-Regular.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}
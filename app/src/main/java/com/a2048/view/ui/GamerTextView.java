package com.a2048.view.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.a2048.R;


/**
 * Created by nxf44096 on 7/7/2018.
 */

@SuppressLint("AppCompatCustomView")
public class GamerTextView extends TextView {
    private TypeFactory mFontFactory;

    public GamerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public GamerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    public GamerTextView(Context context) {
        super(context);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {


        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.gameText,
                0, 0);
        int typefaceType;
        try {
            typefaceType = array.getInteger(R.styleable.gameText_gamefontStyle, 0);
        } finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            setTypeface(getTypeFace(typefaceType));
        }

    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(getContext());

        switch (type) {
            case 0:
                return mFontFactory.mCALIBRI;

            case 1:
                return mFontFactory.mCALIBRI_BOLD;

            case 2:
                return mFontFactory.mCALIBRI_ITALIC;

            case 3:
                return mFontFactory.mCALIBRI_ITALIC_Z;

            default:
                return mFontFactory.mCALIBRI;
        }
    }

    public class TypeFactory {

        Typeface mCALIBRI;
        Typeface mCALIBRI_BOLD;
        Typeface mCALIBRI_ITALIC;
        Typeface mCALIBRI_ITALIC_Z;
        private String CALIBRI = "Calibri.ttf";
        private String CALIBRI_BOLD = "CALIBRIB.TTF";
        private String CALIBRI_ITALIC = "CALIBRII.TTF";
        private String CALIBRI_ITALIC_Z = "CALIBRIZ.TTF";

        public TypeFactory(Context context) {
            mCALIBRI = Typeface.createFromAsset(context.getAssets(), CALIBRI);
            mCALIBRI_BOLD = Typeface.createFromAsset(context.getAssets(), CALIBRI_BOLD);
            mCALIBRI_ITALIC = Typeface.createFromAsset(context.getAssets(), CALIBRI_ITALIC);
            mCALIBRI_ITALIC_Z = Typeface.createFromAsset(context.getAssets(), CALIBRI_ITALIC_Z);
        }

    }


}

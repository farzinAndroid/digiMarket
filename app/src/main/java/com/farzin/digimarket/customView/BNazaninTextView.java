package com.farzin.digimarket.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.farzin.digimarket.utils.Constants;

public class BNazaninTextView extends AppCompatTextView {
    public BNazaninTextView(@NonNull Context context) {
        super(context);
        setFonts(context);
    }



    public BNazaninTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFonts(context);
    }

    public BNazaninTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFonts(context);
    }
    private void setFonts(@NonNull Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), Constants.B_NAZANIN_FONT);
        setTypeface(typeface);
    }
}

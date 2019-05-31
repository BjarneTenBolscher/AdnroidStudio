package com.example.project.CompoundView;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.project.R;

public class Selecter_View extends ConstraintLayout {

    private RadioButton vegetableButton;
    private RadioButton fruitButton;
    private RadioButton potatoButton;
    private Spinner typeChoser;

    public Selecter_View(Context context) {
        super(context);
        init();
    }

    public Selecter_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Selecter_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.selecter_view, this);

        vegetableButton = findViewById(R.id.Vegetable);
        fruitButton = findViewById(R.id.Fruit);
        potatoButton = findViewById(R.id.Potato);

        typeChoser = findViewById(R.id.typeSpinner);
    }

}

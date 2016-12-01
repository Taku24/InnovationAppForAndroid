package innovation.taku.com.inovationapp.Component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

/**
 * Created by takusemba on 2016/11/30.
 */

public class HideKeyboardLayout extends LinearLayout {

    private Context mContext;

    public HideKeyboardLayout(Context context) {
        super(context);
        mContext = context;
    }

    public HideKeyboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public HideKeyboardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        requestFocus();
        return false;
    }
}

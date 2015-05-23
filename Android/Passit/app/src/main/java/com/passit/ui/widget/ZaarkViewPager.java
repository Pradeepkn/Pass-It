
package com.passit.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Custom view pager class to enable and disable the touch events.
 * 
 * @author muthukrishnan
 */
public class ZaarkViewPager extends ViewPager {

    private boolean enabled;

    public ZaarkViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    /**
     * To enable page swiping or touch interaction.
     *
     * @param enabled true-> enable swiping or touch interaction, false otherwise.
     */
    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

package com.example.jiangjr.basic.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;

import com.example.jiangjr.basic.R;


/**
 * Created by Jiangjr on 2015/10/20.
 */
public class BaseDialog extends Dialog {

    protected BaseDialog(Context context) {
        this(context, R.style.Dialogs_Light);
    }

    protected BaseDialog(Context context, int theme) {
        super(context, theme);
    }

    static enum LightColours {
        TITLE("#474747"), CONTENT("#999999"), ITEM("#999999"), BUTTON("#212121");

        final String mColour;

        private LightColours(String _colour) {
            this.mColour = _colour;
        }
    }

    static enum DarkColours {
        TITLE("#CCCCCC"), CONTENT("#999999"), ITEM("#999999"), BUTTON("#CCCCCC");

        final String mColour;

        private DarkColours(String _colour) {
            this.mColour = _colour;
        }
    }

    public static enum Theme {
        LIGHT, DARK;
    }

    public static enum Alignment {
        LEFT, CENTER, RIGHT;
    }

    static int getGravityFromAlignment(Alignment _alignment) {
        // Return corresponding gravity from our Alignment value.
        switch (_alignment) {
            case LEFT:
                return Gravity.LEFT;
            case CENTER:
                return Gravity.CENTER;
            case RIGHT:
                return Gravity.RIGHT;
            default:
                return Gravity.LEFT;
        }
    }
}

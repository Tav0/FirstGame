package com.luisvillavicencio.cardmemory;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Class for intro pic
 *
 * @author lv23, katee93
 * @version 2014.05.02
 */
public class IntroPic
    extends RectangleShape
{
    /**
     * Creates the intro pic
     *
     * @param left
     *            screen
     * @param top
     *            screen
     * @param right
     *            screen
     * @param bottom
     *            screen
     */
    public IntroPic(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("intro");
    }
}

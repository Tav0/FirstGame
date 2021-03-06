package com.luisvillavicencio.cardmemory;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Class for the lose pic.
 *
 * @author lv23, katee93
 * @version May 5, 2014
 */
public class LostPic
    extends RectangleShape
{
    /**
     * Creates the losing pic.
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
    public LostPic(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("lost");
    }
}

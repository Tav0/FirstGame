package com.luisvillavicencio.cardmemory;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Class is for the win pic
 *
 * @author lv23, katee93
 * @version May 5, 2014
 */
public class WinPic
    extends RectangleShape
{
    /**
     * Creates the win pic.
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
    public WinPic(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("win");
    }

}

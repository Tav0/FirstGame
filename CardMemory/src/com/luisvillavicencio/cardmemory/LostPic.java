package com.luisvillavicencio.cardmemory;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Tavo
 * @version May 5, 2014
 */
public class LostPic
    extends RectangleShape
{
    /**
     * Creates a red tile.
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

package com.luisvillavicencio.cardmemory;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
/**
 * // -------------------------------------------------------------------------
/**
 *  Class that creates the tiles.
 *
 *  @author lv23, ayk1994, katee93
 *  @version 2014.04.16
 */
public class CoverTile
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
    public CoverTile(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.maroon);
        setColor(Color.white);
    }

}

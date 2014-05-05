package com.luisvillavicencio.cardmemory;
import sofia.graphics.RectangleShape;

/**
 * // -------------------------------------------------------------------------
 * /** Class sets image of dog1 to fit within rectangle shape.
 *
 * @author lv23, katee93
 * @version 2014.04.16
 */
public class DogPic
    extends RectangleShape
{

    // ----------------------------------------------------------
    /**
     * Create a new Dog object.
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @param fileName
     */
    public DogPic(float left, float top, float right,
        float bottom, String fileName)
    {
        super(left, top, right, bottom);
        setImage(fileName);
    }
}

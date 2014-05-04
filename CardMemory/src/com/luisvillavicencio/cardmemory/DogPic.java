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
     * @param dogPic
     */
    public DogPic(float left, float top, float right,
        float bottom, DogCell dogPic)
    {
        super(left, top, right, bottom);
        setDogPic(dogPic);
    }

    // ----------------------------------------------------------
    /**
     * Sets the picture of different dogs depending on which
     * is passed down.
     * @param dogPic
     */
    public void setDogPic(DogCell dogPic)
    {
        if (dogPic == DogCell.DOGPIC1)
        {
            setImage("dogpic1");
        }
        else if (dogPic == DogCell.DOGPIC2)
        {
            setImage("dogpic2");
        }
        else if (dogPic == DogCell.DOGPIC3)
        {
            setImage("dogpic3");
        }
        else if (dogPic == DogCell.DOGPIC4)
        {
            setImage("dogpic4");
        }
        else if (dogPic == DogCell.DOCPIC5)
        {
            setImage("dogpic5");
        }
        else
        {
            setImage("dogpic6");
        }
    }
}

package com.luisvillavicencio.cardmemory;

// -------------------------------------------------------------------------
/**
 * Class that pairs two dog pictures.
 *
 * @author lv23, katee93
 * @version 2014.04.30
 */
public class DogCell
{
    // Fields
    private DogCell match;
    private int     x;
    private int     y;


    // ----------------------------------------------------------
    /**
     * Method returns the dogs match.
     *
     * @return pic's match.
     */
    public DogCell getMatch()
    {
        return match;
    }


    // ----------------------------------------------------------
    /**
     * Method sets two DogCells equal to each other.
     *
     * @param match
     *            dogCell match
     */
    public void setMatch(DogCell match)
    {
        this.match = match;
        match.match = this;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return x coordinate
     */
    public int getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     */
    public void setX(int x)
    {
        this.x = x;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return y coordinate
     */
    public int getY()
    {
        return y;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param y coord
     */
    public void setY(int y)
    {
        this.y = y;
    }

}

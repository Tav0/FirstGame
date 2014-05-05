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
     * Getter to get the x-coordinate
     *
     * @return x coordinate
     */
    public int getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Setter for x-coordinate
     *
     * @param x
     */
    public void setX(int x)
    {
        this.x = x;
    }


    // ----------------------------------------------------------
    /**
     * Getter to get the y-coordinate
     *
     * @return y coordinate
     */
    public int getY()
    {
        return y;
    }


    // ----------------------------------------------------------
    /**
     * Setter for y-coordinate
     *
     * @param y coordinate
     */
    public void setY(int y)
    {
        this.y = y;
    }

}

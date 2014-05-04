package com.luisvillavicencio.cardmemory;

import android.graphics.Point;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
 * /** Class creates the grid that stores the images.
 *
 * @author lv23, katee93
 * @version 2014.04.16
 */
public class Board
{
    // Fields
    private DogCell[][] cardBoard;
    private int         size;
    private List<Point> allPositionPoints;


    // Constructor
    /**
     * Creates the 4x4 board.
     *
     * @param size
     */
    public Board(int size)
    {
        this.size = size;

        cardBoard = new DogCell[size][size];

        allPositionPoints = new ArrayList<Point>(size * size);

        listOfPositions();
        setDogPic();
    }


    // ----------------------------------------------------------
    /**
     * Creates list of positions and shuffles them.
     */
    public void listOfPositions()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                allPositionPoints.add(new Point(i, j));
            }
        }
        Collections.shuffle(allPositionPoints);
    }


    // ----------------------------------------------------------
    /**
     * Gets points from arrayList and places the ENUMS randomly in the list.
     */
    public void setDogPic()
    {
        int i = 0;
        for (DogCell dogCell : DogCell.values())
        {
            if (i < 5)
            {
                int card1x = allPositionPoints.get(i).x;
                int card1y = allPositionPoints.get(i).y;
                this.cardBoard[card1x][card1y] = dogCell;

                int card2x = allPositionPoints.get(++i).x;
                int card2y = allPositionPoints.get(++i).y;
                this.cardBoard[card2x][card2y] = dogCell;
            }
            ++i;
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return DogCell
     */
    public DogCell getPic()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (cardBoard[i][j] == DogCell.DOGPIC1)
                {
                    return DogCell.DOGPIC1;
                }
                else if (cardBoard[i][j] == DogCell.DOGPIC2)
                {
                    return DogCell.DOGPIC2;
                }
                else if (cardBoard[i][j] == DogCell.DOGPIC3)
                {
                    return DogCell.DOGPIC3;
                }
                else if (cardBoard[i][j] == DogCell.DOGPIC4)
                {
                    return DogCell.DOGPIC4;
                }
                else if (cardBoard[i][j] == DogCell.DOCPIC5)
                {
                    return DogCell.DOCPIC5;
                }
            }
        }
        return null;
    }


    /**
     * Returns width of board.
     *
     * @return width of board
     */
    public int size()
    {
        return size;
    }
}

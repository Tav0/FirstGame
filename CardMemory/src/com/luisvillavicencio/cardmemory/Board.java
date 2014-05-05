package com.luisvillavicencio.cardmemory;

import sofia.util.Random;
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
    private DogCell[][]   cardBoard;
    private int           size;
    private List<DogCell> dogMatches;


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

        dogMatches = new ArrayList<DogCell>((size * size) / 2);

        dogPairList();
        placePairRandom();
    }


    // ----------------------------------------------------------
    /**
     * Creates 2 pair objects and gets stored in the list.
     */
    public void dogPairList()
    {
        for (int i = 0; i < (size * size) / 2; i++)
        {
            DogCell dog = new DogCell();
            dog.setMatch(new DogCell());
            dogMatches.add(dog);
        }
    }


    // ----------------------------------------------------------
    /**
     * Places each pair into a random places in cardBoard.
     */
    public void placePairRandom()
    {
        for (DogCell dogPic : dogMatches)
        {
            int xCell;
            int yCell;

            // Places first pic of a pair of dog pics in the array.
            do
            {
                xCell = Random.generator().nextInt(size);
                yCell = Random.generator().nextInt(size);
            }// If cell has a pic in it already, other numbers will be
             // generated to find an empty cell to place pic.
            while (cardBoard[xCell][yCell] != null);

            cardBoard[xCell][yCell] = dogPic;
            dogPic.setX(xCell);
            dogPic.setY(yCell);

            //The pair dog pic same implementation
            do
            {
                xCell = Random.generator().nextInt(size);
                yCell = Random.generator().nextInt(size);
            }


            while (cardBoard[xCell][yCell] != null);

            cardBoard[xCell][yCell] = dogPic.getMatch();
            dogPic.getMatch().setX(xCell);
            dogPic.getMatch().setY(yCell);
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the cell given.
     *
     * @param x
     * @param y
     * @return the cell picked
     */
    public DogCell getDogCell(int x, int y)
    {
        return cardBoard[x][y];
    }


    // ----------------------------------------------------------
    /**
     * @return true if all matches are found.
     */
    public boolean isFinished()
    {
        return dogMatches.isEmpty();
    }


    // ----------------------------------------------------------
    /**
     * Getter method to get the list.
     *
     * @return list of matches
     */
    public List<DogCell> unFoundMatches()
    {
        return dogMatches;
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

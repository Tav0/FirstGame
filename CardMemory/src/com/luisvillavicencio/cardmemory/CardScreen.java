package com.luisvillavicencio.cardmemory;

import java.util.ArrayList;
import java.util.List;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
 * /** Class creates the grid that stores the images. Also interaction with
 * user. View and Controller class.
 *
 * @author lv23, katee93
 * @version 2014.04.16
 */
public class CardScreen
    extends ShapeScreen

{
    // Fields

    private Board            board;
    private DogCell          firstTouch;
    private int              wrong    = 0;

    private static final int GAMESIZE = 4;
    private List<String>     picName;
    private String[]         pics     = { "dog1", "dog2", "dog3", "dog4",
        "dog5", "dog6", "dog7", "dog8" };


    public void initialize()
    {
        // First pic to look for its pair.
        firstTouch = null;

        /**
         * Initializes a ArrayList (data structure) of type string to add the
         * strings of the pic names into a list.
         */
        picName = new ArrayList<String>();
        for (String p : pics)
        {
            picName.add(p);
        }

        // Initializes a Board object to create the grid.
        board = new Board(GAMESIZE);

        // Adds the intro pic before playing the game.
        IntroPic intro =
            new IntroPic(
                (0 * this.getWidth()),
                (0 * this.getHeight()),
                (int)this.getWidth(),
                (int)this.getHeight());
        add(intro);

        // Pauses the game by 6 secs for player to read instructions.
        pause();

        /**
         * Places a pic in the pair DogCell objects that are linked in the list
         */
        for (DogCell d : board.listOfPairPics())
        {
            String p = getUnusedPic();
            placePicture(d, p);
            placePicture(d.getMatch(), p);
        }
        // Pauses game for 6secs to see the dog pics before covering them.F
        pause();

        // Covers the pics to start playing.
        cover();
    }


    // ----------------------------------------------------------
    /**
     * Places a pic in the specified x and y coord of the grid.
     *
     * @param cell
     *            DogCell object to get x and y coord
     * @param fileName
     *            name of pic
     */
    public void placePicture(DogCell cell, String fileName)
    {
        float dogCellWidth = getWidth() / GAMESIZE;
        float dogCellHeight = getHeight() / GAMESIZE;

        DogPic picDog =
            new DogPic(
                (cell.getX() * dogCellWidth),
                (cell.getY() * dogCellHeight),
                ((cell.getX() + 1) * dogCellWidth),
                ((cell.getY() + 1) * dogCellHeight),
                fileName);
        add(picDog);
    }


    // Helper method to remove the name of pic already placed in the grid.
    private String getUnusedPic()
    {
        return picName.remove(0);
    }


    /**
     * Method covers the images with tiles on the screen.
     */
    public void cover()
    {
        for (int row = 0; row < GAMESIZE; row++)
        {
            for (int col = 0; col < GAMESIZE; col++)
            {
                CoverTile tile = createCover(row, col);
                // Covers pic with a tile
                add(tile);
            }
        }
    }


    // Method to get the location of where the tile will be covered.
    private CoverTile createCover(int row, int col)
    {
        int tileWidth = (int)getWidth() / GAMESIZE;
        int tileHeight = (int)getHeight() / GAMESIZE;

        CoverTile tile =
            new CoverTile(
                (row * tileWidth),
                (col * tileHeight),
                ((row + 1) * tileWidth),
                (col + 1) * tileHeight);
        return tile;
    }


    /**
     * Method will reveal the pair of images.
     *
     * @param x
     *            pixel coordinate
     * @param y
     *            pixel coordinate
     */
    public void processTouch(float x, float y)
    {
        // Will remove the tile to see pic
        CoverTile tile =
            getShapes().locatedAt(x, y).withClass(CoverTile.class).front();
        if (tile != null)
        {
            tile.animate(1000).rotation(360).alpha(0).removeWhenComplete()
                .play();
        }

        // Checks if you chose the correct pair
        if (firstTouch == null)
        {
            firstTouch = board.getDogCell(getCellX(x), getCellY(y));
        }
        else
        {
            DogCell secondTouch = board.getDogCell(getCellX(x), getCellY(y));
            // If firstTouch and secondTouch pic guesses are equal
            // The pair gets removed from the DogCell.dogMatches arraylist.
            if (secondTouch.equals(firstTouch.getMatch()))
            {
                if (board.listOfPairPics().contains(firstTouch))
                {
                    board.listOfPairPics().remove(firstTouch);
                }
                else
                {
                    board.listOfPairPics().remove(secondTouch);
                }
            }
            else
            {
                // add delay before covering the cells again.
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                // Covers the firstTouch and secondTouch with a tile
                add(createCover(firstTouch.getX(), firstTouch.getY()));
                add(createCover(secondTouch.getX(), secondTouch.getY()));
                ++wrong;
            }
            // Sets firstTouch to null again to find two new pairs
            firstTouch = null;
        }

        // Check if you completed the game
        youWon();
        // Check if you tried guessing for the pairs 5 times
        youLost();
    }


    // ----------------------------------------------------------
    /**
     * If list is empty then player wins by showing winning pic
     */
    public void youWon()
    {
        if (board.isFinished())
        {
            WinPic win =
                new WinPic(
                    (0 * this.getWidth()),
                    (0 * this.getHeight()),
                    (int)this.getWidth(),
                    (int)this.getHeight());
            add(win);
        }
    }


    // ----------------------------------------------------------
    /**
     * If player tries 5 times matching the pics incorrectly, then player loses
     * game by showing losing pic.
     */
    public void youLost()
    {
        if (wrong == 5)
        {
            LostPic lost =
                new LostPic(
                    (0 * this.getWidth()),
                    (0 * this.getHeight()),
                    (int)this.getWidth(),
                    (int)this.getHeight());
            add(lost);
        }
    }


    // Helper method to get the cell in the array grid for the x-coord
    private int getCellX(float x)
    {
        float dogCellWidth = this.getWidth() / GAMESIZE;

        return (int)(x / dogCellWidth);
    }


    // Helper method to get the cell in the array grid for y-coord
    private int getCellY(float y)
    {
        float dogCellHeight = this.getHeight() / GAMESIZE;
        return (int)(y / dogCellHeight);
    }


    /**
     * Be able for the screen to be touched.
     *
     * @param x
     *            width
     * @param y
     *            height
     */
    public void onTouchDown(float x, float y)
    {
        processTouch(x, y);
    }


    private void pause()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

    }


    // ----------------------------------------------------------
    /**
     * Getters method to get the board.
     *
     * @return Board class.
     */
    public Board getBoard()
    {
        return board;
    }
}

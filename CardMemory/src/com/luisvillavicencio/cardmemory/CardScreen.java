package com.luisvillavicencio.cardmemory;

import java.util.ArrayList;
import java.util.List;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
 * /** Class creates the grid that stores the images. Also interaction with
 * user.
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
        firstTouch = null;

        picName = new ArrayList<String>();
        for (String p : pics)
        {
            picName.add(p);
        }

        board = new Board(GAMESIZE);

        IntroPic intro =
            new IntroPic(
                (0 * this.getWidth()),
                (0 * this.getHeight()),
                (int)this.getWidth(),
                (int)this.getHeight());
        add(intro);

        try
        {
            Thread.sleep(6000);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        for (DogCell d : board.unFoundMatches())
        {
            String p = getUnusedPic();
            placePicture(d, p);
            placePicture(d.getMatch(), p);
        }

        try
        {
            Thread.sleep(6000);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        cover();
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param cell
     * @param fileName
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
                add(tile);
            }
        }
    }


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
     * @param y
     */
    public void processTouch(float x, float y)
    {
        CoverTile tile =
            getShapes().locatedAt(x, y).withClass(CoverTile.class).front();
        if (tile != null)
        {
            tile.animate(1000).rotation(360).alpha(0).removeWhenComplete()
                .play();
        }

        if (firstTouch == null)
        {
            firstTouch = board.getDogCell(getCellX(x), getCellY(y));
        }
        else
        {
            DogCell secondTouch = board.getDogCell(getCellX(x), getCellY(y));
            if (secondTouch.equals(firstTouch.getMatch()))
            {
                if (board.unFoundMatches().contains(firstTouch))
                {
                    board.unFoundMatches().remove(firstTouch);
                }
                else
                {
                    board.unFoundMatches().remove(secondTouch);
                }
            }
            else
            {
                // add delay TO NOT RE-COVER THE TILES.
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }

                add(createCover(firstTouch.getX(), firstTouch.getY()));
                add(createCover(secondTouch.getX(), secondTouch.getY()));
                ++wrong;
            }
            firstTouch = null;
        }

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


    private int getCellX(float x)
    {
        float dogCellWidth = this.getWidth() / GAMESIZE;

        return (int)(x / dogCellWidth);
    }

    /**
     * Getter method for
     */
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


    /**
     * Reset button to start a new game.
     */
    public void resetClicked()
    {
        // reset button
        initialize();
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

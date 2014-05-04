package com.luisvillavicencio.cardmemory;

// import sofia.graphics.RectangleShape;
// import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
 * /** Class creates the grid that stores the images. Also interaction with
 * user.
 *
 * @author lv23, katee93
 * @version 2014.04.16
 */
public class CardGame
    extends ShapeScreen

{
    // Fields
    // private DogPic[][] dogPic;
    // private CoverTile[][] tileScreen;
    // private Board board;

    private int              pxSize;
    private int              cellSize;

    private static final int GAMESIZE = 4;


    public void initialize()
    {
        // board = new Board(GAMESIZE);
        // dogPic = new DogPic[GAMESIZE][GAMESIZE];
        // tileScreen = new CoverTile[GAMESIZE][GAMESIZE];
        pxSize = Math.min((int)getWidth(), (int)getHeight());
        cellSize = pxSize / GAMESIZE;

        // dogCard();
        cover();
    }


    /**
     * Places the dog pictures to a 4x3 grid.
     */
    /**public void dogCard()
    {
        for (int row = 0; row < GAMESIZE; row++)
        {
            // float dogCellHeight = this.getHeight() / GAMESIZE;
            for (int col = 0; col < GAMESIZE; col++)
            {
                // float dogCellWidth = this.getWidth() / this.height;
                DogPic picDog =
                    new DogPic(
                        (row * cellSize),
                        (col * cellSize),
                        ((row + 1) * cellSize),
                        ((col + 1) * cellSize),
                        board.getPic());
                add(dogPic);
            }
        }
    }*/


    /**
     * Method covers the images with tiles on the screen.
     */
    public void cover()
    {
        for (int row = 0; row < GAMESIZE; row++)
        {
            int tileWidth = (int)getWidth() / GAMESIZE;
            for (int col = 0; col < GAMESIZE; col++)
            {
                int tileHeight = (int)getHeight() / GAMESIZE;
                CoverTile tile =
                    new CoverTile(
                        (row * tileWidth),
                        (col * tileHeight),
                        ((row + 1) * tileWidth),
                        (col + 1) * tileHeight);

                add(tile);
            }
        }
    }


    /**
     * Method will reveal the pair of images.
     *
     * @param x
     * @param y
     */
    public void reveal(float x, float y)
    {
        CoverTile tile =
            getShapes().locatedAt(x, y).withClass(CoverTile.class).front();
        if (tile != null)
        {
            tile.animate(1000).rotation(360).alpha(0).removeWhenComplete()
                .play();
        }
    }


    /**
     * Reset button to start a new game.
     */
    public void resetClicked()
    {
        // reset button
    }


    /**
     * Method checks if game is won or lost.
     */
    public void gg()
    {
        // To be continued
    }
}

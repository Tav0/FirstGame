package com.luisvillavicencio.cardmemory;

// -------------------------------------------------------------------------
/**
 * Tests the CardScreen class
 *
 * @author lv23, katee93
 * @version 2014.05.04
 */
public class CardScreenTest
    extends student.AndroidTestCase<CardScreen>
{
    // Fields
    private CardScreen screen;
    private Board      board;


    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public CardScreenTest()
    {
        super(CardScreen.class);
    }


    // setUp
    public void setUp()
    {
        board = new Board(4);
        screen = new CardScreen();

    }

}

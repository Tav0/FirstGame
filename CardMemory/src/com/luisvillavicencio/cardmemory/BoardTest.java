package com.luisvillavicencio.cardmemory;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author lv23, katee93
 * @version 2014.05.04
 */
public class BoardTest
    extends TestCase
{
    // Fields
    private Board board;
    private DogCell dogCell;


    // Setup
    public void setUp()
    {
        //
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void test1()
    {
        board = new Board(2);

        assertEquals(2, board.unFoundMatches().size());

        board.unFoundMatches().remove(0);
        board.unFoundMatches().remove(0);
        assertTrue(board.isFinished());

    }
}

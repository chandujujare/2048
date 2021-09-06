package com.a2048.contract

/**
 * A contractor helps to main MVP components
 */
interface IContract {


    interface View {
        fun updateRows(array: ArrayList<Int>)
        fun updateGameStatus(b: Boolean)
        fun init(board: ArrayList<Int>)
    }

    interface Presenter {

        fun doTopToBottomAddition()
        fun doBottomToTopAddition()
        fun doRightToLeftAddition()
        fun doLeftToRightAddition()
        fun initBoard()

    }

    interface GameModel {
        fun getBoard(): ArrayList<Int>
        fun addRows(rightToLeft: Boolean): Array<IntArray>
        fun addColumns(upWords: Boolean): Array<IntArray>
        fun generateRandom()
        fun publishResult(): Boolean
    }

}
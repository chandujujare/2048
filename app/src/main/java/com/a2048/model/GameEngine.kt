package com.a2048.model

import com.a2048.contract.IContract

/**
 * A class to deal with game logic
 */
class GameEngine : IContract.GameModel {

    private val row1: IntArray = intArrayOf(0, 0, 0, 0)
    private val row2: IntArray = intArrayOf(0, 0, 0, 0)
    private val row3: IntArray = intArrayOf(0, 0, 0, 0)
    private val row4: IntArray = intArrayOf(0, 0, 0, 0)
    private val matrix: Array<IntArray> = arrayOf(row1, row2, row3, row4)

    /**
     * Return the game board logic
     */
    override fun getBoard(): ArrayList<Int> {
        var list = ArrayList<Int>()
        for (i in 0..3) {
            for (j in 0..3) {
                list.add(matrix[i][j])
            }
        }

        return list
    }


    /**
     * Adds rows which are adjacent to each other
     */
    override fun addRows(rightToLeft: Boolean): Array<IntArray> {

        var sum = 0
        for (i in 0..3) {
            for (j in 0..3) {
                if (j + 1 < 4 && matrix[i][j] == matrix[i][j + 1]) {
                    sum = matrix[i][j] + matrix[i][j + 1]
                    if (rightToLeft) {
                        matrix[i][j] = sum
                        matrix[i][j + 1] = 0
                    } else {
                        matrix[i][j] = 0
                        matrix[i][j + 1] = sum
                    }
                }
            }
        }
        generateRandom()
        return matrix
    }

    /**
     * Adds columns which are adjacent to each othe
     */
    override fun addColumns(upWords: Boolean): Array<IntArray> {
        var sum = 0
        for (i in 0..3) {
            for (j in 0..3) {
                if (i + 1 < 4 && matrix.get(i)[j] == matrix.get(i + 1)[j]) {
                    sum = matrix.get(i)[j] + matrix.get(i + 1)[j]
                    if (upWords) {
                        matrix.get(i)[j] = sum
                        matrix.get(i + 1)[j] = 0
                    } else {
                        matrix.get(i)[j] = 0
                        matrix.get(i + 1)[j] = sum
                    }
                }
            }
        }
        generateRandom()
        return matrix
    }

    override fun generateRandom() {
        val rowrandom = (0..3).random()
        val colrandom = (0..3).random()
        if (matrix[rowrandom][colrandom] == 0) {
            matrix[rowrandom][colrandom] = 2
        }else{
            generateRandom()
        }

    }

    override fun publishResult(): Boolean {

        for (i in 0..3) {
            for (j in 0..3) {
                if(matrix[i][j]==2048)
                    return true
            }
        }
        return false
    }
}
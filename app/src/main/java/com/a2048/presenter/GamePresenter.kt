package com.a2048.presenter

import com.a2048.contract.IContract
import com.a2048.model.GameEngine


/**
 * A presenter to handle the view action from UI
 */
class GamePresenter(_view: IContract.View) : IContract.Presenter {

    private var view: IContract.View = _view
    private var gameEngine = GameEngine()

    /**
     * To add columns in top to bottom
     */
    override fun doTopToBottomAddition() {
        gameEngine.addColumns(false)
        view.updateRows(gameEngine.getBoard())
       publish()
    }

    private fun publish() {
        if (gameEngine.publishResult()){
            view.updateGameStatus(true)
        }
    }

    /**
     * To add columns in bottom to top
     */
    override fun doBottomToTopAddition() {
        gameEngine.addColumns(true)
        view.updateRows(gameEngine.getBoard())
        publish()
    }
    /**
     * To add columns in right to left
     */
    override fun doRightToLeftAddition() {
        gameEngine.addRows(true)
        view.updateRows(gameEngine.getBoard())
        publish()
    }


    /**
     * To add columns in left to right
     */
    override fun doLeftToRightAddition() {
        gameEngine.addRows(false)
        view.updateRows(gameEngine.getBoard())
        publish()
    }

    /**
     * Initializes the board once activity starts
     */
    override fun initBoard() {
        gameEngine.generateRandom()
        gameEngine.generateRandom()
        view.init(gameEngine.getBoard())
    }


}
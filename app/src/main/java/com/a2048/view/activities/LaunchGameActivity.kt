package com.a2048.view.activities

import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.a2048.R
import com.a2048.contract.IContract
import com.a2048.presenter.GamePresenter
import com.a2048.view.adapters.GameBoardAdapter

/**
 *  Gamer Activity
 */
class LaunchGameActivity : AppCompatActivity(),IContract.View,View.OnClickListener {

    private var presenter: GamePresenter = GamePresenter(this)
    private lateinit var gameBoard: GridView
    private lateinit var adapter: GameBoardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        gameBoard = findViewById(R.id.gameBoard)
        findViewById<ImageView>(R.id.left).setOnClickListener(this)
        findViewById<ImageView>(R.id.right).setOnClickListener(this)
        findViewById<ImageView>(R.id.up).setOnClickListener(this)
        findViewById<ImageView>(R.id.down).setOnClickListener(this)
        presenter.initBoard()
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.left -> presenter.doRightToLeftAddition()
            R.id.right -> presenter.doLeftToRightAddition()
            R.id.up -> presenter.doBottomToTopAddition()
            R.id.down -> presenter.doTopToBottomAddition()
        }

    }

    override fun updateRows(array: ArrayList<Int>) {
        adapter.setData(array)

    }

    override fun updateGameStatus(b: Boolean) {
        if (b) {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle(getString(R.string.app_name))
            dialog.setMessage(getString(R.string.success))
            dialog.create().show()
        }
    }

    override fun init(board: ArrayList<Int>) {
        adapter = GameBoardAdapter(this,board)
        gameBoard.adapter = adapter
    }

}

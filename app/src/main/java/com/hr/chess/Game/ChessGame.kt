package com.hr.chess.Game

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hr.chess.R

class ChessGame: AppCompatActivity() {
    private lateinit var currentPlayerText: TextView
    private lateinit var gridLayout: GridLayout
    private lateinit var moveHistoryText: TextView
    private lateinit var validMovesContainer: LinearLayout
    private lateinit var moveLeftButton: Button
    private lateinit var moveRightButton: Button
    private lateinit var moveForwardButton: Button
    private lateinit var moveBackwardButton: Button

    private var currentplayer="player A"
    private val moveHistory= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_chess)

        callId()
        initializeBoard()
        setupMoveButtons()

    }

    private fun callId(){
        currentPlayerText = findViewById(R.id.currentPlayerText)
        gridLayout = findViewById(R.id.gridLayout)
        moveHistoryText = findViewById(R.id.moveHistoryText)
        validMovesContainer = findViewById(R.id.validMovesContainer)
        moveLeftButton = findViewById(R.id.moveLeftButton)
        moveRightButton = findViewById(R.id.moveRightButton)
        moveForwardButton = findViewById(R.id.moveForwardButton)
        moveBackwardButton = findViewById(R.id.moveBackwardButton)
    }
    private fun initializeBoard(){
        for(i in 0 until 5){
            for(j in 0 until 5){
                val button=Button(this).apply {
                    layoutParams=GridLayout.LayoutParams().apply {
                        width=0
                        height=0
                        rowSpec=GridLayout.spec(i,1f)
                        columnSpec=GridLayout.spec(j,1f)
                        setPadding(8,8,8,8)
                    }
                    text="$i,$j"
                    setOnClickListener{
                        onGridCellClicked(i, j)
                    }
                }
                gridLayout.addView(button)
        }
        }
    }

    private fun onGridCellClicked(row:Int,col:Int){
        showValidMoves(row,col)
    }

    private fun showValidMoves(row: Int,col: Int){
        validMovesContainer.visibility=View.VISIBLE
    }

    private fun setupMoveButtons() {
        moveLeftButton.setOnClickListener {
            performMove("Left")
        }
        moveRightButton.setOnClickListener {
            performMove("Right")
        }
        moveForwardButton.setOnClickListener {
            performMove("Forward")
        }
        moveBackwardButton.setOnClickListener {
            performMove("Backward")
        }
    }

    private fun performMove(direction: String){
        moveHistory.add("$currentplayer:Moved $direction")
        updateMoveHistory()
        switchPlayer()
    }

    private fun updateMoveHistory(){
        moveHistoryText.text=moveHistory.joinToString { "\n" }
    }

    private fun switchPlayer(){
        currentplayer=
            if (currentplayer=="Player A") {
                "Player B"}
            else{
                "Player A"
            }
        currentPlayerText.text="Current Turn:$currentplayer"
        validMovesContainer.visibility=View.GONE
    }


}
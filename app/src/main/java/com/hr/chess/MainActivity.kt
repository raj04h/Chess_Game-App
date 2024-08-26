package com.hr.chess

import android.app.Activity
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hr.chess.Game.ChessGame
import com.hr.chess.Tool.RuleviewTool
import com.hr.chess.Tool.SettingTool

class MainActivity: AppCompatActivity() {

    lateinit var btnstartgame: Button
    lateinit var btnsetting:Button
    lateinit var btnrule:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callId()
        calllistenerId()

        }

    private fun callId(){
        btnstartgame=findViewById(R.id.btnStartGame)
        btnsetting=findViewById(R.id.btnSettings)
        btnrule=findViewById(R.id.btnViewRules)
    }

    private fun calllistenerId(){
        btnstartgame.setOnClickListener{
            val intent=Intent(this,ChessGame::class.java)
            startActivity(intent)
            true
        }
        btnsetting.setOnClickListener{
            val intent=Intent(this, SettingTool::class.java)
            startActivity(intent)
            true
        }
        btnrule.setOnClickListener{
            val intent=Intent(this,RuleviewTool::class.java)
            startActivity(intent)
            true
        }
    }
    }
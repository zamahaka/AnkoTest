package com.gentledevs.ankotest

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }
}

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            val appBarLayout = appBarLayout(R.style.AppTheme_AppBarOverlay) {
                id = generateId()
                val toolbar = toolbar()
                owner.setSupportActionBar(toolbar)
                owner.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }.lparams { alignParentTop(); alignParentStart(); alignParentEnd() }
            verticalLayout {
                val name = editText()
                button("Hello world") {
                    onClick { ctx.toast("Hello, ${name.text}") }
                }
            }.lparams {
                below(appBarLayout)
            }
        }
    }
}

@IdRes fun generateId(): Int = View.generateViewId()
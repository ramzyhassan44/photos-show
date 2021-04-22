package com.learning.photoshow.core.routers

interface Router {
    fun routeTo(destination: String, navigationArgs: String?, willBeFinished: Boolean)
    fun finish()
}
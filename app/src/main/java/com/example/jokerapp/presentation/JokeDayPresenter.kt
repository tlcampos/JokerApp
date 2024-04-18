package com.example.jokerapp.presentation

import com.example.jokerapp.data.JokeCallBack
import com.example.jokerapp.data.JokeDayRemoteDataSource
import com.example.jokerapp.model.Joke
import com.example.jokerapp.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallBack {

    fun findRandom(){
        view.showProgress()
        dataSource.findRandom(this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}
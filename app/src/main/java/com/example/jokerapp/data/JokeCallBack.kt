package com.example.jokerapp.data

import com.example.jokerapp.model.Joke

interface JokeCallBack {

    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}

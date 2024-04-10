package com.example.jokerapp.data

import android.os.Handler
import android.os.Looper

class CategoryRemoteDataSource {
    //SIMULAR UMA REQUISIÇÃO HTTP
    fun findAllCategories(callback: ListCategoryCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )
            callback.onSuccess(response)

            callback.onComplete()
            //callback.onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE!")

        }, 1000)
    }
}
package com.example.kotlinpoi.poi.entity

import java.util.Date

class Book {
    var id: Long? = null
    var author: String? = null
    var name: String? = null
    var releaseDate: Date? = null
    var numerOfPages: Int = 1
    var description: String? = null

    constructor() {}
    constructor(id: Long?, author: String?, name: String?, releaseDate: Date?, numerOfPages: Int, description: String?) {
        this.id = id
        this.author = author
        this.name = name
        this.releaseDate = releaseDate
        this.numerOfPages = numerOfPages
        this.description = description
    }

    override fun toString(): String {
        return "Book [id = ${id}, author = ${author}, releaseDate ${releaseDate}, numberOfPages = ${numerOfPages}, " +
                "description = ${description} ]"
    }
}
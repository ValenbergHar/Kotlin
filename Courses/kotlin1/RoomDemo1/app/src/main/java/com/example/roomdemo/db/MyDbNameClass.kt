package com.example.roomdemo.db

import android.provider.BaseColumns

object MyDbNameClass : BaseColumns{
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_SUBTITLE = "subtitle"


    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyLessonDb.db"
}
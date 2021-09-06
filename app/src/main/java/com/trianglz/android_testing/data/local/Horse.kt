package com.trianglz.android_testing.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horses")
data class Horse(val name: String, val price: Double, @PrimaryKey(autoGenerate = true) val id: Int)
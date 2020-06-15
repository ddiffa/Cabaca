
package com.hellodiffa.cabaca.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import com.hellodiffa.cabaca.data.local.CabacaDatabase
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class LocalDatabase {
  lateinit var db: CabacaDatabase

  @Before
  fun initDB() {
    db = Room.inMemoryDatabaseBuilder(mock(), CabacaDatabase::class.java)
      .allowMainThreadQueries()
      .build()
  }

  @After
  fun closeDB() {
    db.close()
  }

  @Throws(InterruptedException::class)
  fun <T> LiveData<T>.getValueBlocking(): T? {
    var value: T? = null
    val latch = CountDownLatch(1)
    val innerObserver = Observer<T> {
      value = it
      latch.countDown()
    }
    observeForever(innerObserver)
    latch.await(2, TimeUnit.SECONDS)
    return value
  }
}

package com.example.homeworks.homework4

import android.util.Log
import homework4.Boss
import homework4.Employee
import homework4.Manager
import homework4.Worker

class PersonFactory {
    fun createPersons(): Collection<Boss> {
        val worker1 = Worker("worker1", 100)
        val worker2 = Worker("worker2", 110)
        val worker3 = Worker("worker3", 130)
        val workersList: MutableList<Worker> = mutableListOf(worker1, worker2, worker3)
        var manager1 = Manager("manager1", 200)
        manager1.list = workersList
        val worker4 = Worker("worker4", 140)
        val worker5 = Worker("worker5", 150)
        val worker6 = Worker("worker6", 160)
        val workersList2: MutableList<Worker> = mutableListOf(worker4, worker5, worker6)
        val manager2 = Manager("manager2", 220)
        manager2.list = workersList2
        var firstManager: MutableList<Manager> = mutableListOf(manager1)
        var secondManager: MutableList<Manager> = mutableListOf(manager2)
        var boss1 = Boss("boss1", 300)
        boss1.list = firstManager
        var boss2 = Boss("boss2", 330)
        boss2.list = secondManager
        val list: List<Boss> = listOf(boss1, boss2)
        return list
    }

    fun showInfo(list: Collection<Boss>) {
        list.forEach() { boss ->
            Log.e("KEK", "$boss")
            Log.e("KEK", "${boss.list}")
            boss.list.forEach() { manager ->
                manager.list.forEach() { worker ->
                    Log.e("KEK", "$worker and ${worker.working()}")
                }
            }
        }
    }
}
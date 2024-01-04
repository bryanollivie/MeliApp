package com.bryanollivie.appml.data.local

import com.bryanollivie.appml.data.local.entity.User
import javax.inject.Inject

class LocalUserRepository @Inject constructor(private val userDao: UserDao) {

    fun getAllUsers(): List<User> {
        return userDao.getAll()
    }

    fun saveUsers(users: List<User>){
        return userDao.insertAll(users)
    }

}


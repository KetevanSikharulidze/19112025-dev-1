package com.example.a19112025_dev_1.model

data class User (
    val id: String,
    val name: String,
    val surname: String,
    val passportPhoto: String ?= null,
    val skills: List<Skill>? = null)

//USER -> {
//    user1{
//         ...
//    },
//    user2{
//         ...
//    },
//    user3{
//         ...
//    },
//    ...
//}
package com.example.darwinftb.repository

import com.example.darwinftb.model.Dueño
import org.springframework.data.jpa.repository.JpaRepository

interface DueñoRepository: JpaRepository <Dueño, Long> {


    fun findById (id:Long?): Dueño?
}
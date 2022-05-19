package com.example.darwinftb.controller

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.service.DueñoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping ("/dueño")

class DueñoController {

    @Autowired
    lateinit var dueñoService: DueñoService

    @GetMapping
    fun list(): List<Dueño>{
        return dueñoService.list()
    }

    @GetMapping ("/{id}")
    fun listById (@PathVariable("id") id: Long): Dueño? {
        return dueñoService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody dueño: Dueño): Dueño {
        return dueñoService.save(dueño)
    }

    @PutMapping
    fun update (@RequestBody dueño: Dueño): Dueño {
        return dueñoService.update(dueño)
    }

    @PatchMapping
    fun updateName(@RequestBody dueño: Dueño): Dueño {
        return  dueñoService.updateName(dueño)
    }

    @DeleteMapping ("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return dueñoService.delete(id)
    }

}
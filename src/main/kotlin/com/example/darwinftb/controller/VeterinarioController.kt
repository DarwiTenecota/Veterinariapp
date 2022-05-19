package com.example.darwinftb.controller

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Veterinario
import com.example.darwinftb.service.VeterinarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/veterinario")

class VeterinarioController{

    @Autowired
    lateinit var veterinarioService: VeterinarioService

    @GetMapping
    fun list(): List<Veterinario>{
        return veterinarioService.list()
    }
    @GetMapping ("/{id}")
    fun listById(@PathVariable("id") id: Long ):Veterinario?{
        return veterinarioService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody veterinario: Veterinario):Veterinario{
        return veterinarioService.save(veterinario)
    }
    @PutMapping
    fun update (@RequestBody veterinario: Veterinario):Veterinario{
        return veterinarioService.update(veterinario)
    }
    @PatchMapping
    fun updateName(@RequestBody veterinario: Veterinario):Veterinario{
        return veterinarioService.updateName(veterinario)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return veterinarioService.delete(id)
    }

}









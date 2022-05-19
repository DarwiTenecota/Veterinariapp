package com.example.darwinftb.controller

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Mascota
import com.example.darwinftb.service.MascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mascota")

class MascotaController {
    @Autowired
    lateinit var mascotaService: MascotaService

    @GetMapping
    fun list(): List<Mascota>{
        return mascotaService.list()
    }
    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long) :Mascota?{
        return mascotaService.getById(id)
    }


    @PostMapping
    fun save (@RequestBody mascota: Mascota):Mascota{
        return mascotaService.save(mascota)
    }
    @PutMapping
    fun update (@RequestBody mascota: Mascota):Mascota{
        return mascotaService.update(mascota)
    }
    @PatchMapping
    fun updateName(@RequestBody mascota: Mascota):Mascota{
        return mascotaService.updateName(mascota)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id")id:Long):Boolean{
        return mascotaService.delete(id)
    }
}





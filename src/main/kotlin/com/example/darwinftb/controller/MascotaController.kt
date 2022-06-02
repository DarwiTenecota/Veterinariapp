package com.example.darwinftb.controller

import com.example.darwinftb.dto.NuevoNombre
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
    @GetMapping("/name/{name}")
    fun listByName(@PathVariable("name") name: String) :List<Mascota>?{
        return mascotaService.getByName(name)
    }

    @PostMapping
    fun save (@RequestBody mascota: Mascota):Mascota{
        return mascotaService.save(mascota)
    }
    //localhost:8081/students/changeName
    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody nuevoNombre: NuevoNombre): Boolean?{
        return mascotaService.updateOtherName(nuevoNombre)
    }
    @PutMapping
    fun update (@RequestBody mascota: Mascota): Mascota {
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





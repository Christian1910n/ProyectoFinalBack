package com.example.cursospring.controller;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.vm.Asset;
import com.example.cursospring.service.CursoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin("http://localhost:3000")
public class AssetController {

    @Autowired
    private CursoServiceImp s3Service;


    //metodo para subir un archivo
    @PostMapping("/upload")
   public Map<String, String > upload(@RequestParam MultipartFile foto){
        String key = s3Service.putObject(foto);

        Map<String, String> result=new HashMap<>();
        result.put("key", key);
        result.put("url", s3Service.getObjectUrl(key));

        return result;
    }

    //metodo para objener el objeto
    @GetMapping(value = "/get-object", params = "key")
   public ResponseEntity<ByteArrayResource> getObject(@RequestParam String key){
        Asset asset= s3Service.getObject(key);
        ByteArrayResource resource= new ByteArrayResource(asset.getContent());

        return ResponseEntity
                .ok()
                .header("Content-Type", asset.getContentType())
                .contentLength(asset.getContent().length)
                .body(resource);
    }
/*
    @GetMapping(value = "/get-string")
    public String string(){
        return "Hola que hace";

    }
*/

    @GetMapping(value = "/get-string")
    public List curso(){
        List <Curso>arrayList=new ArrayList<>();
        Curso curso = new Curso(1,"admin","1234","adsr","asfasd");
        arrayList.add(curso);
        Curso cursos = new Curso(1,"admin","12345","adsr","asfasd");
        arrayList.add(cursos);


        return arrayList;

    }


    //metodo para eliminar un objeto
    @DeleteMapping(value = "/delete-object", params = "key")
   public void eliminarObjeto(@RequestParam String key){
        s3Service.deleteObject(key);
        System.out.println("Imagen eliminada");
    }

}

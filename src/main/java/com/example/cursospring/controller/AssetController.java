package com.example.cursospring.controller;

import com.example.cursospring.entity.vm.Asset;
import com.example.cursospring.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private S3Service s3Service;


    //metodo para subir un archivo
    @PostMapping("/")
    Map<String, String > upload(@RequestParam MultipartFile file){
        String key = s3Service.putObject(file);

        Map<String, String> result=new HashMap<>();
        result.put("key", key);
        result.put("url", s3Service.getObjectUrl(key));

        return result;
    }

    //metodo para objener el objeto
    @GetMapping(value = "get-object", params = "key")
    ResponseEntity<ByteArrayResource> getObject(@RequestParam String key){
        Asset asset= s3Service.getObject(key);
        ByteArrayResource resource= new ByteArrayResource(asset.getContent());

        return ResponseEntity
                .ok()
                .header("Content-Type", asset.getContentType())
                .contentLength(asset.getContent().length)
                .body(resource);
    }

    //metodo para eliminar un objeto
    void eliminarObjeto(@RequestParam String key){
        s3Service.deleteObject(key);
    }

}

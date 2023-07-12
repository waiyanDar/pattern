package com.example.imageupload.controller;

import com.example.imageupload.storage.InMemoryStorage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageUploadController {

    private final InMemoryStorage inMemoryStorage;

    public ImageUploadController(InMemoryStorage inMemoryStorage) {
        this.inMemoryStorage = inMemoryStorage;
    }

    @GetMapping(value = {"/image/all","/"})
    public String showAllImages(Model model){
        model.addAttribute("imageNames", inMemoryStorage.getName());
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/image/{imageName}",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
    public byte[] getImageByName(@PathVariable String imageName){
        return inMemoryStorage.getByName(imageName);
    }

    @PostMapping("/image/upload")
    public String imageUpload(@RequestPart("file")MultipartFile multipartFile) throws IOException{
        inMemoryStorage.store(multipartFile.getOriginalFilename(),multipartFile.getBytes());
        return "redirect:/image/all";
    }
}

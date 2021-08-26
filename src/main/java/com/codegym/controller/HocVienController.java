package com.codegym.controller;

import moduls.HocVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IHocVienService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home/hocviens")
public class HocVienController {
    @Autowired
    IHocVienService iHocVienService;

    @GetMapping
    public ResponseEntity<HocVien> findAllHocVien() {
        List<HocVien> hocViens = iHocVienService.findAll();
        if (hocViens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(hocViens, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<HocVien> save(@RequestBody HocVien hocVien) {
        return new ResponseEntity<>(iHocVienService.save(hocVien), HttpStatus.CREATED);
    }




    @GetMapping("/{id}")
    public ResponseEntity<HocVien> showEdit(@PathVariable int id) {
        return new ResponseEntity(iHocVienService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocVien> edit(@RequestBody HocVien hocVien) {
        return new ResponseEntity(iHocVienService.save(hocVien), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        iHocVienService.delete(iHocVienService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }

}

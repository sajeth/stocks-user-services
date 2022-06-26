package com.saji.users.controller;

import com.saji.users.pojo.LovPojo;
import com.saji.users.services.LovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/lov")
public class LovController {
    @Autowired
    private LovService lovService;

    @GetMapping("/list")
    public @ResponseBody
    List<LovPojo> getLovList() {
        return lovService.listLov();
    }

    @GetMapping("/list/type/{type}")
    public @ResponseBody
    List<LovPojo> getLovListByType(@PathVariable String type) {
        return lovService.listLov(type);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    LovPojo getLov(@PathVariable BigInteger id) {
        return lovService.findLov(id);
    }

    @PostMapping("/new")
    public @ResponseBody
    void createNewLov(@RequestBody LovPojo pojo) {
        lovService.addLov(pojo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    void updateLov(@PathVariable BigInteger id, @RequestBody LovPojo pojo) {
        lovService.updateLov(pojo, id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteLov(@PathVariable BigInteger id) {
        lovService.deleteLov(id);
    }
}

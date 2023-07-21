package com.uas027.uas_prg7_20222_027.page;

import com.uas027.uas_prg7_20222_027.model.Lapangan;
import com.uas027.uas_prg7_20222_027.service.LapanganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LapanganPageController {
    @Autowired
    LapanganService lapanganService;

    @RequestMapping("/listlapanganth")
    public String getLapangans(Model model) {
        List<Lapangan> lapangans = lapanganService.getLapangans();
        model.addAttribute("listLapangan", lapangans);
        return "listlapanganth";
    }

    @RequestMapping("/addlapanganth")
    public String addLapangan(Model model) {
        model.addAttribute("lapanganObject",  new Lapangan());
        return "addlapanganth";
    }

    @PostMapping("/saveLapanganth")
    public String addLapangan(Lapangan lapangan) {
        lapanganService.save(lapangan);
        return "redirect:/listlapanganth";
    }

    @RequestMapping("/editlapanganth/{id}")
    public String editLapangan(@PathVariable("id") Integer id, Model model) {
        Lapangan lapangan = lapanganService.getLapangan(id);
        model.addAttribute("lapanganObject", lapangan);
        return "editlapanganth";
    }

    @PostMapping("/updateLapanganth")
    public String updateLapangan(Lapangan lapangan) {
        lapanganService.update(lapangan);
        return "redirect:/listlapanganth";
    }

    @RequestMapping("/deletelapanganth/{id}")
    public String deleteLapangan(@PathVariable("id") Integer id) {
        lapanganService.deleteLapangan(id);
        return "redirect:/listlapanganth";
    }
}

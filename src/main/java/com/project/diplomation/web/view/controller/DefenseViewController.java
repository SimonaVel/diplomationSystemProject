package com.project.diplomation.web.view.controller;

import com.project.diplomation.service.DefenseService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.view.model.DefenseViewModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@Controller
@RequiredArgsConstructor
@RequestMapping("/defenses")
public class DefenseViewController {
    private final MapperUtil mapperUtil;
    private final DefenseService defenseService;

    @GetMapping("/view/{id}")
    public String getDefenseView(Model model, @PathVariable long id) {
        DefenseViewModel defense = mapperUtil
                .getModelMapper()
                .map(this.defenseService.getDefense(id), DefenseViewModel.class);
        model.addAttribute("defense", defense);

        return "defenses/view";
    }

    @GetMapping
    String getDefensesView(Model model) {
        List<DefenseViewModel> defenses = mapperUtil
                .mapList(this.defenseService.getAllDefenses(), DefenseViewModel.class);
        model.addAttribute("defenses", defenses);
        return "defenses/defenses";
    }
}

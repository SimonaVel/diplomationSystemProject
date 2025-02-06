package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateDefenseDTO;
import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.DefenseDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Defense;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.service.DefenseService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/defenses")
public class DefenseController {
    private final DefenseService defenseService;
    private final MapperUtil mapperUtil;

//    @PostMapping("/create")
//    public CreateDefenseDTO createDefense(@RequestBody CreateDefenseDTO defenseDTO) {
//        return this.defenseService.createDefenseDTO(mapperUtil.getModelMapper().map(defenseDTO, Defense.class));
//    }

    @GetMapping("/{id}")
    public DefenseDTO getDefense(@PathVariable long id){
        return this.defenseService.getDefense(id);
    }

    @GetMapping("/all")
    public List<DefenseDTO> getAllDefenses() {
        return this.defenseService.getAllDefenses();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDefense(@PathVariable long id) {
        this.defenseService.deleteDefense(id);
    }
}

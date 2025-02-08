package com.project.diplomation.web.api;

import com.project.diplomation.data.models.dto.CreateDefenseDTO;
import com.project.diplomation.data.models.dto.CreateReviewDTO;
import com.project.diplomation.data.models.dto.DefenseDTO;
import com.project.diplomation.data.models.dto.ReviewDTO;
import com.project.diplomation.data.models.entities.Defense;
import com.project.diplomation.data.models.entities.Review;
import com.project.diplomation.exception.DefenseNotFoundException;
import com.project.diplomation.service.DefenseService;
import com.project.diplomation.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return this.defenseService.getDefense(id);
        } catch (DefenseNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Defense Not Found", exception);
        }
    }

    @GetMapping("/all")
    public List<DefenseDTO> getAllDefenses() {
        return this.defenseService.getAllDefenses();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDefense(@PathVariable long id) {
        try {
            this.defenseService.deleteDefense(id);
        } catch (DefenseNotFoundException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Defense Not Found", exception);
        }
    }
}

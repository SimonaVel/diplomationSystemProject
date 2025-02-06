package com.project.diplomation.web.view.controller;

import com.project.diplomation.data.models.dto.ApplicationDTO;
import com.project.diplomation.data.models.dto.CreateThesisDTO;
import com.project.diplomation.data.models.dto.ThesisDTO;
import com.project.diplomation.data.models.entities.Application;
import com.project.diplomation.data.models.entities.Thesis;
import com.project.diplomation.data.repositories.ApplicationRepo;
import com.project.diplomation.service.ApplicationService;
import com.project.diplomation.service.ReviewService;
import com.project.diplomation.util.MapperUtil;
import com.project.diplomation.web.view.model.ReviewViewModel;
import com.project.diplomation.web.view.model.ThesisViewModel;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewViewController {
    private final MapperUtil mapperUtil;
    private final ReviewService reviewService;

    @GetMapping("/view/{id}")
    public String getReviewView(Model model, @PathVariable long id) {
        ReviewViewModel review = mapperUtil
                .getModelMapper()
                .map(this.reviewService.getReview(id), ReviewViewModel.class);
        model.addAttribute("review", review);

        return "reviews/view";
    }

    @GetMapping
    String getReviewsView(Model model) {
        List<ReviewViewModel> reviews = mapperUtil
                .mapList(this.reviewService.getAllReviews(), ReviewViewModel.class);
        model.addAttribute("reviews", reviews);
        return "reviews/reviews";
    }
}

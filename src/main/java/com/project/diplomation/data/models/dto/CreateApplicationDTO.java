package com.project.diplomation.data.models.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateApplicationDTO {
    private String topic;
    private String aims;
    private String problems;
    private String technologies;
    private long studentId;
    private long tutorId;
}

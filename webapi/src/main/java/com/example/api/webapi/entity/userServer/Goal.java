package com.example.api.webapi.entity.userServer;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    private int id;
    private int parentId;
    private String GoalName;
    private List<Goal> listGoal;
}

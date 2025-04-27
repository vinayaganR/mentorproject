package com.sppascm.project.controller;

import com.sppascm.project.model.Team;
import com.sppascm.project.service.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @PostMapping("/create")
    public Team createTeam(@RequestBody Map<String, Object> payload) {
        Long student1Id = ((Number) payload.get("student1Id")).longValue();
        Long student2Id = ((Number) payload.get("student2Id")).longValue();
        String teamName = (String) payload.get("teamName");
        return teamServices.createTeam(student1Id, student2Id, teamName);
    }

    @PostMapping("/assign-mentor")
    public Team assignMentor(@RequestBody Map<String, Object> payload) {
        Long teamId = ((Number) payload.get("teamId")).longValue();
        Long mentorId = ((Number) payload.get("mentorId")).longValue();
        return teamServices.assignMentor(teamId, mentorId);
    }

    @GetMapping("/student/{studentId}")
    public Optional<Team> getTeamByStudentId(@PathVariable Long studentId) {
        return teamServices.getTeamByStudentId(studentId);
    }
}
package com.sppascm.project.service;

import com.sppascm.project.model.Team;
import com.sppascm.project.model.Student;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.repository.TeamRepository;
import com.sppascm.project.repository.StudentRepository;
import com.sppascm.project.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TeamServices {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MentorRepository mentorRepository;

    public Team createTeam(Long student1Id, Long student2Id, String teamName) {
        Optional<Student> student1 = studentRepository.findById(student1Id);
        Optional<Student> student2 = studentRepository.findById(student2Id);

        if (student1.isEmpty() || student2.isEmpty()) {
            throw new RuntimeException("One or both students not found");
        }

        // Check if students are already in a team
        Optional<Team> existingTeam1 = teamRepository.findByStudent1IdOrStudent2Id(student1Id, student1Id);
        Optional<Team> existingTeam2 = teamRepository.findByStudent1IdOrStudent2Id(student2Id, student2Id);
        
        if (existingTeam1.isPresent() || existingTeam2.isPresent()) {
            throw new RuntimeException("One or both students are already in a team");
        }

        Team team = new Team();
        team.setStudent1(student1.get());
        team.setStudent2(student2.get());
        team.setTeamName(teamName);
        team.setMentorAssigned(false);

        return teamRepository.save(team);
    }

    public Team assignMentor(Long teamId, Long mentorId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Optional<Mentor> mentor = mentorRepository.findById(mentorId);

        if (team.isEmpty() || mentor.isEmpty()) {
            throw new RuntimeException("Team or Mentor not found");
        }

        Team existingTeam = team.get();
        Mentor existingMentor = mentor.get();

        if (existingMentor.getUsedSlots() >= existingMentor.getMaxSlots()) {
            throw new RuntimeException("Mentor is fully booked");
        }

        existingTeam.setMentor(existingMentor);
        existingTeam.setMentorAssigned(true);
        existingMentor.setUsedSlots(existingMentor.getUsedSlots() + 1);

        mentorRepository.save(existingMentor);
        return teamRepository.save(existingTeam);
    }

    public Optional<Team> getTeamByStudentId(Long studentId) {
        return teamRepository.findByStudent1IdOrStudent2Id(studentId, studentId);
    }
}
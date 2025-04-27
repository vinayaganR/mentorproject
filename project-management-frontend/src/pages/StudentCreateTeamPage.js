import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { createTeam, assignMentor, getTeamByStudentId } from '../services/teamService';
import { getAllMentors } from '../services/mentorService';

const StudentCreateTeamPage = () => {
    const [formData, setFormData] = useState({
        teamName: '',
        student2Id: '',
        mentorId: ''
    });
    const [mentors, setMentors] = useState([]);
    const [error, setError] = useState('');
    const [success, setSuccess] = useState('');
    const navigate = useNavigate();

    const loggedInStudentId = localStorage.getItem('kuId');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [mentorsResponse, teamResponse] = await Promise.all([
                    getAllMentors(),
                    getTeamByStudentId(loggedInStudentId)
                ]);
                
                setMentors(mentorsResponse.data);
                if (teamResponse.data) {
                    setError('You are already part of a team');
                }
            } catch (err) {
                setError('Failed to load initial data');
            }
        };
        fetchData();
    }, [loggedInStudentId]);

    const handleChange = (e) => {
        setFormData({...formData, [e.target.name]: e.target.value});
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setSuccess('');

        try {
            // Create team
            const teamResponse = await createTeam({
                student1Id: loggedInStudentId,
                student2Id: formData.student2Id,
                teamName: formData.teamName
            });

            // Assign mentor if selected
            if (formData.mentorId) {
                await assignMentor({
                    teamId: teamResponse.data.id,
                    mentorId: formData.mentorId
                });
            }

            setSuccess('Team created successfully!');
            setTimeout(() => navigate('/dashboard'), 2000);
        } catch (err) {
            setError(err.response?.data?.message || 'Team creation failed');
        }
    };

    return (
        <div className="container">
            <h2>Create Team</h2>
            {error && <div className="alert alert-danger">{error}</div>}
            {success && <div className="alert alert-success">{success}</div>}
            
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Team Name</label>
                    <input
                        type="text"
                        className="form-control"
                        name="teamName"
                        value={formData.teamName}
                        onChange={handleChange}
                        required
                    />
                </div>
                
                <div className="form-group">
                    <label>Teammate KU ID</label>
                    <input
                        type="text"
                        className="form-control"
                        name="student2Id"
                        value={formData.student2Id}
                        onChange={handleChange}
                        required
                    />
                </div>
                
                <div className="form-group">
                    <label>Select Mentor</label>
                    <select
                        className="form-control"
                        name="mentorId"
                        value={formData.mentorId}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Select a mentor</option>
                        {mentors.map(mentor => (
                            <option key={mentor.id} value={mentor.id}>
                                {mentor.name} (Slots: {mentor.maxSlots - mentor.usedSlots})
                            </option>
                        ))}
                    </select>
                </div>
                
                <button type="submit" className="btn btn-primary">
                    Create Team
                </button>
            </form>
        </div>
    );
};

export default StudentCreateTeamPage;
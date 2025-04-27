import React, { useState } from 'react';
import { registerMentor } from '../../services/mentorService';

const MentorRegisterPage = () => {
    const [mentor, setMentor] = useState({
        mentorId: '',
        password: '',
        maxSlots: 3
    });

    const handleChange = (e) => {
        setMentor({ ...mentor, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await registerMentor(mentor);
            alert('Mentor registered successfully!');
            setMentor({ mentorId: '', password: '', maxSlots: 0 });
        } catch (error) {
            alert('Registration failed');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Register Mentor</h2>
            <input type="text" name="mentorId" value={mentor.mentorId} onChange={handleChange} placeholder="Mentor ID" required />
            <input type="password" name="password" value={mentor.password} onChange={handleChange} placeholder="Password" required />
            <input type="number" name="maxSlots" value={mentor.maxSlots} onChange={handleChange} placeholder="Max Slots" required />
            <button type="submit">Register</button>
        </form>
    );
};

export default MentorRegisterPage;

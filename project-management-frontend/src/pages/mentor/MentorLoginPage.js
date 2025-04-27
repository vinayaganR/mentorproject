import React, { useState } from 'react';
import { loginMentor } from '../../services/mentorService';

const MentorLoginPage = () => {
    const [credentials, setCredentials] = useState({ mentorId: '', password: '' });

    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await loginMentor(credentials);
            alert(response.data); // "Login successful" or "Invalid credentials"
        } catch (error) {
            alert('Login failed');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Mentor Login</h2>
            <input type="text" name="mentorId" value={credentials.mentorId} onChange={handleChange} placeholder="Mentor ID" required />
            <input type="password" name="password" value={credentials.password} onChange={handleChange} placeholder="Password" required />
            <button type="submit">Login</button>
        </form>
    );
};

export default MentorLoginPage;

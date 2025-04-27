import React, { useEffect, useState } from 'react';
import { getMentorById, updateMentor } from '../../services/mentorService';

const MentorUpdatePage = ({ id }) => {
    const [mentor, setMentor] = useState(null);

    useEffect(() => {
        getMentorById(id).then(response => setMentor(response.data));
    }, [id]);

    const handleChange = (e) => {
        setMentor({ ...mentor, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await updateMentor(id, mentor);
            alert('Mentor updated successfully!');
        } catch (err) {
            alert('Update failed');
        }
    };

    if (!mentor) return <div>Loading...</div>;

    return (
        <form onSubmit={handleSubmit}>
            <h2>Update Mentor</h2>
            <input type="text" name="mentorId" value={mentor.mentorId} onChange={handleChange} disabled />
            <input type="password" name="password" value={mentor.password} onChange={handleChange} required />
            <input type="number" name="maxSlots" value={mentor.maxSlots} onChange={handleChange} required />
            <input type="number" name="usedSlots" value={mentor.usedSlots} onChange={handleChange} required />
            <button type="submit">Update</button>
        </form>
    );
};

export default MentorUpdatePage;

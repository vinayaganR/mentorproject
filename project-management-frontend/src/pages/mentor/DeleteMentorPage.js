import React, { useState } from 'react';
import { deleteMentor } from '../../services/mentorService';

const DeleteMentorPage = () => {
    const [id, setId] = useState('');

    const handleDelete = async () => {
        try {
            await deleteMentor(id);
            alert('Mentor deleted successfully!');
        } catch (error) {
            alert('Deletion failed or Mentor not found');
        }
    };

    return (
        <div>
            <h2>Delete Mentor</h2>
            <input type="number" value={id} onChange={(e) => setId(e.target.value)} placeholder="Mentor DB ID" />
            <button onClick={handleDelete}>Delete</button>
        </div>
    );
};

export default DeleteMentorPage;

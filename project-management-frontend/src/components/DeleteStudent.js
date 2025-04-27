// src/components/DeleteStudent.js
import React, { useState } from 'react';
import { deleteStudent } from '../services/studentService';

const DeleteStudent = () => {
  const [kuId, setKuId] = useState('');
  const [message, setMessage] = useState('');

  const handleDelete = async () => {
    try {
      const response = await deleteStudent(kuId);
      setMessage(response.data);
    } catch (error) {
      setMessage(error.response?.data || 'Deletion failed');
    }
  };

  return (
    <div>
      <h2>Delete Student</h2>
      <input
        type="text"
        placeholder="KU ID"
        value={kuId}
        onChange={(e) => setKuId(e.target.value)}
      />
      <button onClick={handleDelete}>Delete Student</button>
      <p>{message}</p>
    </div>
  );
};

export default DeleteStudent;

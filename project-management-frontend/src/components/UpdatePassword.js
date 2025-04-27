// src/components/UpdatePassword.js
import React, { useState } from 'react';
import { updatePassword } from '../services/studentService';

const UpdatePassword = () => {
  const [kuId, setKuId] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleUpdate = async () => {
    try {
      const response = await updatePassword(kuId, newPassword);
      setMessage(response.data);
    } catch (error) {
      setMessage(error.response?.data || 'Password update failed');
    }
  };

  return (
    <div>
      <h2>Update Password</h2>
      <input
        type="text"
        placeholder="KU ID"
        value={kuId}
        onChange={(e) => setKuId(e.target.value)}
      />
      <input
        type="password"
        placeholder="New Password"
        value={newPassword}
        onChange={(e) => setNewPassword(e.target.value)}
      />
      <button onClick={handleUpdate}>Update Password</button>
      <p>{message}</p>
    </div>
  );
};

export default UpdatePassword;

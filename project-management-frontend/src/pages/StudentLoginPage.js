// src/pages/StudentLoginPage.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import Login from '../components/Login';

const StudentLoginPage = () => {
  const navigate = useNavigate();

  const handleLoginSuccess = () => {
    navigate('/create-team');
  };

  return (
    <div>
      <h1>Welcome to the Student Portal</h1>
      <Login onLoginSuccess={handleLoginSuccess} />
    </div>
  );
};

export default StudentLoginPage;

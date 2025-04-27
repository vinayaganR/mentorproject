// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

// Student Pages
import StudentLoginPage from './pages/StudentLoginPage';
import StudentRegisterPage from './pages/StudentRegisterPage';
import UpdatePasswordPage from './pages/UpdatePasswordPage';
import DeleteStudentPage from './pages/DeleteStudentPage';
import StudentCreateTeamPage from './pages/StudentCreateTeamPage'; // ✅ Corrected import

// Mentor Pages
import MentorRegisterPage from './pages/mentor/MentorRegisterPage';
import MentorLoginPage from './pages/mentor/MentorLoginPage';
import DeleteMentorPage from './pages/mentor/DeleteMentorPage';
import MentorUpdateForm from './components/MentorUpdateForm';

function App() {
  return (
    <Router>
      <div>
        {/* Navigation Bar */}
        <nav>
          <h3>Student</h3>
          <Link to="/">Login</Link> |{" "}
          <Link to="/register">Register</Link> |{" "}
          <Link to="/update-password">Update Password</Link> |{" "}
          <Link to="/delete-student">Delete Student</Link> |{" "}
          <Link to="/create-team">Create Team</Link> {/* ✅ Nav link */}

          <h3>Mentor</h3>
          <Link to="/mentor/login">Login</Link> |{" "}
          <Link to="/mentor/register">Register</Link> |{" "}
          <Link to="/mentor/update/1">Update</Link> |{" "}
          <Link to="/mentor/delete">Delete</Link>
        </nav>

        {/* Routing Configuration */}
        <Routes>
          {/* Student Routes */}
          <Route path="/" element={<StudentLoginPage />} />
          <Route path="/register" element={<StudentRegisterPage />} />
          <Route path="/update-password" element={<UpdatePasswordPage />} />
          <Route path="/delete-student" element={<DeleteStudentPage />} />
          <Route path="/create-team" element={<StudentCreateTeamPage />} /> {/* ✅ Fixed component */}

          {/* Mentor Routes */}
          <Route path="/mentor/register" element={<MentorRegisterPage />} />
          <Route path="/mentor/login" element={<MentorLoginPage />} />
          <Route path="/mentor/update/:id" element={<MentorUpdateForm />} />
          <Route path="/mentor/delete" element={<DeleteMentorPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

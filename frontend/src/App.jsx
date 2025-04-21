import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import MentorLogin from "./pages/MentorLogin.jsx";
import StudentLogin from "./pages/StudentLogin.jsx";
import MentorRegister from "./pages/MentorRegister.jsx";
import StudentRegister from "./pages/StudentRegister.jsx";
import Register from "./pages/Register.jsx";

function App() {
  return (
    <Router>
      <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-5">
        <h1 className="text-3xl font-bold mb-5">SPPASC Login System</h1>
        <nav className="flex space-x-4 mb-5">
          <Link className="px-4 py-2 bg-blue-500 text-white rounded" to="/student/login">
            Student Login
          </Link>
          <Link className="px-4 py-2 bg-green-500 text-white rounded" to="/mentor/login">
            Mentor Login
          </Link>
          <Link className="px-4 py-2 bg-gray-500 text-white rounded" to="/register">
            Register
          </Link>
        </nav>
        <Routes>
          <Route path="/student/login" element={<StudentLogin />} />
          <Route path="/mentor/login" element={<MentorLogin />} />
          <Route path="/student/register" element={<StudentRegister />} />
          <Route path="/mentor/register" element={<MentorRegister />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

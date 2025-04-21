import React from "react";
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h2 className="text-2xl font-bold mb-4">Login</h2>
      <Link to="/student/login" className="bg-blue-500 text-white px-4 py-2 rounded mb-2">
        Student Login
      </Link>
      <Link to="/mentor/login" className="bg-green-500 text-white px-4 py-2 rounded">
        Mentor Login
      </Link>
    </div>
  );
};

export default Login;

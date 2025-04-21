import React from "react";
import { Link } from "react-router-dom";

const Register = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h2 className="text-2xl font-bold mb-4">Register</h2>
      <Link
        to="/student/register"
        className="bg-blue-500 text-white px-4 py-2 rounded mb-2"
      >
        Register as Student
      </Link>
      <Link
        to="/mentor/register"
        className="bg-green-500 text-white px-4 py-2 rounded"
      >
        Register as Mentor
      </Link>
    </div>
  );
};

export default Register;

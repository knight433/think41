import React, { useState } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Login from './Login';
import Chat from './Chat';

function App() {
  const [username, setUsername] = useState('');

  return (
    <Routes>
      <Route
        path="/"
        element={<Login setUsername={setUsername} />}
      />
      <Route
        path="/chat"
        element={username ? <Chat username={username} /> : <Navigate to="/" />}
      />
    </Routes>
  );
}

export default App;

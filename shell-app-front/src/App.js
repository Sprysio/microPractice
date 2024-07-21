import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import HomePage from './components/Home';

function App() {
  const handleNavigation = (url) => {
    window.location.href = url;
  };

  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <a href="/users/" onClick={(e) => { e.preventDefault(); handleNavigation('/users/'); }}>User App</a>
            </li>
            <li>
              <a href="/products/" onClick={(e) => { e.preventDefault(); handleNavigation('/products/'); }}>Product App</a>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<HomePage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

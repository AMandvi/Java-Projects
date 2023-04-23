import './App.css';
import LoginForm from './components/LoginForm';
import Dashboard from './components/Dashboard';
import {Route, Routes} from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
        <Routes>
            <Route path="/login" element={<LoginForm/>}/>
            <Route path="/dashboard" element={<Dashboard/>}/>
        </Routes>
    </div>
  );
}

export default App;

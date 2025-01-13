import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
// import App from './App.jsx'
import TrainingList from "./TrainingList.jsx";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <TrainingList />
  </StrictMode>,
)
